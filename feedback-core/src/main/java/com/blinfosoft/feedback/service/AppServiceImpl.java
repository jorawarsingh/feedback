/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.impl.App;
import java.util.List;

/**
 *
 * @author js
 */
public interface AppServiceImpl {

    App getApp(long id);

    List<App> getApps();

    List<App> getAppsByAdmin(long adminId);

    void deleteApp(long id);

    App createAppByUser(App app, long userId);

    App createApp(App app);

    App updateApp(App app);

}
