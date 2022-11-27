package kata.academy.eurekalikeservice.init;

import kata.academy.eurekalikeservice.model.entity.CommentLike;
import kata.academy.eurekalikeservice.model.entity.PostLike;
import kata.academy.eurekalikeservice.service.CommentLikeService;
import kata.academy.eurekalikeservice.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Profile("dev")
public class ApplicationRunnerImpl implements ApplicationRunner {

    private final CommentLikeService commentLikeService;
    private final PostLikeService postLikeService;

    @Override
    public void run(ApplicationArguments args) {
        PostLike postLike1 = new PostLike();
        postLike1.setPostId(1L);
        postLike1.setUserId(1L);
        postLike1.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike1);

        PostLike postLike2 = new PostLike();
        postLike2.setPostId(2L);
        postLike2.setUserId(2L);
        postLike2.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike2);

        PostLike postLike3 = new PostLike();
        postLike3.setPostId(2L);
        postLike3.setUserId(3L);
        postLike3.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike3);

        PostLike postLike4 = new PostLike();
        postLike4.setPostId(3L);
        postLike4.setUserId(4L);
        postLike4.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike4);

        PostLike postLike5 = new PostLike();
        postLike5.setPostId(3L);
        postLike5.setUserId(5L);
        postLike5.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike5);

        PostLike postLike6 = new PostLike();
        postLike6.setPostId(3L);
        postLike6.setUserId(1L);
        postLike6.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike6);

        PostLike postLike7 = new PostLike();
        postLike7.setPostId(4L);
        postLike7.setUserId(4L);
        postLike7.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike7);

        PostLike postLike8 = new PostLike();
        postLike8.setPostId(4L);
        postLike8.setUserId(7L);
        postLike8.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike8);

        PostLike postLike9 = new PostLike();
        postLike9.setPostId(5L);
        postLike9.setUserId(8L);
        postLike9.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike9);

        PostLike postLike10 = new PostLike();
        postLike10.setPostId(6L);
        postLike10.setUserId(10L);
        postLike10.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike10);

        PostLike postLike11 = new PostLike();
        postLike11.setPostId(6L);
        postLike11.setUserId(5L);
        postLike11.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike11);

        PostLike postLike12 = new PostLike();
        postLike12.setPostId(7L);
        postLike12.setUserId(11L);
        postLike12.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike12);

        PostLike postLike13 = new PostLike();
        postLike13.setPostId(7L);
        postLike13.setUserId(12L);
        postLike13.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike13);

        PostLike postLike14 = new PostLike();
        postLike14.setPostId(8L);
        postLike14.setUserId(14L);
        postLike14.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike14);

        PostLike postLike15 = new PostLike();
        postLike15.setPostId(8L);
        postLike15.setUserId(16L);
        postLike15.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike15);

        PostLike postLike16 = new PostLike();
        postLike16.setPostId(8L);
        postLike16.setUserId(17L);
        postLike16.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike16);

        PostLike postLike17 = new PostLike();
        postLike17.setPostId(8L);
        postLike17.setUserId(1L);
        postLike17.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike17);

        PostLike postLike18 = new PostLike();
        postLike18.setPostId(9L);
        postLike18.setUserId(22L);
        postLike18.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike18);

        PostLike postLike19 = new PostLike();
        postLike19.setPostId(9L);
        postLike19.setUserId(23L);
        postLike19.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike19);

        PostLike postLike20 = new PostLike();
        postLike20.setPostId(10L);
        postLike20.setUserId(30L);
        postLike20.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike20);

        PostLike postLike21 = new PostLike();
        postLike21.setPostId(11L);
        postLike21.setUserId(27L);
        postLike21.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike21);

        PostLike postLike22 = new PostLike();
        postLike22.setPostId(12L);
        postLike22.setUserId(27L);
        postLike22.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike22);

        PostLike postLike23 = new PostLike();
        postLike23.setPostId(12L);
        postLike23.setUserId(2L);
        postLike23.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike23);

        PostLike postLike24 = new PostLike();
        postLike24.setPostId(12L);
        postLike24.setUserId(1L);
        postLike24.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike24);

        PostLike postLike25 = new PostLike();
        postLike25.setPostId(12L);
        postLike25.setUserId(3L);
        postLike25.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike25);

        PostLike postLike26 = new PostLike();
        postLike26.setPostId(11L);
        postLike26.setUserId(5L);
        postLike26.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike26);

        PostLike postLike27 = new PostLike();
        postLike27.setPostId(11L);
        postLike27.setUserId(2L);
        postLike27.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike27);

        PostLike postLike28 = new PostLike();
        postLike28.setPostId(11L);
        postLike28.setUserId(1L);
        postLike28.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike28);

        PostLike postLike29 = new PostLike();
        postLike29.setPostId(10L);
        postLike29.setUserId(2L);
        postLike29.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike29);

        PostLike postLike30 = new PostLike();
        postLike30.setPostId(10L);
        postLike30.setUserId(23L);
        postLike30.setPositive(!(Math.random() < 0.5));
        postLikeService.addPostLike(postLike30);

        CommentLike commentLike1 = new CommentLike();
        commentLike1.setCommentId(1L);
        commentLike1.setUserId(1L);
        commentLike1.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike1);

        CommentLike commentLike2 = new CommentLike();
        commentLike2.setCommentId(2L);
        commentLike2.setUserId(2L);
        commentLike2.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike2);

        CommentLike commentLike3 = new CommentLike();
        commentLike3.setCommentId(2L);
        commentLike3.setUserId(4L);
        commentLike3.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike3);

        CommentLike commentLike4 = new CommentLike();
        commentLike4.setCommentId(3L);
        commentLike4.setUserId(5L);
        commentLike4.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike4);

        CommentLike commentLike5 = new CommentLike();
        commentLike5.setCommentId(3L);
        commentLike5.setUserId(7L);
        commentLike5.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike5);

        CommentLike commentLike6 = new CommentLike();
        commentLike6.setCommentId(3L);
        commentLike6.setUserId(6L);
        commentLike6.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike6);

        CommentLike commentLike7 = new CommentLike();
        commentLike7.setCommentId(4L);
        commentLike7.setUserId(7L);
        commentLike7.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike7);

        CommentLike commentLike8 = new CommentLike();
        commentLike8.setCommentId(4L);
        commentLike8.setUserId(8L);
        commentLike8.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike8);

        CommentLike commentLike9 = new CommentLike();
        commentLike9.setCommentId(5L);
        commentLike9.setUserId(11L);
        commentLike9.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike9);

        CommentLike commentLike10 = new CommentLike();
        commentLike10.setCommentId(6L);
        commentLike10.setUserId(12L);
        commentLike10.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike10);

        CommentLike commentLike11 = new CommentLike();
        commentLike11.setCommentId(6L);
        commentLike11.setUserId(1L);
        commentLike11.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike11);

        CommentLike commentLike12 = new CommentLike();
        commentLike12.setCommentId(6L);
        commentLike12.setUserId(2L);
        commentLike12.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike12);

        CommentLike commentLike13 = new CommentLike();
        commentLike13.setCommentId(6L);
        commentLike13.setUserId(22L);
        commentLike13.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike13);

        CommentLike commentLike14 = new CommentLike();
        commentLike14.setCommentId(7L);
        commentLike14.setUserId(30L);
        commentLike14.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike14);

        CommentLike commentLike15 = new CommentLike();
        commentLike15.setCommentId(7L);
        commentLike15.setUserId(29L);
        commentLike15.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike15);

        CommentLike commentLike16 = new CommentLike();
        commentLike16.setCommentId(7L);
        commentLike16.setUserId(28L);
        commentLike16.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike16);

        CommentLike commentLike17 = new CommentLike();
        commentLike17.setCommentId(7L);
        commentLike17.setUserId(26L);
        commentLike17.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike17);

        CommentLike commentLike18 = new CommentLike();
        commentLike18.setCommentId(7L);
        commentLike18.setUserId(24L);
        commentLike18.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike18);

        CommentLike commentLike19 = new CommentLike();
        commentLike19.setCommentId(8L);
        commentLike19.setUserId(23L);
        commentLike19.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike19);

        CommentLike commentLike20 = new CommentLike();
        commentLike20.setCommentId(9L);
        commentLike20.setUserId(22L);
        commentLike20.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike20);

        CommentLike commentLike21 = new CommentLike();
        commentLike21.setCommentId(10L);
        commentLike21.setUserId(21L);
        commentLike21.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike21);

        CommentLike commentLike22 = new CommentLike();
        commentLike22.setCommentId(10L);
        commentLike22.setUserId(18L);
        commentLike22.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike22);

        CommentLike commentLike23 = new CommentLike();
        commentLike23.setCommentId(11L);
        commentLike23.setUserId(17L);
        commentLike23.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike23);

        CommentLike commentLike24 = new CommentLike();
        commentLike24.setCommentId(11L);
        commentLike24.setUserId(15L);
        commentLike24.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike24);

        CommentLike commentLike25 = new CommentLike();
        commentLike25.setCommentId(12L);
        commentLike25.setUserId(13L);
        commentLike25.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike25);

        CommentLike commentLike26 = new CommentLike();
        commentLike26.setCommentId(12L);
        commentLike26.setUserId(11L);
        commentLike26.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike26);

        CommentLike commentLike27 = new CommentLike();
        commentLike27.setCommentId(12L);
        commentLike27.setUserId(1L);
        commentLike27.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike27);

        CommentLike commentLike28 = new CommentLike();
        commentLike28.setCommentId(12L);
        commentLike28.setUserId(4L);
        commentLike28.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike28);

        CommentLike commentLike29 = new CommentLike();
        commentLike29.setCommentId(13L);
        commentLike29.setUserId(23L);
        commentLike29.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike29);

        CommentLike commentLike30 = new CommentLike();
        commentLike30.setCommentId(13L);
        commentLike30.setUserId(30L);
        commentLike30.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike30);

        CommentLike commentLike31 = new CommentLike();
        commentLike31.setCommentId(14L);
        commentLike31.setUserId(25L);
        commentLike31.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike31);

        CommentLike commentLike32 = new CommentLike();
        commentLike32.setCommentId(14L);
        commentLike32.setUserId(27L);
        commentLike32.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike32);

        CommentLike commentLike33 = new CommentLike();
        commentLike33.setCommentId(14L);
        commentLike33.setUserId(26L);
        commentLike33.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike33);

        CommentLike commentLike34 = new CommentLike();
        commentLike34.setCommentId(15L);
        commentLike34.setUserId(24L);
        commentLike34.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike34);

        CommentLike commentLike35 = new CommentLike();
        commentLike35.setCommentId(16L);
        commentLike35.setUserId(23L);
        commentLike35.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike35);

        CommentLike commentLike36 = new CommentLike();
        commentLike36.setCommentId(17L);
        commentLike36.setUserId(22L);
        commentLike36.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike36);

        CommentLike commentLike37 = new CommentLike();
        commentLike37.setCommentId(17L);
        commentLike37.setUserId(21L);
        commentLike37.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike37);

        CommentLike commentLike38 = new CommentLike();
        commentLike38.setCommentId(17L);
        commentLike38.setUserId(20L);
        commentLike38.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike38);

        CommentLike commentLike39 = new CommentLike();
        commentLike39.setCommentId(18L);
        commentLike39.setUserId(18L);
        commentLike39.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike39);

        CommentLike commentLike40 = new CommentLike();
        commentLike40.setCommentId(18L);
        commentLike40.setUserId(17L);
        commentLike40.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike40);

        CommentLike commentLike41 = new CommentLike();
        commentLike41.setCommentId(19L);
        commentLike41.setUserId(16L);
        commentLike41.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike41);

        CommentLike commentLike42 = new CommentLike();
        commentLike42.setCommentId(20L);
        commentLike42.setUserId(15L);
        commentLike42.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike42);

        CommentLike commentLike43 = new CommentLike();
        commentLike43.setCommentId(21L);
        commentLike43.setUserId(12L);
        commentLike43.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike43);

        CommentLike commentLike44 = new CommentLike();
        commentLike44.setCommentId(22L);
        commentLike44.setUserId(29L);
        commentLike44.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike44);

        CommentLike commentLike45 = new CommentLike();
        commentLike45.setCommentId(22L);
        commentLike45.setUserId(28L);
        commentLike45.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike45);

        CommentLike commentLike46 = new CommentLike();
        commentLike46.setCommentId(22L);
        commentLike46.setUserId(26L);
        commentLike46.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike46);

        CommentLike commentLike47 = new CommentLike();
        commentLike47.setCommentId(23L);
        commentLike47.setUserId(1L);
        commentLike47.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike47);

        CommentLike commentLike48 = new CommentLike();
        commentLike48.setCommentId(24L);
        commentLike48.setUserId(3L);
        commentLike48.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike48);

        CommentLike commentLike49 = new CommentLike();
        commentLike49.setCommentId(25L);
        commentLike49.setUserId(5L);
        commentLike49.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike49);

        CommentLike commentLike50 = new CommentLike();
        commentLike50.setCommentId(25L);
        commentLike50.setUserId(4L);
        commentLike50.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike50);

        CommentLike commentLike51 = new CommentLike();
        commentLike51.setCommentId(26L);
        commentLike51.setUserId(2L);
        commentLike51.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike51);

        CommentLike commentLike52 = new CommentLike();
        commentLike52.setCommentId(26L);
        commentLike52.setUserId(22L);
        commentLike52.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike52);

        CommentLike commentLike53 = new CommentLike();
        commentLike53.setCommentId(26L);
        commentLike53.setUserId(26L);
        commentLike53.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike53);

        CommentLike commentLike54 = new CommentLike();
        commentLike54.setCommentId(27L);
        commentLike54.setUserId(27L);
        commentLike54.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike54);

        CommentLike commentLike55 = new CommentLike();
        commentLike55.setCommentId(28L);
        commentLike55.setUserId(21L);
        commentLike55.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike55);

        CommentLike commentLike56 = new CommentLike();
        commentLike56.setCommentId(28L);
        commentLike56.setUserId(20L);
        commentLike56.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike56);

        CommentLike commentLike57 = new CommentLike();
        commentLike57.setCommentId(29L);
        commentLike57.setUserId(14L);
        commentLike57.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike57);

        CommentLike commentLike58 = new CommentLike();
        commentLike58.setCommentId(30L);
        commentLike58.setUserId(22L);
        commentLike58.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike58);

        CommentLike commentLike59 = new CommentLike();
        commentLike59.setCommentId(30L);
        commentLike59.setUserId(28L);
        commentLike59.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike59);

        CommentLike commentLike60 = new CommentLike();
        commentLike60.setCommentId(30L);
        commentLike60.setUserId(30L);
        commentLike60.setPositive(!(Math.random() < 0.5));
        commentLikeService.addCommentLike(commentLike60);
    }
}
