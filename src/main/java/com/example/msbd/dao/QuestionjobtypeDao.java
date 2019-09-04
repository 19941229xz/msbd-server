package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Questionjobtype;

import java.util.List;

public interface QuestionjobtypeDao {


    List<Questionjobtype> getAllQuestionjobtype(Questionjobtype questionjobtype);

    @Delete("delete from questionjobtype where id = #{id}")
    int removeQuestionjobtypeById(int id);

    int addQuestionjobtype(Questionjobtype questionjobtype);

    int updateQuestionjobtype(Questionjobtype questionjobtype);

    @Select("select * from questionjobtype where id =#{id}")
    Questionjobtype getQuestionjobtypeById(int id);

    @Select("select * from questionjobtype where questionjobtypeName =#{questionjobtypeName}")
    Questionjobtype getQuestionjobtypeByQuestionjobtypeName(String questionjobtypeName);


	List<Questionjobtype> superSearch(String superSearchKeyWord);

}