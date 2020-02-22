package library.menu.impl;

import library.menu.Menu;
import library.menu.input.Input;

import library.service.impl.UserServiceImpl;
import library.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class LoginMenu implements Menu {
    private List<String> options = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private Input input = new Input();

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void addOptions() {
        options.add("1. Login");
        options.add("2. Register user");
        options.add("3. Logout");
        options.add("0. Exit");
    }

    @Override
    public void show() {
        addOptions();
        showOptions(options);

        try {
            while (true) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        userService.login(input.getUserName()).ifPresentOrElse(user -> {
                            UserSession.getInstance().setLoggedUser(user);
                            new UserMenu().show();
                        }, () -> {
                            System.out.println("Try again or register");
                            showOptions(options);
                        });
                        break;
                    case 2:
                        userService.registerUser(input.getUserName());
                        System.out.println("User registered");
                        showOptions(options);
                        break;
                    case 3:
                        new LoginMenu().show();
                        break;
                    case 0:
                        close();
                        break;
                    default:
                        showOptions(options);
                        break;
                }
            }

        } catch (InputMismatchException i) {
            System.out.println("PLEASE CHOOSE NUMBER FROM MENU");
            new LoginMenu().show();
        }
    }

    @Override
    public void close() {
        System.exit(0);
    }
}