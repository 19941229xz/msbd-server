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
import com.example.msbd.dao.QuestioncommentDao;
import com.example.msbd.model.Questioncomment;

import java.util.List;

@Slf4j
@Service
@Transactional
public class QuestioncommentServiceImpl implements QuestioncommentService {


	@Autowired
    QuestioncommentDao questioncommentDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllQuestioncomment(PageParam<Questioncomment> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Questioncomment> questioncommentList=questioncommentDao.getAllQuestioncomment(pageParam.getModel());
            PageInfo<Questioncomment> questioncommentPageInfo = new PageInfo<Questioncomment>(questioncommentList);
    
            return questioncommentPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Questioncomment> questioncommentList=questioncommentDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Questioncomment> questioncommentPageInfo = new PageInfo<Questioncomment>(questioncommentList);
    
            return questioncommentPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "questioncomments",key = "#p0")
    @Override
    public boolean removeQuestioncommentById(int id){
    	return questioncommentDao.removeQuestioncommentById(id)==1;
    }

	@CachePut(value = "questioncomments",key = "#p0.id")
    @Override
    public Object addQuestioncomment(Questioncomment questioncomment){
        questioncommentDao.addQuestioncomment(questioncomment);

        return questioncommentDao.getQuestioncommentById(questioncomment.getId());
    }

	@CacheEvict(value = "questioncomments",key = "#p0.id")
	@Override
    public boolean updateQuestioncomment(Questioncomment questioncomment){
    	if(StringUtils.isEmpty(questioncomment.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改questioncomment时，id不能为空");
        }

        return questioncommentDao.updateQuestioncomment(questioncomment)==1;
    }

	@Cacheable(key = "#p0",value="questioncomments")
    @Override
    @Transactional(readOnly = true)
    public Questioncomment getQuestioncommentById(int id){
    	return questioncommentDao.getQuestioncommentById(id);
    	
    }
    
    

}
