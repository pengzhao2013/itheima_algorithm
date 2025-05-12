package com.itheima.datastructure.queue;

import java.util.Iterator;

/**
 * 求模运算：
 * - 如果除数是2的n次方
 * -那么被除数的后n位即为余数（模）
 * -求被除数的后n位方法：与(2^n) - 1 按位与 只要能保证数组长度是2^n
 * 同时取后n位 不用考虑符号位问题
 *
 * @author zpstart
 * @create 2023-08-31 10:31
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {
    private final E[] array;

    private int head = 0;

    private int tail = 0;

//    @SuppressWarnings("all")
//    public ArrayQueue3(int capacity) {
//        array = (E[]) new Object[capacity];
//    }

    @SuppressWarnings("all")
    public ArrayQueue3(int c) {
//        if ((capacity & capacity - 1) != 0) {
//            throw new IllegalArgumentException("capacity 必须是2的幂");
//        }
        c -= 1;
        c |= c >> 1;
        c |= c >> 2;
        c |= c >> 4;
        c |= c >> 8;
        c |= c >> 16;
        c += 1;
        array = (E[]) new Object[c]; // 不需要留空位了
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
//        array[(int) Integer.toUnsignedLong(tail) % array.length] = value;
        array[tail & array.length - 1] = value; // tail本身不是索引，需要根据tail计算出索引 减法运算优先级高
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head & array.length - 1];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head & array.length - 1];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return tail - head == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                // java中把超过int范围的负数传给toUnsignedLong
//                E value = array[(int) Integer.toUnsignedLong(p) % array.length];
                E value = array[p & array.length - 1];
                p++;
                return value;
            }
        };
    }

    public static void main(String[] args) {
        int c = 30;
//        int n = (int) (Math.log10(c - 1) / Math.log10(2)) + 1;
//        System.out.println(n);
//        System.out.println(1 << n);

        c -= 1;
        c |= c >> 1;
        c |= c >> 2;
        c |= c >> 4;
        c |= c >> 8;
        c |= c >> 16;
        c += 1;
        System.out.println(c);
    }
}
