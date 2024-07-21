package logProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

class LogProcessor implements Callable<Integer> {
    private String filePath;
    private String word;

    public LogProcessor(String filePath, String word) {
        this.filePath = filePath;
        this.word = word;
    }

    @Override
    public Integer call() throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("File not found: " + filePath);
            return 0;
        }

        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                count += (line.split(word, -1).length - 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
