/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.impl.App;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.exception.AppAlreadyExistExceptions;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import java.util.List;

/**
 *
 * @author js
 */
public class AppService implements AppServiceImpl {

    private final DaoFactory daoFactory;

    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public AppService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public App getApp(long id) throws AppNotFoundException {
        return getDaoFactory().getAppDao().findByPrimaryKey(id).orElseThrow(() -> {
            return new AppNotFoundException(id);
        });
    }

    @Override
    public void deleteApp(long id) throws AppNotFoundException {
        App app = getDaoFactory().getAppDao().findByPrimaryKey(id).orElseThrow(() -> {
            return new AppNotFoundException(id);
        });
        getDaoFactory().getAppDao().destroy(app);
    }

    @Override
    public App updateApp(App indata) throws AppNotFoundException {
        App app = getDaoFactory().getAppDao().findByPrimaryKey(indata.getId()).orElseThrow(() -> {
            return new AppNotFoundException(indata.getId());
        });
        getDaoFactory().getAppDao().executeInTransaction((em) -> em.merge(indata));
        return app;
    }

    @Override
    public List<App> getApps() {
        return getDaoFactory().getAppDao().findAll();
    }

    @Override
    public App createAppByAccount(App app, String userAgent) throws AccountNotFoundException , AppNotFoundException, AppAlreadyExistExceptions{
       if(appAlreadyExist(app.getName()))
        {
            throw new AppAlreadyExistExceptions(app.getName());
        }
        DefaultAccount account = (DefaultAccount) getDaoFactory().getAccountDao().getAccountByLicense(userAgent).orElseThrow(() -> {
            return new AccountNotFoundException(userAgent);
        });
        app.setAccount(account);
        try {
            getDaoFactory().getAppDao().executeInTransaction((em) -> em.persist(app));
        } catch (Exception e) {
        }
        return app;
    }

    @Override
    public List<App> getAppsByAccount(String userAgent) throws AppNotFoundException {
        return getDaoFactory().getAppDao().findByAccountLicense(userAgent).orElseThrow(() -> {
            return new AppNotFoundException(userAgent);
        });
    }

    @Override
    public boolean appAlreadyExist(String name) throws AppNotFoundException {
        return getDaoFactory().getAppDao().findByAppName(name).isPresent();
    }
}
