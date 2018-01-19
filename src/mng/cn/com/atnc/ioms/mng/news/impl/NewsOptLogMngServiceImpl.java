package cn.com.atnc.ioms.mng.news.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.news.INewsOptlogDao;
import cn.com.atnc.ioms.entity.news.NewsOptlog;
import cn.com.atnc.ioms.mng.news.INewsOptLogMngService;
import cn.com.atnc.ioms.model.news.NewsOptLogQueryModel;
import cn.com.atnc.ioms.model.news.NewsQueryModel;

@Service("newsOptLogMngServiceImpl")
public class NewsOptLogMngServiceImpl implements INewsOptLogMngService {
    @Autowired
    private INewsOptlogDao newsOptlogDao;

    @Override
    public void add(NewsOptlog newsOptlog) throws ServiceException {
        newsOptlogDao.save(newsOptlog);
    }

    @Override
    public NewsOptlog findLastTimeById(String id) {
        return newsOptlogDao.findLastTimeById(id);
    }
    

    @Override
    public List<NewsOptlog> findListById(String id) {
        return newsOptlogDao.findListById(id);
    }

    @Override
    public Pagination queryPage(NewsOptLogQueryModel qm) {
        return newsOptlogDao.queryPage(qm);
    }
    @Override
    public Pagination queryPage(NewsQueryModel qm) {
        return newsOptlogDao.queryPage(qm);
    }
}
