package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Questioncomment;


public interface QuestioncommentService {



	public Object getAllQuestioncomment(PageParam<Questioncomment> pageParam);

    public boolean removeQuestioncommentById(int id);

    public Object addQuestioncomment(Questioncomment questioncomment);

    public boolean updateQuestioncomment(Questioncomment questioncomment);

    public Questioncomment getQuestioncommentById(int id);


}