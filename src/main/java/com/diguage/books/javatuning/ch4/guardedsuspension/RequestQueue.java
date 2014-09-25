package com.diguage.books.javatuning.ch4.guardedsuspension;

import java.util.LinkedList;

/**
 * Guarded Suspension模式示例
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 17:48
 */
public class RequestQueue {
    // D注：这里可以换成ConcurrentLinkedQueue
    private LinkedList<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        while (queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public synchronized void addRequest(Request request) {
        queue.add(request);
        notifyAll();
    }
}
