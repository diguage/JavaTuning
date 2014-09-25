package com.diguage.books.javatuning.ch4.masterworker;

import java.util.Map;
import java.util.Queue;

/**
 * Master-Worker模式的示例
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 11:25
 */
public class Worker implements Runnable {
    private Queue<Object> workQueue;
    private Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {
        while (true) {
            Object input = workQueue.poll();
            if (null == input) {
                break;
            }
            Object re = handle(input);
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }
}
