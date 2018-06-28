package com.liumapp.jks.core.filter;

import com.liumapp.jks.core.job.JobData;
import com.liumapp.jks.core.job.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liumapp
 * @file RequestFilter.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public abstract class RequestFilter<T extends JobData> extends JobDetail<T> implements FilterStrategy {

    private Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void loggerRequest(JobData data) {
        logger.info("get request with data : " + data.toString());
    }
}
