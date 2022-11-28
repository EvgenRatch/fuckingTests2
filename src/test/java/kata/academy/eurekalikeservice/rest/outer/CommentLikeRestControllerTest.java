package kata.academy.eurekalikeservice.rest.outer;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import kata.academy.eurekalikeservice.feign.ContentServiceFeignClient;
import kata.academy.eurekalikeservice.service.CommentLikeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CommentLikeRestController.class})
@ExtendWith(SpringExtension.class)
class CommentLikeRestControllerTest {
    @Autowired
    private CommentLikeRestController commentLikeRestController;

    @MockBean
    private CommentLikeService commentLikeService;

    @MockBean
    private ContentServiceFeignClient contentServiceFeignClient;

    /**
     * Method under test: {@link CommentLikeRestController#getPostLikeCount(Long, Boolean)}
     */
    @Test
    void testGetPostLikeCount() throws Exception {
        when(commentLikeService.countByCommentIdAndPositive((Long) any(), (Boolean) any())).thenReturn(3);
        when(contentServiceFeignClient.existsByCommentId((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/likes/comments/{commentId}/count",
                123L);
        MockHttpServletRequestBuilder requestBuilder = getResult.param("positive", String.valueOf(true));
        MockMvcBuilders.standaloneSetup(commentLikeRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"data\":3}"));
    }
}

