package com.itheima.datastructure.stack.exer;

/**
 * @Author: zpstart
 * @Date: 2025-07-12 14:36
 * @Description:
 */
public class E05Leetcode225_2 {
    /*

        栈顶      栈底
        d    c    b    a
        队列头    队列尾

        queue.offer(a)
        queue.offer(b)
        queue.offer(c)

        push 添加
            - 将新加入元素，前面的所有元素从队列头移动到队列尾
        pop 移除
            - 直接移除队列头元素

     */
    static class ArrayQueue<E> {
        private final E[] array;

        private int head = 0;

        private int tail = 0;

        public ArrayQueue(int c) {
            c -= 1;
            c |= c >> 1;
            c |= c >> 2;
            c |= c >> 4;
            c |= c >> 8;
            c |= c >> 16;
            c += 1;
            array = (E[]) new Object[c];
        }

        public boolean offer(E value) {
            if (isFull()) {
                return false;
            }
            array[tail & (array.length - 1)] = value;
            tail++;
            return true;
        }

        public E poll() {
            if (isEmpty()) {
                return null;
            }
            E value = array[head & (array.length - 1)];
            head++;
            return value;
        }

        public E peek() {
            if (isEmpty()) {
                return null;
            }
            return array[head & (array.length - 1)];
        }

        public boolean isFull() {
            return head - tail == array.length;
        }

        public boolean isEmpty() {
            return head == tail;
        }
    }

    ArrayQueue<Integer> queue = new ArrayQueue<>(100);

    int size = 0;

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public Integer pop() {
        size--;
        return queue.poll();
    }

    public Integer peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
