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
import com.example.msbd.dao.QuestioncollectionDao;
import com.example.msbd.model.Questioncollection;

import java.util.List;

@Slf4j
@Service
@Transactional
public class QuestioncollectionServiceImpl implements QuestioncollectionService {


	@Autowired
    QuestioncollectionDao questioncollectionDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllQuestioncollection(PageParam<Questioncollection> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Questioncollection> questioncollectionList=questioncollectionDao.getAllQuestioncollection(pageParam.getModel());
            PageInfo<Questioncollection> questioncollectionPageInfo = new PageInfo<Questioncollection>(questioncollectionList);
    
            return questioncollectionPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Questioncollection> questioncollectionList=questioncollectionDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Questioncollection> questioncollectionPageInfo = new PageInfo<Questioncollection>(questioncollectionList);
    
            return questioncollectionPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "questioncollections",key = "#p0")
    @Override
    public boolean removeQuestioncollectionById(int id){
    	return questioncollectionDao.removeQuestioncollectionById(id)==1;
    }

	@CachePut(value = "questioncollections",key = "#p0.id")
    @Override
    public Object addQuestioncollection(Questioncollection questioncollection){
        questioncollectionDao.addQuestioncollection(questioncollection);

        return questioncollectionDao.getQuestioncollectionById(questioncollection.getId());
    }

	@CacheEvict(value = "questioncollections",key = "#p0.id")
	@Override
    public boolean updateQuestioncollection(Questioncollection questioncollection){
    	if(StringUtils.isEmpty(questioncollection.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改questioncollection时，id不能为空");
        }

        return questioncollectionDao.updateQuestioncollection(questioncollection)==1;
    }

	@Cacheable(key = "#p0",value="questioncollections")
    @Override
    @Transactional(readOnly = true)
    public Questioncollection getQuestioncollectionById(int id){
    	return questioncollectionDao.getQuestioncollectionById(id);
    	
    }
    
    

}
