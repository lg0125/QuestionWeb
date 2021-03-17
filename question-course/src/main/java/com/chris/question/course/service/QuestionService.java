package com.chris.question.course.service;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.course.pojo.Question;

import java.util.List;

public interface QuestionService {
    public int insertQuestion(Question question);
    public int deleteQuestion(Long questionId);
    public int updateQuestion(Question question);
    public Question getQuestion(Long questionId);
    public List<Question> getQuestionListByCourseId(String courseId);
    public PageResult getQuestionListPageByCourseId(String courseId, PageRequest pageRequest);
}
