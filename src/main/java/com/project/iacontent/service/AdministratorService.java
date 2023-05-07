package com.project.iacontent.service;

import com.project.iacontent.dao.HibernateDao;
import com.project.iacontent.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {
    @Autowired
    private HibernateDao hibernateDao;

    public Administrator isAdmin(String mail, String pwd) {
        Administrator administrator = hibernateDao.findByMailPwd(mail, pwd);

        return administrator;
    }

    public Administrator findById(Integer id) {
        return hibernateDao.findById(Administrator.class, id);
    }
}
