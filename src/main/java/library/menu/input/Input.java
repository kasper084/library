package library.menu.input;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getUserName() {
        System.out.println("Enter user's name");
        return scanner.nextLine();
    }

    public String getTitle() {
        System.out.println("Enter book title");
        return scanner.nextLine();
    }


    public String getAuthor() {
        System.out.println("Enter author's name");
        return scanner.nextLine();
    }

    public String getGenre() {
        System.out.println("Enter genre");
        return scanner.nextLine();
    }

    public String getBookId() {
        System.out.println("Enter book ID");
        return scanner.nextLine();
    }
}