import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Utlis {
    public static List<Book> parseBooksFromFile(Path p) {
        List<Book> bookList = new ArrayList<>();
        try {
        Book book;
        for(String line : Files.readAllLines(p)){   //tutaj odczytuje wszystko z pliku do stringa jako cała linie
            String[] elements = line.split(":");  //rozdzielenie danych w wierszu po ":"
            book = new Book(elements[0], //przypisuje do elementów listy wg indeksu - tytul:autor:strony:rok:status wypo.
                    elements[1],
                    Integer.parseInt(elements[2]), //parsujemy do Int ponieważ są to elementy w postaci cyfr
                    Integer.parseInt(elements[3]),
                    Integer.parseInt(elements[4]));
            bookList.add(book);
        }

    }catch (IOException e){   //wyjątek gdy brak pliku
        e.printStackTrace();
    }
            return bookList;

    }

    //zapisywanie zmienionych danych do pliku z listy
        public static void saveBooksToFile(Path path, List<Book> books) {
            String[] elementsArray = new String[5];
            StringBuilder builder;
            List<String> lines = new ArrayList<>();

            for (Book book : books) {
                builder = new StringBuilder(); //czyszczenie buildera
                elementsArray[0] = book.getName() + ":";
                elementsArray[1] = book.getAuthor() + ":";
                elementsArray[2] = book.getPages() + ":";
                elementsArray[3] = book.getProduceYear() + ":";
                elementsArray[4] = book.getRentStatus() + "";
                for (String s : elementsArray) {
                    builder.append(s);
                }
                // builder.append("\n");  //dodaje niepotrzebnie pusty wierdsz
                lines.add(builder.toString());
            }
            try {
                Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            public static void saveBooksToFileNew(Path path, List<Book> books){
                List<String> lines = new ArrayList<>();

                for (Book book : books) {
                    lines.add(book.toString());
                }

                try {
                    Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


