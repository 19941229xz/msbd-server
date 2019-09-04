package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Question;

import java.util.List;

public interface QuestionDao {


    List<Question> getAllQuestion(Question question);

    @Delete("delete from question where id = #{id}")
    int removeQuestionById(int id);

    int addQuestion(Question question);

    int updateQuestion(Question question);

    @Select("select * from question where id =#{id}")
    Question getQuestionById(int id);

    @Select("select * from question where questionName =#{questionName}")
    Question getQuestionByQuestionName(String questionName);


	List<Question> superSearch(String superSearchKeyWord);

}