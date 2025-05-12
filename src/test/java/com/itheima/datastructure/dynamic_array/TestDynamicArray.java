package com.itheima.datastructure.dynamic_array;

import com.itheima.datastructure.DynamicArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @author zpstart
 * @create 2023-07-23 20:13
 */

@DisplayName("TestDynamicArray")
public class TestDynamicArray {
    @Test
    public void test1() throws Exception {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
//        dynamicArray.addLast(5);
        dynamicArray.add(2, 5);
        for (int i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    @Test
    public void test2() throws Exception {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.foreach(System.out::println);
    }

    @Test
    public void test3()  {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        Iterator<Integer> iterator = dynamicArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (Integer element : dynamicArray) { // 增强for循环 每次调用迭代器遍历
            System.out.println(element);
        }
    }

    @Test
    public void test4()  {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);

        dynamicArray.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("测试删除")
    public void test5()  {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);
        dynamicArray.addLast(7);
        dynamicArray.addLast(8);
        dynamicArray.addLast(9);

        assertEquals(dynamicArray.remove(1), 2);
//        System.out.println("*****************");
        dynamicArray.stream().forEach(System.out::println);
//        assertIterableEquals(List.of(1,3,4), dynamicArray); // 必须要都实现Iterable接口
    }
}