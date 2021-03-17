package com.chris.question.course.dao;

import com.chris.question.course.pojo.Question;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface QuestionMapper {
    public int insertQuestion(Question question);
    public int deleteQuestion(Long id);
    public int updateQuestion(Question question);
    public Question getQuestion(Long id);
    public List<Question> getQuestionListByCourseId(String courseId);
}
