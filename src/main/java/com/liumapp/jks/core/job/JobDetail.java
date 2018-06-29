package com.liumapp.jks.core.job;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liumapp
 * @file JobDetail.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public abstract class JobDetail<T extends JobData> {

    protected JobResult jobResult;

    public JobDetail() {
        this.jobResult = new JobResult();
    }

    public abstract JSONObject handle(T data);

}
