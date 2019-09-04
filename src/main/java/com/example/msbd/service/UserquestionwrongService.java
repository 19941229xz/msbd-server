package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Userquestionwrong;


public interface UserquestionwrongService {



	public Object getAllUserquestionwrong(PageParam<Userquestionwrong> pageParam);

    public boolean removeUserquestionwrongById(int id);

    public Object addUserquestionwrong(Userquestionwrong userquestionwrong);

    public boolean updateUserquestionwrong(Userquestionwrong userquestionwrong);

    public Userquestionwrong getUserquestionwrongById(int id);


}