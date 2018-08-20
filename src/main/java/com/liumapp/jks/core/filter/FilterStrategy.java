package com.liumapp.jks.core.filter;

import com.liumapp.jks.core.job.JobData;

/**
 * author liumapp
 * file FilterStrategy.java
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 6/28/18
 */
public interface FilterStrategy<T extends JobData> {

    public void loggerRequest (T data);

}
