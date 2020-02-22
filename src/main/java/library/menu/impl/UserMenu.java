package library.menu.impl;

import library.menu.Menu;
import library.menu.input.Input;
import library.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class UserMenu implements Menu {
    private List<String> options = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    Input input = new Input();

    @Autowired
    private BookServiceImpl bookService;

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

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

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