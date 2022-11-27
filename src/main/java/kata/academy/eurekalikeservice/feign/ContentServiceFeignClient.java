package kata.academy.eurekalikeservice.feign;

import kata.academy.eurekalikeservice.feign.fallback.ContentServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Positive;

@FeignClient(value = "eureka-content-service", fallbackFactory = ContentServiceFallbackFactory.class)
public interface ContentServiceFeignClient {

    @GetMapping("/api/internal/v1/content/comments/{commentId}/exists")
    Boolean existsByCommentId(@PathVariable @Positive Long commentId);

    @GetMapping("/api/internal/v1/content/posts/{postId}/exists")
    Boolean existsByPostId(@PathVariable @Positive Long postId);
}
