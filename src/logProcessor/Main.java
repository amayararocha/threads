package logProcessor;

import logProcessor.ParallelLogProcessor;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> logFiles = Arrays.asList(
                "src/logProcessor/log1.txt"
        );
        String wordToCount = "abacaxi";

        ParallelLogProcessor processor = new ParallelLogProcessor(4);
        int totalOccurrences = processor.processLogs(logFiles, wordToCount);

        System.out.println("Total occurrences of the word '" + wordToCount + "': " + totalOccurrences);
    }
}
