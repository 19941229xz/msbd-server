package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Questioncollection;


public interface QuestioncollectionService {



	public Object getAllQuestioncollection(PageParam<Questioncollection> pageParam);

    public boolean removeQuestioncollectionById(int id);

    public Object addQuestioncollection(Questioncollection questioncollection);

    public boolean updateQuestioncollection(Questioncollection questioncollection);

    public Questioncollection getQuestioncollectionById(int id);


}