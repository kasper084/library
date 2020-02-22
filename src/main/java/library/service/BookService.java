package library.service;

import library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void addNewBook(String title, String author, String genre);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    Optional<Book> findByTitle(String title);

    Optional<Book> findById(Integer id);
}
