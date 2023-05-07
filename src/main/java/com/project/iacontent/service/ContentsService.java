package com.project.iacontent.service;

import com.project.iacontent.dao.HibernateDao;
import com.project.iacontent.model.Contents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContentsService {
    @Autowired
    private HibernateDao hibernateDao;

    public List<Contents> findAll() {
        return hibernateDao.findAll(Contents.class);
    }

    public Contents save(Contents contents) {
        contents.setDateHour(Timestamp.valueOf(LocalDateTime.now()));
        return hibernateDao.create(contents);
    }

    public Contents findById(Integer id) {
        return hibernateDao.findById(Contents.class, id);
    }

    public void delete(Integer id) {
        hibernateDao.deleteById(Contents.class, id);
    }
}
