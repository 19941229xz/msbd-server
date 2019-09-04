package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Exampaper;

import java.util.List;

public interface ExampaperDao {


    List<Exampaper> getAllExampaper(Exampaper exampaper);

    @Delete("delete from exampaper where id = #{id}")
    int removeExampaperById(int id);

    int addExampaper(Exampaper exampaper);

    int updateExampaper(Exampaper exampaper);

    @Select("select * from exampaper where id =#{id}")
    Exampaper getExampaperById(int id);

    @Select("select * from exampaper where exampaperName =#{exampaperName}")
    Exampaper getExampaperByExampaperName(String exampaperName);


	List<Exampaper> superSearch(String superSearchKeyWord);

}