package com.jack.mgr.experiment;

/**
 * ThreadNumExperiment
 *
 * @author zhengzhe17
 * @date 2021/8/17
 */
public class ThreadNumExperiment {
    //long startTime =  System.currentTimeMillis();
    //Integer THREAD_NUM = 256;
    //Integer QUEUE_SIZE = 3000;

    //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(THREAD_NUM, THREAD_NUM, 200L, TimeUnit.MILLISECONDS,
    //        new ArrayBlockingQueue<Runnable>(QUEUE_SIZE), new ThreadPoolExecutor.CallerRunsPolicy());
    //for(int i = 0; i < QUEUE_SIZE; i++) {
    //    String rowKeyPrefix = String.format("%02x", i).toLowerCase();
    //    Runnable task = new Runnable() {
    //        @Override
    //        public void run() {
    //            String requestPath = "http://www.baidu.com";
    //            RestTemplate restTemplate = new RestTemplate();
    //            restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(Charset.forName("UTF-8")));
    //            ResponseEntity<String> response = restTemplate.getForEntity(requestPath, String.class);
    //            log.info("get返回状态：" + response.getStatusCode());
    //        }
    //    };
    //    threadPoolExecutor.execute(task);
    //}
    //threadPoolExecutor.shutdown();
    //try {
    //    threadPoolExecutor.awaitTermination(30, TimeUnit.MINUTES);
    //} catch (InterruptedException interruptedException) {
    //    log.info("exception: ", interruptedException);
    //}
    //long endTime =  System.currentTimeMillis();
    //log.info("end in: {}", (endTime - startTime) / 1000);
}
