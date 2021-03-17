package com.chris.question.user;

import com.chris.question.user.dto.QuestionDto;
import com.chris.question.user.feign.CourseFeignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FeignTests {

    @Autowired
    private CourseFeignService courseFeignService;

    @Test
    @SuppressWarnings("unchecked")
    public void courseFeignTest(){
        List<Long> indexList = new ArrayList<>();
        indexList.add(1L);
        indexList.add(2L);

        List<QuestionDto> activityList = (List<QuestionDto>) courseFeignService.getQuestionList(indexList).get("questionList");

        System.out.println(activityList);
    }

}
