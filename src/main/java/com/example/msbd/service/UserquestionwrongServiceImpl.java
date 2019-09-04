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
import com.example.msbd.dao.UserquestionwrongDao;
import com.example.msbd.model.Userquestionwrong;

import java.util.List;

@Slf4j
@Service
@Transactional
public class UserquestionwrongServiceImpl implements UserquestionwrongService {


	@Autowired
    UserquestionwrongDao userquestionwrongDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllUserquestionwrong(PageParam<Userquestionwrong> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Userquestionwrong> userquestionwrongList=userquestionwrongDao.getAllUserquestionwrong(pageParam.getModel());
            PageInfo<Userquestionwrong> userquestionwrongPageInfo = new PageInfo<Userquestionwrong>(userquestionwrongList);
    
            return userquestionwrongPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Userquestionwrong> userquestionwrongList=userquestionwrongDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Userquestionwrong> userquestionwrongPageInfo = new PageInfo<Userquestionwrong>(userquestionwrongList);
    
            return userquestionwrongPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "userquestionwrongs",key = "#p0")
    @Override
    public boolean removeUserquestionwrongById(int id){
    	return userquestionwrongDao.removeUserquestionwrongById(id)==1;
    }

	@CachePut(value = "userquestionwrongs",key = "#p0.id")
    @Override
    public Object addUserquestionwrong(Userquestionwrong userquestionwrong){
        userquestionwrongDao.addUserquestionwrong(userquestionwrong);

        return userquestionwrongDao.getUserquestionwrongById(userquestionwrong.getId());
    }

	@CacheEvict(value = "userquestionwrongs",key = "#p0.id")
	@Override
    public boolean updateUserquestionwrong(Userquestionwrong userquestionwrong){
    	if(StringUtils.isEmpty(userquestionwrong.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改userquestionwrong时，id不能为空");
        }

        return userquestionwrongDao.updateUserquestionwrong(userquestionwrong)==1;
    }

	@Cacheable(key = "#p0",value="userquestionwrongs")
    @Override
    @Transactional(readOnly = true)
    public Userquestionwrong getUserquestionwrongById(int id){
    	return userquestionwrongDao.getUserquestionwrongById(id);
    	
    }
    
    

}
