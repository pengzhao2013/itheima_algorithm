package com.itheima.exer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: zpstart
 * @Date: 2025-07-15 14:07
 * @Description:
 */
public class SolutionEbay {
    private Object Monitor = new Object();

    private List<Work> workQueue = new ArrayList<>();

    private List<Work> failedWorks;

    int offset = 0;

    static class Work {
        Integer workId;

        Work item;

        String errorMsg;
    }

    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 0,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10));

    public void dealWork() {
        for (Work work : workQueue) {
            FutureTask<Integer> futureTask = new FutureTask<>(() -> {
                long currTime = System.currentTimeMillis();
                // 执行任务
                try {
                    if (work != null) {
                        execute(work, currTime);
                    }
                } catch (Exception e) {
                    work.errorMsg = e.getMessage();
                }
                if (work.errorMsg != null) {
                    failedWorks.add(work);
                }
                return work.workId;
            });
            threadPool.execute(futureTask);
            try {
                Integer workId = futureTask.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void execute(Work work, long startTime) {
        // 执行任务
        if (checkTime(startTime) > 5) {
            work.errorMsg = "超时结束本次任务执行";
            return;
        }

        return;
    }

    private int checkTime(long startTime) {
        return 0;
    }

}
