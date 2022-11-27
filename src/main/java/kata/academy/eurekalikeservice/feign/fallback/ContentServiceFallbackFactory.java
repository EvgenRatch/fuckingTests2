package kata.academy.eurekalikeservice.feign.fallback;

import kata.academy.eurekalikeservice.feign.ContentServiceFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ContentServiceFallbackFactory implements FallbackFactory<ContentServiceFeignClient> {

    @Override
    public ContentServiceFeignClient create(Throwable cause) {
        return new ContentServiceFallback(cause);
    }
}
