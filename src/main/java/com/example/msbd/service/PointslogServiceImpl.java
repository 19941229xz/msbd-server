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
import com.example.msbd.dao.PointslogDao;
import com.example.msbd.model.Pointslog;

import java.util.List;

@Slf4j
@Service
@Transactional
public class PointslogServiceImpl implements PointslogService {


	@Autowired
    PointslogDao pointslogDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllPointslog(PageParam<Pointslog> pageParam){
    
    	if(StringUtils.isEmpty(pageParam.getSuperSearchKeyWord())){
            PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Pointslog> pointslogList=pointslogDao.getAllPointslog(pageParam.getModel());
            PageInfo<Pointslog> pointslogPageInfo = new PageInfo<Pointslog>(pointslogList);
    
            return pointslogPageInfo;
        }else{
        	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
            for(int i=0;i<pageParam.getOrderParams().length;i++){
                PageHelper.orderBy(pageParam.getOrderParams()[i]);
            }
    
    
            List<Pointslog> pointslogList=pointslogDao.superSearch(pageParam.getSuperSearchKeyWord());
            PageInfo<Pointslog> pointslogPageInfo = new PageInfo<Pointslog>(pointslogList);
    
            return pointslogPageInfo;
        }
    
    	
    
    }

	@CacheEvict(value = "pointslogs",key = "#p0")
    @Override
    public boolean removePointslogById(int id){
    	return pointslogDao.removePointslogById(id)==1;
    }

	@CachePut(value = "pointslogs",key = "#p0.id")
    @Override
    public Object addPointslog(Pointslog pointslog){
        pointslogDao.addPointslog(pointslog);

        return pointslogDao.getPointslogById(pointslog.getId());
    }

	@CacheEvict(value = "pointslogs",key = "#p0.id")
	@Override
    public boolean updatePointslog(Pointslog pointslog){
    	if(StringUtils.isEmpty(pointslog.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改pointslog时，id不能为空");
        }

        return pointslogDao.updatePointslog(pointslog)==1;
    }

	@Cacheable(key = "#p0",value="pointslogs")
    @Override
    @Transactional(readOnly = true)
    public Pointslog getPointslogById(int id){
    	return pointslogDao.getPointslogById(id);
    	
    }
    
    

}
