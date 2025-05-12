package com.itheima.datastructure.stack;

import com.itheima.datastructure.queue.ArrayQueue3;

/**
 * @author zpstart
 * @create 2023-09-01 18:14
 */
public class E05Leetcode225 {
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
    ArrayQueue3<Integer> queue = new ArrayQueue3<>(100);

    private int size = 0;

    public void push(int x) {
        queue.offer(x); // 队列尾部加入之后,把前面size个元素依次从头部弹出 加入到尾部
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
