import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {
    public static void main(String[] args) {
        String filePath = "src/knihy.txt";
        Convertor convertor = new Convertor();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Čteme soubor po řádcích
            while ((line = reader.readLine()) != null) {
                convertor.split(line);
            }
        } catch (IOException e) {
            // Zpracování případných výjimek (např. soubor neexistuje)
            System.err.println("Chyba při čtení souboru: " + e.getMessage());
        }
//        for (Book book : convertor.bookDatabase)
//            System.out.println(book);}
        System.out.println();
        for (Author author : convertor.authorDatabase) {
            System.out.println(author.toString());
        }
        Controler controler = new Controler();

    }
}

