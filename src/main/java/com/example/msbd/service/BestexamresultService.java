package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Bestexamresult;


public interface BestexamresultService {



	public Object getAllBestexamresult(PageParam<Bestexamresult> pageParam);

    public boolean removeBestexamresultById(int id);

    public Object addBestexamresult(Bestexamresult bestexamresult);

    public boolean updateBestexamresult(Bestexamresult bestexamresult);

    public Bestexamresult getBestexamresultById(int id);


}