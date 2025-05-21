package com.itheima.datastructure.hashtable.exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zpstart
 * @create 2025-05-20 20:30
 */
public class E03Leetcode49_2 {
    static class ArrayKey {
        int[] key = new int[26];

        public ArrayKey(String str) {
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                key[c - 97]++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArrayKey arrayKey = (ArrayKey) o;
            return Arrays.equals(key, arrayKey.key);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(key);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            ArrayKey arrayKey = new ArrayKey(str);
            List<String> list = map.computeIfAbsent(arrayKey, key -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
