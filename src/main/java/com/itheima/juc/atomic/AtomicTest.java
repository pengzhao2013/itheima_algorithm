package com.itheima.juc.atomic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.*;

/**
 * @author zpstart
 * @create 2025-04-21 20:19
 */
public class AtomicTest {
    public static void ai() {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        System.out.println("ai.get()=" + atomicInteger.get());

        System.out.println("ai.addAndGet()=" + atomicInteger.addAndGet(5));
        // 比较
        System.out.println("atomicInteger.compareAndSet(atomicInteger.get(), 10)" + atomicInteger.compareAndSet(atomicInteger.get(), 10));

        System.out.println("ai.get()=" + atomicInteger.get());

        // 获取并且递增
        System.out.println("ai.getAndIncrement()=" + atomicInteger.getAndIncrement());

        System.out.println("ai.get()=" + atomicInteger.get());

        System.out.println("ai.incrementandGet()=" + atomicInteger.incrementAndGet());

        System.out.println("ai.get()=" + atomicInteger.get());

        atomicInteger.lazySet(8);
        System.out.println("ai.lazySet");
        System.out.println("ai.lazySetget()=" + atomicInteger.get());

    }

    public static void aia() {
        int[] value = {1, 2};
        AtomicIntegerArray aia = new AtomicIntegerArray(value);
        System.out.println("aia.getAndSet(0,3)");
        aia.getAndSet(0,3);
        System.out.println("aia.get(0)=" + aia.get(0));
        System.out.println("value[0]=" + value[0]); // 会做拷贝
        aia.compareAndSet(1,2,5);
        System.out.println("aia.get(1)=" + aia.get(1));

        aia.getAndAdd(0,3);
        System.out.println("aia.get(0)=" + aia.get(0));
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        String userName;
        public volatile int age = 0;
    }
    public static void ar() {
        User user = new User("xushu", 10);
        AtomicReference<User> userAtomicReference = new AtomicReference<>(user);
        System.out.println("userAtomicReference.get()" + userAtomicReference.get().toString());

        User updateUser = new User("zhuge", 10);
        userAtomicReference.compareAndSet(user, updateUser);
        System.out.println("userAtomicReference.get()" + userAtomicReference.get().toString());

    }

    public static void au() {
        AtomicIntegerFieldUpdater<User> age = AtomicIntegerFieldUpdater.newUpdater(
                User.class, "age");
        User user = new User("xushu", 10);
        System.out.println(age.getAndIncrement(user));
        System.out.println(age.get(user));
    }

    public static void ia() {
        LongAdder longAdder = new LongAdder(); // 默认从0开始
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder.longValue());

        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 1);
        longAccumulator.accumulate(1);
        longAccumulator.accumulate(3);
        longAccumulator.accumulate(3);
        System.out.println(longAccumulator.get());
        System.out.println(longAccumulator.get());

    }

    public static void main(String[] args) {
//        aia();
//        ar();
//        au();
        ia();
    }
}
