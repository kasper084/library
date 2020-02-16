package library.menu.impl;

import library.menu.Menu;
import library.menu.input.Input;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserMenu implements Menu {
    private List<String> options = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    Input input = new Input();

    @Override
    public void addOptions() {
        options.add("1. Login");
        options.add("2. Register user");
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

                        break;
                    case 2:

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

    }
}