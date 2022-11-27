package kata.academy.eurekalikeservice.service.impl;

import kata.academy.eurekalikeservice.model.entity.CommentLike;
import kata.academy.eurekalikeservice.repository.CommentLikeRepository;
import kata.academy.eurekalikeservice.service.CommentLikeService;
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
@CacheConfig(cacheNames = "comment-like-count")
@Transactional
@Service
public class CommentLikeServiceImpl implements CommentLikeService {

    private final CommentLikeRepository commentLikeRepository;

    @CacheEvict(key = "#commentLike.commentId + '-' + #commentLike.positive")
    @Override
    public void addCommentLike(CommentLike commentLike) {
        commentLikeRepository.save(commentLike);
    }

    @Caching(evict = {
            @CacheEvict(key = "#commentLike.commentId + '-' + true"),
            @CacheEvict(key = "#commentLike.commentId + '-' + false")
    })
    @Override
    public void updateCommentLike(CommentLike commentLike) {
        commentLikeRepository.save(commentLike);
    }

    @CacheEvict(key = "#commentLike.commentId + '-' + #commentLike.positive")
    @Override
    public void delete(CommentLike commentLike) {
        commentLikeRepository.delete(commentLike);
    }

    @Caching(evict = {
            @CacheEvict(key = "#commentId + '-' + true"),
            @CacheEvict(key = "#commentId + '-' + false")
    })
    @Override
    public void deleteByCommentId(Long commentId) {
        commentLikeRepository.deleteByCommentId(commentId);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CommentLike> findByCommentIdAndUserId(Long commentId, Long userId) {
        return commentLikeRepository.findByCommentIdAndUserId(commentId, userId);
    }

    @Override
    public void deleteAllByCommentIds(List<Long> commentIds) {
        for (Long commentId : commentIds) {
            deleteByCommentId(commentId);
        }
    }

    @Cacheable(key = "#commentId + '-' + #positive", unless = "#result < 100")
    @Transactional(readOnly = true)
    @Override
    public int countByCommentIdAndPositive(Long commentId, Boolean positive) {
        return commentLikeRepository.countByCommentIdAndPositive(commentId, positive);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByCommentIdAndUserId(Long commentId, Long userId) {
        return commentLikeRepository.existsByCommentIdAndUserId(commentId, userId);
    }
}
