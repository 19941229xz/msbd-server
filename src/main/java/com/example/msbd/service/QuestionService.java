package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Question;


public interface QuestionService {



	public Object getAllQuestion(PageParam<Question> pageParam);

    public boolean removeQuestionById(int id);

    public Object addQuestion(Question question);

    public boolean updateQuestion(Question question);

    public Question getQuestionById(int id);


}