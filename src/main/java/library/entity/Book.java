package library.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private String genre;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private List<User> users = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("| ID: %d | Title: %s | Author: %s | Genre: %s |",
                id, title, author, genre);
    }
}