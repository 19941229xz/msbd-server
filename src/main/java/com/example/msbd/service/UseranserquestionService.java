package com.example.msbd.service;

import com.example.msbd.common.PageParam;
import com.example.msbd.model.Useranserquestion;


public interface UseranserquestionService {



	public Object getAllUseranserquestion(PageParam<Useranserquestion> pageParam);

    public boolean removeUseranserquestionById(int id);

    public Object addUseranserquestion(Useranserquestion useranserquestion);

    public boolean updateUseranserquestion(Useranserquestion useranserquestion);

    public Useranserquestion getUseranserquestionById(int id);


}