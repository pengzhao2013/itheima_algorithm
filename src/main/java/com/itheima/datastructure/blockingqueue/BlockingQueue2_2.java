package com.itheima.datastructure.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zpstart
 * @Date: 2025-07-28 15:04
 * @Description:
 */
@SuppressWarnings("all")
@Slf4j
public class BlockingQueue2_2<E> implements BlockingQueue<E>{
    private final E[] array;

    private int head;

    private int tail;

    private AtomicInteger size = new AtomicInteger();

    private ReentrantLock tailLock = new ReentrantLock();

    private Condition tailWaits = tailLock.newCondition();

    private ReentrantLock headLock = new ReentrantLock();

    private Condition headWaits = headLock.newCondition();

    public BlockingQueue2_2(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public void offer(E e) throws InterruptedException {
        int c = 0;
        tailLock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }

            c = size.getAndIncrement();
            if (c + 1 < array.length) {
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }

        if (c == 0) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {
        E e;
        int c;
        headLock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            e = array[head];
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }
            c = size.getAndDecrement();
            if (c > 1) {
                headWaits.signal();
            }
        } finally {
            headLock.unlock();
        }

        if (c == array.length) {
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }
        return e;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue2_2<String> queue = new BlockingQueue2_2<>(3);
        queue.offer("元素1");
        queue.offer("元素2");
        log.info("queue:{}", queue);

        new Thread(()->{
            try {
                queue.offer("元素3");
                log.info("queue:{}", queue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "offer").start();

        new Thread(()->{
            try {
                queue.poll();
                log.info("queue:{}", queue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "poll").start();
    }
}
