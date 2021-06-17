package com.jack.mgr.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * TestTask
 *
 * @author zhengzhe17
 * @date 2021/6/17
 */
@Slf4j
@Data
@AllArgsConstructor
public class TestTask implements Callable<List<Integer>> {
    private int startNum;
    private int endNum;
    @Override
    public List<Integer> call() {
        log.info("enter thread: {}", startNum);
        List<Integer> rtn = new ArrayList<>();
        for(int i = startNum; i < endNum; i++) {
            rtn.add(i);
        }
        log.info("exit thread: {}", startNum);
        return rtn;
    }

    // test codes:

    //List<TestTask> testTaskList = new ArrayList<>();
    //    for(int i = 0; i < 10000; i+=100) {
    //    TestTask testTask = new TestTask(i, i + 100);
    //    testTaskList.add(testTask);
    //}
    //ExecutorService executorService = Executors.newFixedThreadPool(10);
    //    try {
    //    List<Future<List<Integer>>> futureList = executorService.invokeAll(testTaskList);
    //    Map<Integer, Integer> resultMap = new HashMap<>(10000);
    //    for(Future<List<Integer>> future : futureList) {
    //        List<Integer> resultData = future.get();
    //        for(Integer i : resultData) {
    //            resultMap.put(i, i);
    //        }
    //    }
    //    log.info("final return data size: {}", resultMap.size());
    //} catch (Exception e) {
    //    log.error("", e);
    //}
}
