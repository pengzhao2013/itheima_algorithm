package com.itheima.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author zpstart
 * @create 2023-07-23 19:33
 */
public class DynamicArray implements Iterable<Integer>{
    private int size = 0; // 逻辑大小

    private int capacity = 8;

//    private int[] array = new int[capacity];
    private int[] array = {};

    public void addLast(int element) {
        add(size, element);
    }

    public void add(int index, int element) {
        checkAndGrow();

        // 添加逻辑
        if (index < 0) {
            throw new RuntimeException("Size is illegal.");
        }
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element; // addLast时也走该段代码
        size++;
    }

    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) { // 容量检查
            // 扩容 1.5
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int get(int index) { // [0,size)
        if (index < 0 || index >= size) {
            throw new RuntimeException("Size is illegal.");
        }
        return array[index];
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
            consumer.accept(array[i]);
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() { // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { // 返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size)); // copyOfRange:含头不含尾
    }

    public int remove(int index) { // [0,size)
        if (index < 0 || index >= size) {
            throw new RuntimeException("Size is illegal.");
        }
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }
}
