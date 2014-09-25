package com.diguage.books.javatuning.ch5;

/**
 * 测试Java虚拟机栈内存溢出
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-07-22 17:30
 */
public class TestStack {
    private int count = 0;

    public void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        TestStack testStack = new TestStack();
        try {
            testStack.recursion();
        } catch (Throwable e) {
            System.out.println("deep of stack is " + testStack.count);
//            e.printStackTrace();
        }
    }
}
