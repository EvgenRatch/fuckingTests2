package kata.academy.eurekalikeservice.repository;

import kata.academy.eurekalikeservice.model.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

    Optional<CommentLike> findByCommentIdAndUserId(Long commentId, Long userId);

    boolean existsByCommentIdAndUserId(Long commentId, Long userId);

    @Modifying
    @Query("""
            DELETE
            FROM CommentLike cl
            WHERE cl.commentId = :commentId
                                """)
    void deleteByCommentId(Long commentId);

    int countByCommentIdAndPositive(Long commentId, Boolean positive);
}
