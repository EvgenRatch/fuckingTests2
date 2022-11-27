package kata.academy.eurekalikeservice.rest.inner;

import kata.academy.eurekalikeservice.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/internal/v1/likes/posts")
public class PostLikeInternalRestController {

    private final PostLikeService postLikeService;

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteByPostId(@PathVariable @Positive Long postId) {
        postLikeService.deleteByPostId(postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<Long>> getTopPostIdsByCount(@RequestParam(defaultValue = "100") @Positive Integer count) {
        return ResponseEntity.ok(postLikeService.getTopPostIdsByCount(count));
    }
}
