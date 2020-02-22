package library.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lib_records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "book_id")
    private Integer bookId;
}
