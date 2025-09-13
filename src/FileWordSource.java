import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileWordSource implements IWordSource {

    private final String filename;

    public FileWordSource(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> loadWords() throws Exception {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toUpperCase();
                if (!line.isEmpty()) {
                    words.add(line);
                }
            }
        }

        return words;
    }
}

