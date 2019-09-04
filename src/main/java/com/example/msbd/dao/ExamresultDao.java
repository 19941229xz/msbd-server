package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Examresult;

import java.util.List;

public interface ExamresultDao {


    List<Examresult> getAllExamresult(Examresult examresult);

    @Delete("delete from examresult where id = #{id}")
    int removeExamresultById(int id);

    int addExamresult(Examresult examresult);

    int updateExamresult(Examresult examresult);

    @Select("select * from examresult where id =#{id}")
    Examresult getExamresultById(int id);

    @Select("select * from examresult where examresultName =#{examresultName}")
    Examresult getExamresultByExamresultName(String examresultName);


	List<Examresult> superSearch(String superSearchKeyWord);

}