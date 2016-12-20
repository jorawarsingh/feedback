/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.mysql;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author js
 */
public class MysqlProperties {
 public Map<String, String> getProperties(){
        Map<String, String> map = new HashMap<>();
        String host = System.getProperty("session-service-mysql.host", "localhost");
        String port = System.getProperty("session-service-mysql.port", "3306");
        String database = System.getProperty("session-service-mysql.database", "feedback");
        String username = System.getProperty("session-service-mysql.username", "root");
        String password = System.getProperty("session-service-mysql.password", "wed54jul!");
        map.put("javax.persistence.jdbc.url", "jdbc:mysql://" + host + ":" + port + "/" + database);
        map.put("javax.persistence.jdbc.user", username);
        map.put("javax.persistence.jdbc.password", password);
        System.out.println("mysql properties:" + map);
        return map; 
    }   
}
