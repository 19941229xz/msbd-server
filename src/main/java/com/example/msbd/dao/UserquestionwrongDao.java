package com.example.msbd.dao;

import org.apache.ibatis.annotations.*;
import com.example.msbd.model.Userquestionwrong;

import java.util.List;

public interface UserquestionwrongDao {


    List<Userquestionwrong> getAllUserquestionwrong(Userquestionwrong userquestionwrong);

    @Delete("delete from userquestionwrong where id = #{id}")
    int removeUserquestionwrongById(int id);

    int addUserquestionwrong(Userquestionwrong userquestionwrong);

    int updateUserquestionwrong(Userquestionwrong userquestionwrong);

    @Select("select * from userquestionwrong where id =#{id}")
    Userquestionwrong getUserquestionwrongById(int id);

    @Select("select * from userquestionwrong where userquestionwrongName =#{userquestionwrongName}")
    Userquestionwrong getUserquestionwrongByUserquestionwrongName(String userquestionwrongName);


	List<Userquestionwrong> superSearch(String superSearchKeyWord);

}