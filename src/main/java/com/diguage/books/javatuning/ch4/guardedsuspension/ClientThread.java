package com.diguage.books.javatuning.ch4.guardedsuspension;

import java.util.concurrent.TimeUnit;

/**
 * Guarded Suspension模式示例
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 17:55
 */
public class ClientThread extends Thread {
    private RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestID:" + i + " Thread_Name:"
                    + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.addRequest(request);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is:" + Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + " request end");
    }
}
