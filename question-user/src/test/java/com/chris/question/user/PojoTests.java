package com.chris.question.user;

import com.chris.question.user.dto.UserDto;
import com.chris.question.user.pojo.*;
import com.chris.question.user.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PojoTests {

    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private PointsService pointsService;
    @Autowired
    private InformationService informationService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private ForwardService forwardService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogCommentService blogCommentService;



    @Test
    void contextLoads() {
        UserDto userDto = new UserDto();
        userDto.setId("chris");
        userDto.setPassword("3250033");
        userDto.setMemberId(1000L);
        userDto.setCardId(17377833L);
        userService.insertUser(userDto);

        userService.updateUser(userDto);
        System.out.println(userService.getUser("chris"));

    }

    @Test
    void userTest(){
        System.out.println(userService.getUser("chris"));
    }

    @Test
    void pointsService(){
        Points points = new Points();
        points.setUserId("chris");
        points.setPoints(100L);

        pointsService.insertPoints(points);
        System.out.println(pointsService.getPoints("chris"));
    }

    @Test
    void informationTest(){
        Information information = new Information();
        information.setCity("shanghai");
        information.setUserId("chris");
        information.setName("riemann");
        information.setProvince("jiangNan");
        information.setSex("男");
        information.setWork("student");

        //informationService.insertInformation(information);
        //System.out.println(informationService.getInformation("chris"));
        information.setName("cauchy");
        informationService.updateInformation(information);
        System.out.println(informationService.getInformation("chris"));
    }

    @Test
    void activityTest(){
        Activity activity = new Activity();
        activity.setUserId("chris");
        activity.setQuestionId(1001L);

        activityService.insertActivity(activity);
        System.out.println(activityService.getActivityListByUserId("chris"));
        activity.setQuestionId(1002L);
        activityService.insertActivity(activity);
        System.out.println(activityService.getActivityListByUserId("chris"));
    }

    @Test
    void collectTest(){
        Collect collect = new Collect();
        collect.setUserId("chris");
        collect.setQuestionId(1002L);

        collectService.insertCollect(collect);
        System.out.println(collectService.getCollectListByUserId("chris"));
        collect.setQuestionId(1001L);
        collectService.insertCollect(collect);
        System.out.println(collectService.getCollectListByUserId("chris"));
    }

    @Test
    void forwardCollect(){
        System.out.println(collectService.getCollectListByUserId("chris"));

        System.out.println(collectService.getCollectListByUserId("chris"));
    }


    @Test
    void blogTest(){
        Blog blog = new Blog();
        blog.setUserId("chris");
        //blog.setContent("sdasdasd");
        blog.setPhoto1("https://img-blog.csdnimg.cn/20190225150040327.jpg");

        //blogService.insertBlog(blog);
        System.out.println(blogService.getBlogListByUserId("chris"));

        blog.setContent("new");
        blog.setId(1L);
        blogService.updateBlog(blog);

        System.out.println(blogService.getBlogListByUserId("chris"));
    }

    @Test
    void blogCommentTest(){
        BlogComment blogComment = new BlogComment();
        blogComment.setBlogId(1L);
        blogComment.setUserId("chris");
        //blogComment.setContent("yes master");

       // blogCommentService.insertBlogComment(blogComment);
        //System.out.println(blogCommentService.getBlogCommentListByBlogId(1L));

        blogComment.setId(1L);
        blogComment.setContent("no master");
        blogCommentService.updateComment(blogComment);
        System.out.println(blogCommentService.getBlogCommentListByBlogId(1L));

    }
}
