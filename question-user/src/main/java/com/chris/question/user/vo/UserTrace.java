package com.chris.question.user.vo;


import com.chris.question.user.dto.QuestionDto;
import com.chris.question.user.pojo.Blog;
import lombok.Data;

import java.util.List;

@Data
public class UserTrace {
    private List<Blog> blogList;
    private List<QuestionDto> activityList;
    private List<QuestionDto> collectList;
    private List<QuestionDto> forwardList;
    public UserTrace(){}
    public UserTrace(List<Blog> blogList,List<QuestionDto> activityList,List<QuestionDto> collectList,List<QuestionDto> forwardList){
        this.blogList=blogList;
        this.activityList=activityList;
        this.collectList=collectList;
        this.forwardList=forwardList;
    }
}
