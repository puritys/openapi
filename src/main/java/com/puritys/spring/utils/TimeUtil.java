package com.puritys.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Set as a spring component is required if you want to use autowired here and add a ComponentScan is also required.
@Component
public class TimeUtil {

    @Autowired CommonUtil commonUtil;

    public long now() {
        return System.currentTimeMillis() + commonUtil.random();
    }
}
