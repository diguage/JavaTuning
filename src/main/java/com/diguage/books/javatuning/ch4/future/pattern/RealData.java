package com.diguage.books.javatuning.ch4.future.pattern;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 10:32
 */
public class RealData implements Data {
    private String result;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para).append(",");
            try {
                // 这里用sleep，代替一个很慢的操作过程。
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
