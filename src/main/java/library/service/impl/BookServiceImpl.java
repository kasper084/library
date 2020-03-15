package library.service.impl;

import library.dao.BookDAO;
import library.entity.Book;
import library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public void addNewBook(String title, String author, String genre) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        if (isExist(title)) {
            System.out.println("SUCH BOOK IS ALREADY IN THE LIBRARY");
        } else {
            save(book);
            System.out.println("BOOK WAS ADDED");
        }
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        bookDAO.findAll().forEach(books::add);
        return books;
    }

    @Override
    public List<Book> findAllByAuthor(String author) {
        return bookDAO.findAllByAuthor(author);
    }

    @Override
    public List<Book> findAllByGenre(String genre) {
        return bookDAO.findAllByGenre(genre);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookDAO.findByTitle(title);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookDAO.findById(id);
    }

    private boolean isExist(String title) {
        return bookDAO.findByTitle(title).isPresent();
    }
}
