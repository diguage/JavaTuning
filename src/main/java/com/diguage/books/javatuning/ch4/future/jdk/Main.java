package com.diguage.books.javatuning.ch4.future.jdk;

import java.util.concurrent.*;

/**
 * Future模式：JDK实现
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 11:07
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // 执行FutureTask，相当于上例中的client.request("a")发送请求
        // 这里开启线程进行RealData的call()执行
        executor.submit(future);
        System.out.println("请求完毕");
        try {
            // 这里可以做额外的数据操作，这里使用sleep代替其他业务的处理
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 相当于上例中的data.getResult()，取得call()方法的返回值
        // 如果此时call()方法没有执行完成，则依然会等待
        System.out.println("数据 = " + future.get());

    }
}
