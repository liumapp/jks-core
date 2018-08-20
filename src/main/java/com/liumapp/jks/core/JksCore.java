package com.liumapp.jks.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.job.JobData;
import com.liumapp.jks.core.job.JobDetail;

/**
 * author liumapp
 * file JksCore.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/28/18
 */
public class JksCore {

    public JSONObject doJob(JobDetail jobDetail, JobData jobData) {
        return jobDetail.handle(jobData);
    }

}
