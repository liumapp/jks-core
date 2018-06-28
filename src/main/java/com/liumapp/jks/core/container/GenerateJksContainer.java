package com.liumapp.jks.core.container;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.jks.core.container.require.GenerateJksContainerRequire;
import com.liumapp.jks.core.filter.RequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liumapp
 * @file GenerateJksContainer.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/28/18
 */
public class GenerateJksContainer extends RequestFilter<GenerateJksContainerRequire> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateJksContainer.class);

    @Override
    public JSONObject handle(GenerateJksContainerRequire data) {
        return null;
    }

}
