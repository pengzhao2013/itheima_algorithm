package com.itheima.datastructure.honor;

import java.util.*;

/**
 * @author zpstart
 * @create 2023-08-30 10:16
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Character> charsList = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 32) {
                    charsList.add('0');
                    continue;
                }
                if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                    charsList.add((char) (s.charAt(i) + 32));
                    continue;
                }
                charsList.add(s.charAt(i));
            }
            for (int i = charsList.size() - 1; i >= 0; i--) {
                System.out.print(charsList.get(i));
            }
        }
    }
}
