package kata.academy.eurekalikeservice.rest.outer;

import kata.academy.eurekalikeservice.api.Data;
import kata.academy.eurekalikeservice.feign.ContentServiceFeignClient;
import kata.academy.eurekalikeservice.model.entity.CommentLike;
import kata.academy.eurekalikeservice.service.CommentLikeService;
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
@RequestMapping("/api/v1/likes/comments")
public class CommentLikeRestController {

    private final CommentLikeService commentLikeService;
    private final ContentServiceFeignClient contentServiceFeignClient;

    @PostMapping("/{commentId}")
    public ResponseEntity<Void> addCommentLike(@RequestParam Boolean positive,
                                               @PathVariable @Positive Long commentId,
                                               @RequestHeader @Positive Long userId) {
        ApiValidationUtil.requireTrue(contentServiceFeignClient.existsByCommentId(commentId),
                String.format("Комментарий с таким commentId %d не существует в базе данных", commentId));
        ApiValidationUtil.requireFalse(commentLikeService.existsByCommentIdAndUserId(commentId, userId),
                String.format("Пользователь userId %d уже лайкнул комментарий commentId %d", userId, commentId));
        CommentLike commentLike = CommentLike
                .builder()
                .positive(positive)
                .commentId(commentId)
                .userId(userId)
                .build();
        commentLikeService.addCommentLike(commentLike);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Void> updateCommentLike(@RequestParam Boolean positive,
                                                  @PathVariable @Positive Long commentId,
                                                  @RequestHeader @Positive Long userId) {
        Optional<CommentLike> commentLikeOptional = commentLikeService.findByCommentIdAndUserId(commentId, userId);
        ApiValidationUtil.requireTrue(commentLikeOptional.isPresent(), String.format("Лайк с commentId %d, userId %d нет в базе данных", commentId, userId));
        CommentLike commentLike = commentLikeOptional.get();
        commentLike.setPositive(positive);
        commentLikeService.updateCommentLike(commentLike);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteCommentLike(@PathVariable @Positive Long commentId,
                                                  @RequestHeader @Positive Long userId) {
        Optional<CommentLike> commentLikeOptional = commentLikeService.findByCommentIdAndUserId(commentId, userId);
        ApiValidationUtil.requireTrue(commentLikeOptional.isPresent(), String.format("Комментарий с commentId %d, userId %d не найден в базе данных", commentId, userId));
        commentLikeService.delete(commentLikeOptional.get());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{commentId}/count")
    public ResponseEntity<Data<Integer>> getPostLikeCount(@PathVariable @Positive Long commentId,
                                                          @RequestParam Boolean positive) {
        ApiValidationUtil.requireTrue(contentServiceFeignClient.existsByCommentId(commentId), String.format("Комментарий с таким commentId %d не существует в базе данных", commentId));
        return ResponseEntity.ok(Data.of(commentLikeService.countByCommentIdAndPositive(commentId, positive)));
    }
}
