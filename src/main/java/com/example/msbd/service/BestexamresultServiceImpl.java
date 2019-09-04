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
import com.example.msbd.dao.BestexamresultDao;
import com.example.msbd.model.Bestexamresult;

import java.util.List;

@Slf4j
@Service
@Transactional
public class BestexamresultServiceImpl implements BestexamresultService {


	@Autowired
    BestexamresultDao bestexamresultDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllBestexamresult(PageParam<Bestexamresult> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Bestexamresult> bestexamresultList=bestexamresultDao.getAllBestexamresult(pageParam.getModel());
            PageInfo<Bestexamresult> bestexamresultPageInfo = new PageInfo<Bestexamresult>(bestexamresultList);
    
            return bestexamresultPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Bestexamresult> bestexamresultList=bestexamresultDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Bestexamresult> bestexamresultPageInfo = new PageInfo<Bestexamresult>(bestexamresultList);
    
            return bestexamresultPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "bestexamresults",key = "#p0")
    @Override
    public boolean removeBestexamresultById(int id){
    	return bestexamresultDao.removeBestexamresultById(id)==1;
    }

	@CachePut(value = "bestexamresults",key = "#p0.id")
    @Override
    public Object addBestexamresult(Bestexamresult bestexamresult){
        bestexamresultDao.addBestexamresult(bestexamresult);

        return bestexamresultDao.getBestexamresultById(bestexamresult.getId());
    }

	@CacheEvict(value = "bestexamresults",key = "#p0.id")
	@Override
    public boolean updateBestexamresult(Bestexamresult bestexamresult){
    	if(StringUtils.isEmpty(bestexamresult.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改bestexamresult时，id不能为空");
        }

        return bestexamresultDao.updateBestexamresult(bestexamresult)==1;
    }

	@Cacheable(key = "#p0",value="bestexamresults")
    @Override
    @Transactional(readOnly = true)
    public Bestexamresult getBestexamresultById(int id){
    	return bestexamresultDao.getBestexamresultById(id);
    	
    }
    
    

}
