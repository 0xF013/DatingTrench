package com.datingtrench.mvc.utils;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by elvis on 2/16/14.
 */

@Component
public class RandomStringGenerator {

    public String generate(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

}
