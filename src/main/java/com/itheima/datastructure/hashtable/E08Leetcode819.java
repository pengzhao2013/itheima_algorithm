package com.itheima.datastructure.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @Author : zpstart
 * @Date: 2025-05-13 14:10
 */
public class E08Leetcode819 {
    public static String mostCommonWord0(String paragraph, String[] banned) {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Set<String> set = Set.of(banned); // java8要一个个遍历
        Map<String, Integer> map = new HashMap<>();
        for (String key : split) {
            System.out.println(key);
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
//            Integer value = map.getOrDefault(key, 0);
//            map.put(key, ++value);
        }
        System.out.println(map);
        Optional<Map.Entry<String, Integer>> optional = map.entrySet().stream().max(Map.Entry.comparingByValue());
        return optional.map(Map.Entry::getKey).orElse(null);
    }

    public static String mostCommonWord1(String paragraph, String[] banned) {
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
        Set<String> set = Set.of(banned); // java8要一个个遍历
        Map<String, Integer> map = new HashMap<>();
        for (String key : split) {
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = Set.of(banned); // java8要一个个遍历
        Map<String, Integer> map = new HashMap<>();
        char[] chars = paragraph.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    String key = sb.toString();
                    if (!set.contains(key)) {
                        map.compute(key, (k, v) -> v == null ? 1 : v + 1);
                    }
                    sb.setLength(0);
                }
            }
        }
        if (sb.length() > 0) {
            String key = sb.toString();
            if (!set.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        System.out.println(map);
        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));

    }
}
