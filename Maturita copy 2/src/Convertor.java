import java.util.ArrayList;

public class Convertor {
    public ArrayList<Author> authorDatabase;
    public static ArrayList<Book> bookDatabase;

    public Convertor() {
        authorDatabase = new ArrayList();
        Author author0 = new Author("Zkontrolujte prosím, zda zde není zadán jeden autor dvěma jmény, např. Karel Čapek a Čapek karel");
        authorDatabase.add(author0);

        bookDatabase = new ArrayList();

    }

    int id;
    int type;
    Type actualType;
    YearGroup actualTime;
    int time;
    String title;
    String stringAuthor;
    Author objectAuthor;

    public void split(String line) {
        String[] parts = line.split("-");
        id = Integer.parseInt(parts[0]);
        type = Integer.parseInt(parts[1]);
        time = Integer.parseInt(parts[2]);
        title = parts[4];
        stringAuthor = parts[3];
        objectAuthor = authorAlgorythm(stringAuthor);
        reformateType();
        reformateYear();


        Book book = new Book(id, actualType, actualTime, title, objectAuthor);
        bookDatabase.add(book);

    }

    public void reformateYear() {
        if (time == 1) {
            actualTime = YearGroup.PRED1800;
        } else if (time == 2) {
            actualTime = YearGroup.PRED1900;
        } else if (time == 3) {
            actualTime = YearGroup.HOMEMADE20a21;
        } else if (time == 4) {
            actualTime = YearGroup.WORD20a21;
        }

    }


    public void reformateType() {
        if (type == 1) {
            actualType = Type.POEZIE;
        } else if (type == 2) {
            actualType = Type.PROZA;
        } else if (type == 3) {
            actualType = Type.DRAMA;
        }
    }

    public Author authorAlgorythm(String stringAuthor) {
        for (Author author : authorDatabase) {
            if (author.getName().equals(stringAuthor)) {
                return author;
            }
        }
        Author author1 = new Author(stringAuthor);
        authorDatabase.add(author1);
        return author1;
    }


}














