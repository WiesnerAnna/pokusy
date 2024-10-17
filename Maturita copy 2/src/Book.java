public class Book {
    private int id;
    private Type type;
    private YearGroup yearGroup;
    private String title;
    private Author author;

    public Book(int id,Type type, YearGroup yearGroup, String title, Author author) {
        this.id = id;
        this.type = type;
        this.yearGroup = yearGroup;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }


    public Type getType() {
        return type;
    }


    public YearGroup getYearGroup() {
        return yearGroup;
    }

    public Author getAuthor() {
        return author;
    }




    }
