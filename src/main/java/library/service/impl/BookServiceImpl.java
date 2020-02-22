package library.service.impl;

import library.dao.BookDAO;
import library.entity.Book;
import library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            bookDAO.save(book);
            System.out.println("REGISTERED");
        }
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookDAO.findByAuthor(author);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return bookDAO.findByGenre(genre);
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
