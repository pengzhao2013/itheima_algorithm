package com.itheima.juc.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zpstart
 * @create 2025-04-20 20:20
 */
public class C5_SyncLevel {
    public static void main(String[] args) {
        class T {
            Integer age;
        }
        T o = new T();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
