package com.magicworldz.springmisc;

import org.junit.Test;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;

public class RetryUtilTest {

    @Test
    public void testRetry() throws Throwable {
        int cnt = 0;
        var result = RetryUtil.retry((RetryCallback<String, Exception>) context -> {throw new Exception("a");});
        System.out.println(result);
    }
}
