package com.diguage.books.javatuning.ch4.guardedsuspension;

/**
 * Guarded Suspension模式示例
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 18:02
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        for (int i = 0; i < 10; i++) {
            new ServerThread(requestQueue, "ServerThread-" + i).start();
        }

        for (int i = 0; i < 100; i++) {
            new ClientThread(requestQueue, "ClientThread-" + i).start();
        }
    }
}
