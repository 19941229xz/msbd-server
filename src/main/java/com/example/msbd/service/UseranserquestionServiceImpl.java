package com.example.msbd.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.example.msbd.common.HttpCode;
import com.example.msbd.common.MyException;
import com.example.msbd.common.PageParam;
import com.example.msbd.dao.UseranserquestionDao;
import com.example.msbd.model.Useranserquestion;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UseranserquestionServiceImpl implements UseranserquestionService {


	@Autowired
    UseranserquestionDao useranserquestionDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllUseranserquestion(PageParam<Useranserquestion> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Useranserquestion> useranserquestionList=useranserquestionDao.getAllUseranserquestion(pageParam.getModel());
            PageInfo<Useranserquestion> useranserquestionPageInfo = new PageInfo<Useranserquestion>(useranserquestionList);
    
            return useranserquestionPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Useranserquestion> useranserquestionList=useranserquestionDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Useranserquestion> useranserquestionPageInfo = new PageInfo<Useranserquestion>(useranserquestionList);
    
            return useranserquestionPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "useranserquestions",key = "#p0")
    @Override
    public boolean removeUseranserquestionById(int id){
    	return useranserquestionDao.removeUseranserquestionById(id)==1;
    }

	@CachePut(value = "useranserquestions",key = "#p0.id")
    @Override
    public Object addUseranserquestion(Useranserquestion useranserquestion){
        useranserquestionDao.addUseranserquestion(useranserquestion);

        return useranserquestionDao.getUseranserquestionById(useranserquestion.getId());
    }

	@CacheEvict(value = "useranserquestions",key = "#p0.id")
	@Override
    public boolean updateUseranserquestion(Useranserquestion useranserquestion){
    	if(StringUtils.isEmpty(useranserquestion.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改useranserquestion时，id不能为空");
        }

        return useranserquestionDao.updateUseranserquestion(useranserquestion)==1;
    }

	@Cacheable(key = "#p0",value="useranserquestions")
    @Override
    @Transactional(readOnly = true)
    public Useranserquestion getUseranserquestionById(int id){
    	return useranserquestionDao.getUseranserquestionById(id);
    	
    }
    
    

}
