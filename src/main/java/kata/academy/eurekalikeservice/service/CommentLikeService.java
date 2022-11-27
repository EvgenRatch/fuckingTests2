package kata.academy.eurekalikeservice.service;

import kata.academy.eurekalikeservice.model.entity.CommentLike;

import java.util.List;
import java.util.Optional;

public interface CommentLikeService {

    void addCommentLike(CommentLike commentLike);

    void updateCommentLike(CommentLike commentLike);

    void delete(CommentLike commentLike);

    void deleteByCommentId(Long commentId);

    Optional<CommentLike> findByCommentIdAndUserId(Long commentId, Long userId);

    void deleteAllByCommentIds(List<Long> commentIds);

    boolean existsByCommentIdAndUserId(Long commentId, Long userId);

    int countByCommentIdAndPositive(Long commentId, Boolean positive);
}
