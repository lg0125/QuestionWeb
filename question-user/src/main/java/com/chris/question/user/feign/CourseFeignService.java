package com.chris.question.user.feign;


import com.chris.question.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("question-course")
public interface CourseFeignService {

    @PostMapping("/question/service/list")
    R getQuestionList(@RequestBody List<Long> questionIdList);


}
