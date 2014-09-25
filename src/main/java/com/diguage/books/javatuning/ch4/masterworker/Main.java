package com.diguage.books.javatuning.ch4.masterworker;

import java.util.Map;
import java.util.Set;

/**
 * Master-Worker模式的示例
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 11:33
 */
public class Main {
    public static void main(String[] args) {
        Master master = new Master(new PlusWorker(), 5);
        for (int i = 0; i < 100; i++) {
            master.submit(i);
        }
        master.execute();
        int result = 0;
        Map<String, Object> resultMap = master.getResultMap();
        while (resultMap.size() > 0 || !master.isComplete()) {
            Set<String> keys = resultMap.keySet();
            String key = null;
            for (String k : keys) {
                key = k;
                break;
            }
            Integer i = null;
            if (null != key) {
                i = (Integer) resultMap.get(key);
            }
            if (null != i) {
                result += i;
            }
            if (null != key) {
                resultMap.remove(key);
            }
        }
        System.out.println("1~100的立方和 = " + result);

        result = 0;
        for (int i = 0; i < 100; i++) {
            result += i * i * i;
        }
        System.out.println("1~100的立方和 = " + result);
    }
}
