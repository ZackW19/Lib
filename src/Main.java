import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();   //rozdzielenie na metody robi kod czytelniejszym
    }

    private  Scanner scanner;  //deklaracja tutaj powoduje dostepność skanera dla innych metod
    private List<Book> bookList ;

    public Main(){
        scanner = new Scanner(System.in);
        bookList = Utlis.parseBooksFromFile(Paths.get("books.txt"));    //odczyt pliku i inicjacja listy
        start();
    }

    private void start(){
        System.out.println("Witaj w mojej bibliotece!");

        String command;
        do {
            System.out.println("1 - Dodawanie ksiażki");
            System.out.println("2 - Wypozyczenie ksiażki");
            System.out.println("3 - Oddanie ksiażki");
            System.out.println("4 - Wyswietl wolne pozycje");
            System.out.println("============================");
            System.out.println("Wpisz polecenie: ");


            command = scanner.nextLine();
            parseChoice(command);
        } while (!command.equals("exit"));
    }

    private void parseChoice(String command) {
        switch (command) {
            case "4": {
                    showFreeBooks();
                    break;
                }
            case "1": {
                addBook();
                break;

            }

            case "2": {
                rentBook();
                break;
            }

            case "3": {
                bringBackBook();
                break;
            }
            case "exit": {
               // Utlis.saveBooksToFile(Paths.get("books.txt"), bookList);
                Utlis.saveBooksToFileNew(Paths.get("books.txt"), bookList);
                break;
            }
            default: {
                System.out.println("Nie ma takiej komendy!");
                }
            }
        }

    private void bringBackBook() {
        System.out.println("Podaj nazwę książki, którą chcesz zwrócić: ");
        String name = scanner.nextLine();

        for (Book book : bookList) {
            if(book.getName().equalsIgnoreCase(name) && book.getRentStatus() == 1){
                book.setRentStatus(0);
                System.out.println("Dzięki za zwrócenie książki");
                return;
            }
        }
        System.out.println("Taka książka nie jest wypożyczona lub nie istnieje!");

    }

    private void rentBook() {

        System.out.println("Podaj nazwę książki, którą chcesz wypożyczyć: ");
        String name = scanner.nextLine();

        for (Book book : bookList){
            if(book.getName().equalsIgnoreCase(name) && book.getRentStatus() == 0) {
                book.setRentStatus(1);
                System.out.println("Wypożyczono książkę " + book.getName());
                System.out.println("Oddaj jak tylko przeczytasz!");
                return;
            }

        }
        System.out.println("Nie ma takiej książki na stanie!");
    }


    private void addBook() {
        System.out.println("Dodajesz nową książke!");

        String title, author;
        int pages, produceYear;

        System.out.print("Tytuł: ");
        title = scanner.nextLine();

        for (Book book: bookList) {


        }

        System.out.print("Autor: ");
        author = scanner.nextLine();

        System.out.print("Ilość stron: ");
        pages = Integer.parseInt(scanner.nextLine());

        System.out.print("Rok wydania:  ");
        produceYear = Integer.parseInt(scanner.nextLine());

        bookList.add(new Book(title, author, pages, produceYear, 0));
        System.out.println("Dodano książkę " + title);

    }

    private void showFreeBooks(){
            for (Book book : bookList) {
                if (book.getRentStatus() == 0) {
                    System.out.println("Wolna pozycja: " + book.getName());
                    System.out.println("---------------------------------");
                }
            }
        }
    }

