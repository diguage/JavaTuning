package com.diguage.books.javatuning.ch4.future.pattern;

/**
 * Future模式示例
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-09-25 10:24
 */
public class Client {
    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread() {
            // 这样有问题吧？我都怀疑错了，这里没有在构造函数里传入Runnable对象，所以，可以覆盖run方法。
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }

        }.start();
        return future;
    }
}
