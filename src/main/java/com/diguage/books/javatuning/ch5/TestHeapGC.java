package com.diguage.books.javatuning.ch5;

/**
 * 测试Java堆的垃圾回收
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-22 17:35
 */
public class TestHeapGC {
    public static void main(String[] args) {
        byte[] b1 = new byte[1024 * 1024 / 1];
        byte[] b2 = new byte[1024 * 1024 * 8];
        b2 = null;
        b2 = new byte[1024 * 1024 * 8];
    }
}
