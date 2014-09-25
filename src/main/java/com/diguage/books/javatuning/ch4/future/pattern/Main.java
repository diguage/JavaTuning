package com.diguage.books.javatuning.ch4.future.pattern;

import java.util.concurrent.TimeUnit;

/**
 * Future模式示例
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 9:53
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        // 这里立即返还，因为得到的是FutureData而不是RealData。
        System.out.println("请求完毕！");
        try {
            // 这里可以用一个sleep代替对其他业务逻辑的处理
            // 在处理这些业务逻辑的过程中，RealData被创建，从而充分利用了等待时间
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据 = " + data.getResult());
    }
}
