package com.itheima.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zpstart
 * @Date: 2025-07-26 8:49
 * @Description:
 */
public class RestoreIpAddressesLeetCode93 {
    public static void main(String[] args) {
        String s = "1921683130";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        int seg_count = 4;
        int[] segments = new int[seg_count];
        List<String> result = new ArrayList<>();
        dfs(s, segments, 0, 0, result);
        return result;
    }

    private static void dfs(String s, int[] segments, int segId, int segStart, List<String> result) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == segments.length) {
            if (segStart == s.length()) {
                StringBuilder ipAddress = new StringBuilder();
                for (int i = 0; i < segments.length; i++) {
                    ipAddress.append(segments[i]);
                    if (i != segments.length - 1) {
                        ipAddress.append(".");
                    }
                }
                result.add(ipAddress.toString());
                System.out.println(ipAddress);
            }
            return;
        }
        if (segStart == s.length()) {
            return;
        }
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segments, segId + 1, segStart + 1, result);
            return;
        }
        int ipAddr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            ipAddr = ipAddr * 10 + (s.charAt(segEnd) - '0');
            if (ipAddr > 0 && ipAddr <= 0xFF) {
                segments[segId] = ipAddr;
                dfs(s, segments, segId + 1, segEnd + 1, result);
            } else {
                break;
            }
        }
    }
}
