import java.util.*;


public class MyTree {

    private static void  buildTrie(List<String> words, Tree tree){
        int wordCount = 0;
        for (String word : words) {
            if (!word.isEmpty()){
                tree.insert(word);
                wordCount++;
            }
        }

        System.out.println("Sözlük Yüklendi. (" + wordCount + " kelime)");
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Kullanım: java -cp out MyTree sozluk.txt");
            return;
        }

        var trie = new Tree();
        IWordSource  wordSource = new FileWordSource(args[0]);


        // sözlüğü yükle
        try {
            buildTrie(wordSource.loadWords(),trie);
        } catch (Exception e) {
            System.out.println("Sözlük yüklenirken bir hata meydana geldi. \n" + e.getMessage());
            throw new RuntimeException();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bir Kelime Yazıp Enter Tuşuna Basınız (çıkmak için '0' yazın):");
            String input = scanner.nextLine().trim();

            // çıkış
            if (input.equalsIgnoreCase("0")) {
                System.out.println("Programa son veriliyor...");
                break;
            }

            if (input.isEmpty()) {
                continue;
            }

            // kelime bul
            List<String> suggestions = trie.findWordsWithPrefix(input);

            System.out.println("Olası Kelimeler:");
            if (suggestions.isEmpty()) {
                System.out.println("Bu önek ile başlayan kelime bulunamadı.");
            } else {
                for (String word : suggestions) {
                    System.out.println(word);
                }
            }
            System.out.println();
        }

        scanner.close();
    }




}