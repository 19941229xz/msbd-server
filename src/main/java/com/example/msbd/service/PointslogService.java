package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Pointslog;


public interface PointslogService {



	public Object getAllPointslog(PageParam<Pointslog> pageParam);

    public boolean removePointslogById(int id);

    public Object addPointslog(Pointslog pointslog);

    public boolean updatePointslog(Pointslog pointslog);

    public Pointslog getPointslogById(int id);


}