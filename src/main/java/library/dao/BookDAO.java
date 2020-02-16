package library.dao;

import library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {

    List<Book> findAll();

    void addBook(Book book);

    default Optional<Book> findBook(String criteria) {
        return Optional.empty();
    }
}
