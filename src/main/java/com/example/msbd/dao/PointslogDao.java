package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Pointslog;

import java.util.List;

public interface PointslogDao {


    List<Pointslog> getAllPointslog(Pointslog pointslog);

    @Delete("delete from pointslog where id = #{id}")
    int removePointslogById(int id);

    int addPointslog(Pointslog pointslog);

    int updatePointslog(Pointslog pointslog);

    @Select("select * from pointslog where id =#{id}")
    Pointslog getPointslogById(int id);

    @Select("select * from pointslog where pointslogName =#{pointslogName}")
    Pointslog getPointslogByPointslogName(String pointslogName);


	List<Pointslog> superSearch(String superSearchKeyWord);

}