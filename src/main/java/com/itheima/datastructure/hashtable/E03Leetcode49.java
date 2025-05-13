package com.itheima.datastructure.hashtable;

import java.util.*;

/**
 * @Author : zpstart
 * @Date: 2025-05-13 10:10
 */
public class E03Leetcode49 {
    static class ArrayKey {
        int[] key = new int[26];

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

        public ArrayKey(String str) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                key[c - 97]++;
            }
        }
    }
    /**
     * 题目中只包含小写字母
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<ArrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            ArrayKey arrayKey = new ArrayKey(str);
            List<String> list = map.computeIfAbsent(arrayKey, key -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
//            List<String> list = map.getOrDefault(key, new ArrayList<>());
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
//            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
