import java.util.List;

public interface IWordSource {
    List<String> loadWords() throws Exception;
}