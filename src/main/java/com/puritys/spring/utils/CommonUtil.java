package com.puritys.spring.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CommonUtil {

    public int random() {
        return ThreadLocalRandom.current().nextInt(0, 100);
    }
}
