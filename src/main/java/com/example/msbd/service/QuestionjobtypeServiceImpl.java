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
import com.example.msbd.dao.QuestionjobtypeDao;
import com.example.msbd.model.Questionjobtype;

import java.util.List;

@Slf4j
@Service
@Transactional
public class QuestionjobtypeServiceImpl implements QuestionjobtypeService {


	@Autowired
    QuestionjobtypeDao questionjobtypeDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllQuestionjobtype(PageParam<Questionjobtype> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Questionjobtype> questionjobtypeList=questionjobtypeDao.getAllQuestionjobtype(pageParam.getModel());
            PageInfo<Questionjobtype> questionjobtypePageInfo = new PageInfo<Questionjobtype>(questionjobtypeList);
    
            return questionjobtypePageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Questionjobtype> questionjobtypeList=questionjobtypeDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Questionjobtype> questionjobtypePageInfo = new PageInfo<Questionjobtype>(questionjobtypeList);
    
            return questionjobtypePageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "questionjobtypes",key = "#p0")
    @Override
    public boolean removeQuestionjobtypeById(int id){
    	return questionjobtypeDao.removeQuestionjobtypeById(id)==1;
    }

	@CachePut(value = "questionjobtypes",key = "#p0.id")
    @Override
    public Object addQuestionjobtype(Questionjobtype questionjobtype){
        questionjobtypeDao.addQuestionjobtype(questionjobtype);

        return questionjobtypeDao.getQuestionjobtypeById(questionjobtype.getId());
    }

	@CacheEvict(value = "questionjobtypes",key = "#p0.id")
	@Override
    public boolean updateQuestionjobtype(Questionjobtype questionjobtype){
    	if(StringUtils.isEmpty(questionjobtype.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改questionjobtype时，id不能为空");
        }

        return questionjobtypeDao.updateQuestionjobtype(questionjobtype)==1;
    }

	@Cacheable(key = "#p0",value="questionjobtypes")
    @Override
    @Transactional(readOnly = true)
    public Questionjobtype getQuestionjobtypeById(int id){
    	return questionjobtypeDao.getQuestionjobtypeById(id);
    	
    }
    
    

}
