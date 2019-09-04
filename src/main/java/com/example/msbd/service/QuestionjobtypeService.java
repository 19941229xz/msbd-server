package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Questionjobtype;


public interface QuestionjobtypeService {



	public Object getAllQuestionjobtype(PageParam<Questionjobtype> pageParam);

    public boolean removeQuestionjobtypeById(int id);

    public Object addQuestionjobtype(Questionjobtype questionjobtype);

    public boolean updateQuestionjobtype(Questionjobtype questionjobtype);

    public Questionjobtype getQuestionjobtypeById(int id);


}