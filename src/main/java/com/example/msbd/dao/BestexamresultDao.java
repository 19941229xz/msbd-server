package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Bestexamresult;

import java.util.List;

public interface BestexamresultDao {


    List<Bestexamresult> getAllBestexamresult(Bestexamresult bestexamresult);

    @Delete("delete from bestexamresult where id = #{id}")
    int removeBestexamresultById(int id);

    int addBestexamresult(Bestexamresult bestexamresult);

    int updateBestexamresult(Bestexamresult bestexamresult);

    @Select("select * from bestexamresult where id =#{id}")
    Bestexamresult getBestexamresultById(int id);

    @Select("select * from bestexamresult where bestexamresultName =#{bestexamresultName}")
    Bestexamresult getBestexamresultByBestexamresultName(String bestexamresultName);


	List<Bestexamresult> superSearch(String superSearchKeyWord);

}