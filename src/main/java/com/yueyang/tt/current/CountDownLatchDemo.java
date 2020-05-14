package com.yueyang.tt.current;

import java.util.concurrent.CountDownLatch;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-05-14 16:40
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) throws
             Exception{


        CountDownLatchRe countDownLatch = new CountDownLatchRe(2);
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
                countDownLatch.countDown();//计数器值每次减去1
                System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
            }
        }).start();
        countDownLatch.await();// 減去为0,恢复任务继续执行
        System.out.println("两个子线程执行完毕....");
        System.out.println("主线程继续执行.....");
        for (int i = 0; i < 10; i++) {
            System.out.println("main,i:" + i);
        }
    }

}