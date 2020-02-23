package library.service;

import library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void addNewBook(String title, String author, String genre);

    List<Book> findAllByAuthor(String author);

    List<Book> findAllByGenre(String genre);

    List<Book> findAllByTitle(String title);

    Optional<Book> findByTitle(String title);

    Optional<Book> findById(Integer id);
}
