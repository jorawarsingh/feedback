/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.conf;

import com.blinfosoft.feedback.api.AccountResources;
import com.blinfosoft.feedback.filter.CrossOriginResourceSharingFilter;
import com.blinfosoft.feedback.filter.RequestFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author js
 */
public class FeedbackApp extends ResourceConfig {

    public FeedbackApp() {
        super(RequestFilter.class, AccountResources.class);
        packages("com.blinfosoft.feedback");
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
        register(CrossOriginResourceSharingFilter.class);
    }
}
