/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.impl.App;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.exception.AppAlreadyExistExceptions;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import java.util.List;

/**
 *
 * @author js
 */
public interface AppServiceImpl {

    App getApp(long id) throws AppNotFoundException;

    List<App> getApps();

    List<App> getAppsByAccount(String userAgent) throws AppNotFoundException;

    void deleteApp(long id) throws AppNotFoundException;

    App createAppByAccount(App app, String userAgent) throws AccountNotFoundException, AppAlreadyExistExceptions, AppNotFoundException;

    App updateApp(App app) throws AppNotFoundException;
    boolean appAlreadyExist(String name) throws AppNotFoundException;
}
