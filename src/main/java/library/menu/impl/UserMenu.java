package library.menu.impl;


import library.entity.Book;
import library.menu.Menu;
import library.menu.input.Input;
import library.service.impl.BookServiceImpl;
import library.service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserMenu implements Menu {
    private List<String> options = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    Input input = new Input();

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private RecordServiceImpl recordService;

    @Override
    public void addOptions() {
        options.add("1. Add new book");
        options.add("2. Search books by Genre");
        options.add("3. Search book by Author");
        options.add("4. Take book");
        options.add("0. Exit");
    }

    @Override
    public void show() {
        addOptions();
        showOptions(options);

        while (true) {
            var choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    bookService.addNewBook(input.getTitle(), input.getAuthor(), input.getGenre());
                    showOptions(options);
                    break;
                case "2":
                    List<Book> booksByGenre = bookService.findAllByGenre(input.getGenre());
                    if (!booksByGenre.isEmpty()) {
                        for (Book book : booksByGenre) {
                            System.out.println(book);
                        }
                    } else System.out.println("WE DON'T HAVE SUCH BOOKS");
                    showOptions(options);
                    break;
                case "3":
                    List<Book> booksByAuthor = bookService.findAllByAuthor(input.getAuthor());
                    if (!booksByAuthor.isEmpty()) {
                        for (Book book : booksByAuthor) {
                            System.out.println(book);
                        }
                    } else System.out.println("WE DON'T HAVE SUCH BOOKS");
                    showOptions(options);
                    break;
                case "4":
                    List<Book> allBooks = bookService.findAll();
                    if (!allBooks.isEmpty()) {
                        for (Book book : allBooks) {
                            System.out.println(book);
                        }
                    } else System.out.println("WE DON'T HAVE ANY BOOKS YET");
                    Book book = bookService.findById(input.getBookId()).orElse(null);
                    if (Objects.nonNull(book)) recordService.addRecord(book);
                    else System.out.println("NO SUCH BOOK IN LIBRARY");
                    showOptions(options);
                    break;
                case "0":
                    close();
                    break;
                default:
                    showOptions(options);
                    break;
            }
        }
    }

    @Override
    public void close() {
        System.exit(0);
    }
}