package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Examresult;


public interface ExamresultService {



	public Object getAllExamresult(PageParam<Examresult> pageParam);

    public boolean removeExamresultById(int id);

    public Object addExamresult(Examresult examresult);

    public boolean updateExamresult(Examresult examresult);

    public Examresult getExamresultById(int id);


}