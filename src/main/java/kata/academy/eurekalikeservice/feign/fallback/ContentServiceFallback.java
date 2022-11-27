package kata.academy.eurekalikeservice.feign.fallback;

import kata.academy.eurekalikeservice.exception.FeignRequestException;
import kata.academy.eurekalikeservice.feign.ContentServiceFeignClient;

record ContentServiceFallback(Throwable cause) implements ContentServiceFeignClient {

    @Override
    public Boolean existsByCommentId(Long commentId) {
        throw new FeignRequestException("Сервис временно недоступен. Причина -> %s".formatted(cause.getMessage()), cause);
    }

    @Override
    public Boolean existsByPostId(Long postId) {
        throw new FeignRequestException("Сервис временно недоступен. Причина -> %s".formatted(cause.getMessage()), cause);
    }
}
