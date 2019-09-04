package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Questioncollection;

import java.util.List;

public interface QuestioncollectionDao {


    List<Questioncollection> getAllQuestioncollection(Questioncollection questioncollection);

    @Delete("delete from questioncollection where id = #{id}")
    int removeQuestioncollectionById(int id);

    int addQuestioncollection(Questioncollection questioncollection);

    int updateQuestioncollection(Questioncollection questioncollection);

    @Select("select * from questioncollection where id =#{id}")
    Questioncollection getQuestioncollectionById(int id);

    @Select("select * from questioncollection where questioncollectionName =#{questioncollectionName}")
    Questioncollection getQuestioncollectionByQuestioncollectionName(String questioncollectionName);


	List<Questioncollection> superSearch(String superSearchKeyWord);

}