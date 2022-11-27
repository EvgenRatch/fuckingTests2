package kata.academy.eurekalikeservice.rest.outer;

import kata.academy.eurekalikeservice.api.Data;
import kata.academy.eurekalikeservice.feign.ContentServiceFeignClient;
import kata.academy.eurekalikeservice.model.entity.PostLike;
import kata.academy.eurekalikeservice.service.PostLikeService;
import kata.academy.eurekalikeservice.util.ApiValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.Optional;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/v1/likes/posts")
public class PostLikeRestController {

    private final PostLikeService postLikeService;
    private final ContentServiceFeignClient contentServiceFeignClient;

    @PostMapping("/{postId}")
    public ResponseEntity<PostLike> addPostLike(@RequestParam Boolean positive,
                                                @PathVariable @Positive Long postId,
                                                @RequestHeader @Positive Long userId) {
        ApiValidationUtil.requireTrue(contentServiceFeignClient.existsByPostId(postId),
                String.format("Пост с таким postId %d не существует в базе данных", postId));
        ApiValidationUtil.requireFalse(postLikeService.existsByPostIdAndUserId(postId, userId),
                String.format("Пользователь userId %d уже лайкнул пост postId %d", userId, postId));
        PostLike postLike = PostLike
                .builder()
                .positive(positive)
                .postId(postId)
                .userId(userId)
                .build();
        return ResponseEntity.ok(postLikeService.addPostLike(postLike));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostLike> updatePostLike(@RequestParam Boolean positive,
                                                   @PathVariable @Positive Long postId,
                                                   @RequestHeader @Positive Long userId) {
        Optional<PostLike> postLikeOptional = postLikeService.findByPostIdAndUserId(postId, userId);
        ApiValidationUtil.requireTrue(postLikeOptional.isPresent(),
                String.format("Лайк с postId %d, userId %d нет в базе данных", postId, userId));
        PostLike postLike = postLikeOptional.get();
        postLike.setPositive(positive);
        return ResponseEntity.ok(postLikeService.updatePostLike(postLike));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePostLike(@PathVariable @Positive Long postId,
                                               @RequestHeader @Positive Long userId) {
        Optional<PostLike> postLikeOptional = postLikeService.findByPostIdAndUserId(postId, userId);
        ApiValidationUtil.requireTrue(postLikeOptional.isPresent(),
                String.format("Лайк с postId %d, userId %d нет в базе данных", postId, userId));
        postLikeService.delete(postLikeOptional.get());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{postId}/count")
    public ResponseEntity<Data<Integer>> getPostLikeCount(@PathVariable @Positive Long postId,
                                                          @RequestParam Boolean positive) {
        ApiValidationUtil.requireTrue(contentServiceFeignClient.existsByPostId(postId),
                String.format("Пост с таким postId %d не существует в базе данных", postId));
        return ResponseEntity.ok(Data.of(postLikeService.countByPostIdAndPositive(postId, positive)));
    }
}
