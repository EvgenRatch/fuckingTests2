package kata.academy.eurekalikeservice.service.impl;

import kata.academy.eurekalikeservice.model.entity.PostLike;
import kata.academy.eurekalikeservice.repository.PostLikeRepository;
import kata.academy.eurekalikeservice.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@CacheConfig(cacheNames = "post-like-count")
@Transactional
@Service
public class PostLikeServiceImpl implements PostLikeService {
    private final PostLikeRepository postLikeRepository;

    @CacheEvict(key = "#postLike.postId + '-' + #postLike.positive")
    @Override
    public PostLike addPostLike(PostLike postLike) {
        return postLikeRepository.save(postLike);
    }

    @Caching(evict = {
            @CacheEvict(key = "#postLike.postId + '-' + true"),
            @CacheEvict(key = "#postLike.postId + '-' + false")
    })
    @Override
    public PostLike updatePostLike(PostLike postLike) {
        return postLikeRepository.save(postLike);
    }

    @CacheEvict(key = "#postLike.postId + '-' + #postLike.positive")
    @Override
    public void delete(PostLike postLike) {
        postLikeRepository.delete(postLike);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Long> getTopPostIdsByCount(Integer count) {
        return postLikeRepository.getTopPostIdsByCount(count);
    }

    @Caching(evict = {
            @CacheEvict(key = "#postId + '-' + true"),
            @CacheEvict(key = "#postId + '-' + false")
    })
    @Override
    public void deleteByPostId(Long postId) {
        postLikeRepository.deleteByPostId(postId);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByPostIdAndUserId(Long postId, Long userId) {
        return postLikeRepository.existsByPostIdAndUserId(postId, userId);
    }

    @Cacheable(key = "#postId + '-' + #positive", unless = "#result < 100")
    @Transactional(readOnly = true)
    @Override
    public int countByPostIdAndPositive(Long postId, Boolean positive) {
        return postLikeRepository.countByPostIdAndPositive(postId, positive);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PostLike> findByPostIdAndUserId(Long postId, Long userId) {
        return postLikeRepository.findByPostIdAndUserId(postId, userId);
    }
}
