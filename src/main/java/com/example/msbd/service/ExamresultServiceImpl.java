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
import com.example.msbd.dao.ExamresultDao;
import com.example.msbd.model.Examresult;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ExamresultServiceImpl implements ExamresultService {


	@Autowired
    ExamresultDao examresultDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllExamresult(PageParam<Examresult> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Examresult> examresultList=examresultDao.getAllExamresult(pageParam.getModel());
            PageInfo<Examresult> examresultPageInfo = new PageInfo<Examresult>(examresultList);
    
            return examresultPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Examresult> examresultList=examresultDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Examresult> examresultPageInfo = new PageInfo<Examresult>(examresultList);
    
            return examresultPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "examresults",key = "#p0")
    @Override
    public boolean removeExamresultById(int id){
    	return examresultDao.removeExamresultById(id)==1;
    }

	@CachePut(value = "examresults",key = "#p0.id")
    @Override
    public Object addExamresult(Examresult examresult){
        examresultDao.addExamresult(examresult);

        return examresultDao.getExamresultById(examresult.getId());
    }

	@CacheEvict(value = "examresults",key = "#p0.id")
	@Override
    public boolean updateExamresult(Examresult examresult){
    	if(StringUtils.isEmpty(examresult.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改examresult时，id不能为空");
        }

        return examresultDao.updateExamresult(examresult)==1;
    }

	@Cacheable(key = "#p0",value="examresults")
    @Override
    @Transactional(readOnly = true)
    public Examresult getExamresultById(int id){
    	return examresultDao.getExamresultById(id);
    	
    }
    
    

}
