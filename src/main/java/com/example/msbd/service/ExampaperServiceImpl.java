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
import com.example.msbd.dao.ExampaperDao;
import com.example.msbd.model.Exampaper;

import java.util.List;

@Slf4j
@Service
@Transactional
public class ExampaperServiceImpl implements ExampaperService {


	@Autowired
    ExampaperDao exampaperDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllExampaper(PageParam<Exampaper> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Exampaper> exampaperList=exampaperDao.getAllExampaper(pageParam.getModel());
            PageInfo<Exampaper> exampaperPageInfo = new PageInfo<Exampaper>(exampaperList);
    
            return exampaperPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Exampaper> exampaperList=exampaperDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Exampaper> exampaperPageInfo = new PageInfo<Exampaper>(exampaperList);
    
            return exampaperPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "exampapers",key = "#p0")
    @Override
    public boolean removeExampaperById(int id){
    	return exampaperDao.removeExampaperById(id)==1;
    }

	@CachePut(value = "exampapers",key = "#p0.id")
    @Override
    public Object addExampaper(Exampaper exampaper){
        exampaperDao.addExampaper(exampaper);

        return exampaperDao.getExampaperById(exampaper.getId());
    }

	@CacheEvict(value = "exampapers",key = "#p0.id")
	@Override
    public boolean updateExampaper(Exampaper exampaper){
    	if(StringUtils.isEmpty(exampaper.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改exampaper时，id不能为空");
        }

        return exampaperDao.updateExampaper(exampaper)==1;
    }

	@Cacheable(key = "#p0",value="exampapers")
    @Override
    @Transactional(readOnly = true)
    public Exampaper getExampaperById(int id){
    	return exampaperDao.getExampaperById(id);
    	
    }
    
    

}
