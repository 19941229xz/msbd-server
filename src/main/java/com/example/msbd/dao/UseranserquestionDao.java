package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Useranserquestion;

import java.util.List;

public interface UseranserquestionDao {


    List<Useranserquestion> getAllUseranserquestion(Useranserquestion useranserquestion);

    @Delete("delete from useranserquestion where id = #{id}")
    int removeUseranserquestionById(int id);

    int addUseranserquestion(Useranserquestion useranserquestion);

    int updateUseranserquestion(Useranserquestion useranserquestion);

    @Select("select * from useranserquestion where id =#{id}")
    Useranserquestion getUseranserquestionById(int id);

    @Select("select * from useranserquestion where useranserquestionName =#{useranserquestionName}")
    Useranserquestion getUseranserquestionByUseranserquestionName(String useranserquestionName);


	List<Useranserquestion> superSearch(String superSearchKeyWord);

}