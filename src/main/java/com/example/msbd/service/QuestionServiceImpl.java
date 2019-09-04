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
import com.example.msbd.dao.QuestionDao;
import com.example.msbd.model.Question;

import java.util.List;

@Slf4j
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {


	@Autowired
    QuestionDao questionDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllQuestion(PageParam<Question> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Question> questionList=questionDao.getAllQuestion(pageParam.getModel());
            PageInfo<Question> questionPageInfo = new PageInfo<Question>(questionList);
    
            return questionPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Question> questionList=questionDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Question> questionPageInfo = new PageInfo<Question>(questionList);
    
            return questionPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "questions",key = "#p0")
    @Override
    public boolean removeQuestionById(int id){
    	return questionDao.removeQuestionById(id)==1;
    }

	@CachePut(value = "questions",key = "#p0.id")
    @Override
    public Object addQuestion(Question question){
        questionDao.addQuestion(question);

        return questionDao.getQuestionById(question.getId());
    }

	@CacheEvict(value = "questions",key = "#p0.id")
	@Override
    public boolean updateQuestion(Question question){
    	if(StringUtils.isEmpty(question.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改question时，id不能为空");
        }

        return questionDao.updateQuestion(question)==1;
    }

	@Cacheable(key = "#p0",value="questions")
    @Override
    @Transactional(readOnly = true)
    public Question getQuestionById(int id){
    	return questionDao.getQuestionById(id);
    	
    }
    
    

}
