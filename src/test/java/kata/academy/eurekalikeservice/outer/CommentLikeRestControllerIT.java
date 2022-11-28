package kata.academy.eurekalikeservice.outer;

import kata.academy.eurekalikeservice.SpringSimpleContextTest;
import kata.academy.eurekalikeservice.feign.ContentServiceFeignClient;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockBeans({
        @MockBean(ContentServiceFeignClient.class)
})
public class CommentLikeRestControllerIT extends SpringSimpleContextTest {

    @Autowired
    private ContentServiceFeignClient contentServiceFeignClient;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "/scripts/outer/CommentLikeRestController/addCommentLike_SuccessfulTest/After.sql")
    public void addCommentLike_SuccessfulTest() throws Exception {
        Long commentId = 1L;
        Long userId = 1L;
        doReturn(Boolean.TRUE).when(contentServiceFeignClient).existsByCommentId(commentId);
        boolean positive = true;
        mockMvc.perform(post("/api/v1/likes/comments/{commentId}", commentId)
                        .header("userId", userId.toString())
                        .param("positive", String.valueOf(positive))
                        .contentType(MediaType.APPLICATION_JSON));
        assertTrue(entityManager.createQuery(
                        """
                                SELECT COUNT(cl.id) > 0
                                FROM CommentLike cl
                                WHERE cl.commentId = :commentId
                                AND cl.userId = :userId
                                AND cl.positive = :positive
                                """, Boolean.class)
                .setParameter("commentId", commentId)
                .setParameter("userId", userId)
                .setParameter("positive", positive)
                .getSingleResult());
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "/scripts/outer/CommentLikeRestController/addCommentLike_CommentLikeExistsTest/Before.sql")
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "/scripts/outer/CommentLikeRestController/addCommentLike_CommentLikeExistsTest/After.sql")
    public void addCommentLike_CommentLikeExistsTest() throws Exception {
        Long commentId = 1L;
        Long userId = 1L;
        doReturn(Boolean.TRUE).when(contentServiceFeignClient).existsByCommentId(commentId);
        mockMvc.perform(post("/api/v1/likes/comments/{commentId}", commentId)
                        .header("userId", userId.toString())
                        .param("positive", String.valueOf(true))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.text", Is.is(
                        String.format("Пользователь userId %d уже лайкнул комментарий commentId %d",
                                commentId, userId)
                )));
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "/scripts/outer/CommentLikeRestController/addCommentLike_CommentLikeExistsTest/Before.sql")
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "/scripts/outer/CommentLikeRestController/addCommentLike_CommentLikeExistsTest/After.sql")
    public void updateCommentLike_SuccessfulTest() throws Exception {
        Long commentId = 1L;
        long userId = 1L;
        doReturn(Boolean.TRUE).when(contentServiceFeignClient).existsByCommentId(commentId);
        mockMvc.perform(put("/api/v1/likes/comments/{commentId}", commentId)
                        .header("userId", Long.toString(userId))
                        .param("positive", String.valueOf(true))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertTrue(entityManager.createQuery(
                        """
                                SELECT COUNT(cl.id) > 0
                                FROM CommentLike cl
                                WHERE cl.commentId = :commentId
                                AND cl.userId = :userId 
                                """, Boolean.class)
                .setParameter("commentId", commentId)
                .setParameter("userId", userId)
                .getSingleResult());
    }

    @Test
    public void deleteCommentLike_CommentLikeFailTest() throws Exception {
        long commentId = 10L;
        long userId = 1L;
        doReturn(Boolean.TRUE).when(contentServiceFeignClient).existsByCommentId(commentId);
        mockMvc.perform(delete("/api/v1/likes/comments/{commentId}", commentId)
                        .header("userId", Long.toString(userId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.text", Is.is(
                        String.format("Комментарий с commentId %d, userId %d не найден в базе данных", commentId, userId)
                )));
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, value = "/scripts/outer/CommentLikeRestController/getCommentLikeCount_SuccessfulTest/Before.sql")
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "/scripts/outer/CommentLikeRestController/getCommentLikeCount_SuccessfulTest/After.sql")
    public void getCommentLikeCount_SuccessfulTest() throws Exception {
        long commentId = 2L;
        String positiveState = String.valueOf(true);
        int result = 1;
        doReturn(Boolean.TRUE).when(contentServiceFeignClient).existsByCommentId(commentId);
        mockMvc.perform(get("/api/v1/likes/comments/{commentId}/count", commentId)
                        .param("positive", positiveState)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data", Is.is(result)));
    }


}
