package library.dao.impl;

import library.dao.BookDAO;
import library.entity.Book;

import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements BookDAO {

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public Optional<Book> findBook(String criteria) {
        return Optional.empty();
    }
}
