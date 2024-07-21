package logProcessor;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ParallelLogProcessor {
    private ExecutorService executorService;

    public ParallelLogProcessor(int numThreads) {
        executorService = Executors.newFixedThreadPool(numThreads);
    }

    public int processLogs(List<String> filePaths, String word) {
        int totalOccurrences = 0;
        try {
            List<Future<Integer>> futures = executorService.invokeAll(
                    filePaths.stream().map(filePath -> new LogProcessor(filePath, word)).toList()
            );
            for (Future<Integer> future : futures) {
                totalOccurrences += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        return totalOccurrences;
    }
}
