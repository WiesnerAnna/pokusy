import java.util.*;

public class Controler {
    ArrayList<Integer> listaZadanychInt = new ArrayList<Integer>();
    ArrayList<Book> listZadanychKnih = new ArrayList<Book>();
    int number;

    public Controler() {
        System.out.println();
        askForNumbers();
        copyBooks();

        System.out.println("právě jste zadali právě 20 knih");
        System.out.println();
        System.out.println("Vámi zadaný seznam obsahuje alespoň dvě prozy");
        counterType(Type.PROZA);

        System.out.println();
        System.out.println("Vámi zadaný seznam obsahuje alespoň dvě dramata");
        counterType(Type.DRAMA);

        System.out.println();
        System.out.println("Vámi zadaný seznam obsahuje alespoň dvě porzie");
        counterType(Type.POEZIE);
        System.out.println();

        System.out.println("Vámi zadaný seznam obsahuje alespoň dvě díla před rokem 1800");
        counterYear(YearGroup.PRED1800, 2);
        System.out.println();

        System.out.println("Vámi zadaný seznam obsahuje alespoň tři díla před rokem 1900");
        counterYear(YearGroup.PRED1900, 3);
        System.out.println();

        System.out.println("Vámi zadaný seznam obsahuje alespon čtyři domácí díla 20. 21. století");
        counterYear(YearGroup.HOMEMADE20a21, 4);
        System.out.println();

        System.out.println("Vámi zadaný seznam obsahuje alespon pět světových děl 20. 21. století");
        counterYear(YearGroup.WORD20a21, 5);
        System.out.println();

        System.out.println("Vámi zadaný seznam neobsahuje více než dvě díla od jednoho autora");
        authorControler();

    }

    private boolean counterType(Type type) {
        int counter;
        counter = 0;
        for (Book book : listZadanychKnih) {
            if (book.getType() == type) {
                counter++;
            }
        }
        if (counter < 0) {
            System.out.println("nesplňuje");
            return false;
        }
        System.out.println("ano, splňuje");
        return true;
    }

    private boolean counterYear(YearGroup yearGroup, int numberOfNecessary) {
        int counter;
        counter = 0;
        for (Book book : listZadanychKnih) {
            if (book.getYearGroup() == yearGroup) {
                counter++;
            }
        }
        if (counter < numberOfNecessary) {
            System.out.println("nesplňuje");
            return false;
        }
        System.out.println("ano, splňuje");
        return true;
    }

    public int getMaxNumber() {
        return (Convertor.bookDatabase.size()+1);
    }

    public int getNumber(){
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        return number;
}

    public boolean controlIfNumberIsDuplicate(int number) {
    if (listaZadanychInt.contains(number)) {
        System.out.println("zadali jste duplikát");
        return true;
    }
    return false;
    }

    public void askForNumbers() {
        System.out.println("Zadejte prosím číslo knihy a stiskněte enter");
        while (listaZadanychInt.size() < 20) {
            int number = getNumber();
            if (number > getMaxNumber()) {
                System.out.println("mimo rozsah  maturitního seznamu");
                askForNumbers();
                return;
            }
            if (controlIfNumberIsDuplicate(number) == true) {
                askForNumbers();
                return;
            }
            listaZadanychInt.add(number);
        }
    }


    public void copyBooks () {
            for (Integer number : listaZadanychInt) {
                for (Book book : Convertor.bookDatabase) {
                    if (book.getId() == number) {
                        listZadanychKnih.add(book);
                        break;
                    }
                }

            }
        }

    public boolean authorControler(){
        for (int i = 0; i < listaZadanychInt.size()-1; i++) {
            int duplicatesCaunter = -3;
            for (int j = 0; j < listaZadanychInt.size()-1; j++) {
                if (listZadanychKnih.get(i).getAuthor().equals(listZadanychKnih.get(j).getAuthor())) {
                duplicatesCaunter++;
                }
            }
                if (duplicatesCaunter > 0) {
                System.out.println("ne, byly nalezeny více než dvě díla od:");
                    System.out.println(listZadanychKnih.get(i).getAuthor().toString());
                return false;

            }

        }
    System.out.println("ano");
    return true;
}












}





