/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dto.out;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js
 */
public class AppListDTO {
   private final List<AppDTO> appList = new ArrayList<>();

    public List<AppDTO> getAppList() {
        return appList;
    }
    public void add(AppDTO appDTO){
        appList.add(appDTO);
    } 
}
