package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Exampaper;


public interface ExampaperService {



	public Object getAllExampaper(PageParam<Exampaper> pageParam);

    public boolean removeExampaperById(int id);

    public Object addExampaper(Exampaper exampaper);

    public boolean updateExampaper(Exampaper exampaper);

    public Exampaper getExampaperById(int id);


}