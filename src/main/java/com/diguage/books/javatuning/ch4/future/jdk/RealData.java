package com.diguage.books.javatuning.ch4.future.jdk;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Future模式：JDK实现
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 11:07
 */
public class RealData implements Callable<String> {
    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        // 这里是真实的业务逻辑，其执行可能很慢
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para).append(",");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
