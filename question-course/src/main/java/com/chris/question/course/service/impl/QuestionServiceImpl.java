package com.chris.question.course.service.impl;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.PageUtils;
import com.chris.question.course.dao.QuestionMapper;
import com.chris.question.course.pojo.Grade;
import com.chris.question.course.pojo.Question;
import com.chris.question.course.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("QuestionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int insertQuestion(Question question) {
        return questionMapper.insertQuestion(question);
    }

    @Override
    public int deleteQuestion(Long questionId) {
        return questionMapper.deleteQuestion(questionId);
    }

    @Override
    public int updateQuestion(Question question) {
        return questionMapper.updateQuestion(question);
    }

    @Override
    public Question getQuestion(Long questionId) {
        return questionMapper.getQuestion(questionId);
    }

    @Override
    public List<Question> getQuestionListByCourseId(String courseId) {
        return questionMapper.getQuestionListByCourseId(courseId);
    }

    @Override
    public PageResult getQuestionListPageByCourseId(String courseId, PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfoByCourseId(courseId,pageRequest));
    }

    @Override
    public int updatePics(Question question) {
        return questionMapper.updatePics(question);
    }

    private PageInfo<Question> getPageInfoByCourseId(String courseId,PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Question> listByPage = questionMapper.getQuestionListByCourseId(courseId);
        return new PageInfo<>(listByPage);
    }

}
