package library.dao;

import library.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDAO extends CrudRepository<Book, Integer> {

    Optional<Book> findByTitle(String title);

    List<Book> findAllByAuthor(String author);

    List<Book> findAllByGenre(String genre);

    List<Book> findAllByTitle(String title);
}
