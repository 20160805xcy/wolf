package com.xcy.wolf.testJava;

/**
 * @author xcy
 * @date 2019/02/25 16:35
 * @description 一道关于静态代码块和静态对象静态变量有关的基础题
 * @since V1.0.0
 */
public class ListTest {
    public static void main(String[] args) {
        staticFunction();
    }
        //static ListTest st = new ListTest();
        ListTest st = new ListTest();

        static {
            System.out.println("1");
        }

        {
            System.out.println("2");
        }

        ListTest(){
            System.out.println("3");
            System.out.println("a="+a+",b="+b);
        }

        public static void staticFunction(){
            System.out.println("4");
            System.out.println("b="+b);
        }

        int a=110;
        static int b =112;
    /**
     * 全由這一行控制的static关键字 "static ListTest st = new ListTest();"
     * 在没有 创建静态对象时，静态代码块最先执行。
     * 如果创建了静态对象，则先执行构造代码块，再构造方法，再执行静态代码块，静态方法。
     *
     */
}
