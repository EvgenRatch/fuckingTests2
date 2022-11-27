package kata.academy.eurekalikeservice.repository;

import kata.academy.eurekalikeservice.model.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    boolean existsByPostIdAndUserId(Long postId, Long userId);

    @Modifying
    @Query("""
            DELETE
            FROM PostLike pl
            WHERE pl.postId = :postId
                                """)
    void deleteByPostId(Long postId);

    @Query(nativeQuery = true, value =
            """
                    SELECT pl.post_id
                    FROM post_likes pl
                    WHERE pl.positive = true
                    GROUP BY pl.post_id
                    ORDER BY COUNT(pl.id) DESC
                    LIMIT :count
                    """)
    List<Long> getTopPostIdsByCount(Integer count);

    int countByPostIdAndPositive(Long postId, Boolean positive);

    Optional<PostLike> findByPostIdAndUserId(Long postId, Long userId);
}
