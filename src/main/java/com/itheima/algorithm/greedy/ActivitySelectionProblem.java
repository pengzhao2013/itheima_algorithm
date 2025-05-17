package com.itheima.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode435 无重叠区间本质就是活动选择问题
 * @author zpstart
 * @create 2025-05-17 11:01
 */
public class ActivitySelectionProblem {
    /*
        要在一个会议室举办 n 个活动
        - 每个活动有它们各自的起始和结束时间
        - 找出在时间上互不冲突的活动组合，能够最充分利用会议室（举办的活动次数最多）

        例1
            0   1   2   3   4   5   6   7   8   9
                |-------)
                    |-------)
                        |-------)
        例2
            0   1   2   3   4   5   6   7   8   9
                |---)
                        |---)
            |-----------------------)
                                |-------)
                                            |---)
                                |---------------)

        几种贪心策略
        1. 优先选择持续时间最短的活动
            0   1   2   3   4   5   6   7   8   9
        1       |---------------)                      选中
        2                   |-------)
        3                       |---------------)      选中

        2. 优先选择冲突最少的活动
        编号 0   1   2   3   4   5   6   7   8   9
        1   |-------)                                       3   选中
        2       |-------)                                   4
        3       |-------)                                   4
        4       |-------)                                   4
        5           |-------)                               4   选中
        6               |-------)                           2
        7                   |-----------)                   4   选中
        8                           |-------)               4
        9                           |-------)               4
       10                           |-------)               4
       11                               |-------)           3   选中

        3. 优先选择最先开始的活动
            0   1   2   3   4   5   6   7   8   9
        2       |---)                               选中
        3           |---)                           选中
        4               |---)                       选中
        1   |-----------------------------------)

        4. 优先选择最先结束的活动
     */

    static class Activity {
        int index;
        int start;
        int finish;

        public Activity(int index, int start, int finish) {
            this.index = index;
            this.start = start;
            this.finish = finish;
        }

        public int getFinish() {
            return finish;
        }

        @Override
        public String toString() {
            return "Activity(" + index + ")";
        }
    }

    public static void main(String[] args) {
        Activity[] activities = new Activity[]{
                new Activity(0, 1, 3),
                new Activity(1, 2, 4),
                new Activity(2, 3, 5)
        };

        Arrays.sort(activities, Comparator.comparingInt(Activity::getFinish));

        select(activities, activities.length);
    }

    /*
            例1  看开始时间跟跟上一个被选中的结束时间对比
        编号 0   1   2   3   4   5   6   7   8   9
          0     |-------)         选中
          1         |-------)
          2             |-------) 选中
          3                 |-------)
         */
    public static void select(Activity[] activities, int n) {
        List<Activity> result = new ArrayList<>();
        Activity prev = activities[0];
        result.add(prev); // index = 0 一定会被选中
        for (int i = 1; i < activities.length; i++) {
            Activity curr = activities[i];
            if (curr.start >= prev.finish) {
                result.add(curr);
                prev = curr;
            }
        }
        for (Activity activity : result) {
            System.out.println(activity);
        }
    }
}
