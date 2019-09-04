package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Questioncomment;

import java.util.List;

public interface QuestioncommentDao {


    List<Questioncomment> getAllQuestioncomment(Questioncomment questioncomment);

    @Delete("delete from questioncomment where id = #{id}")
    int removeQuestioncommentById(int id);

    int addQuestioncomment(Questioncomment questioncomment);

    int updateQuestioncomment(Questioncomment questioncomment);

    @Select("select * from questioncomment where id =#{id}")
    Questioncomment getQuestioncommentById(int id);

    @Select("select * from questioncomment where questioncommentName =#{questioncommentName}")
    Questioncomment getQuestioncommentByQuestioncommentName(String questioncommentName);


	List<Questioncomment> superSearch(String superSearchKeyWord);

}