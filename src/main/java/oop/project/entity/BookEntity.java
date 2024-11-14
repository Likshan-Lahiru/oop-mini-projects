package oop.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class BookEntity {
    @Id
    private String bookId;
    private String bookName;
    private String author;
    @ManyToOne
    private StudentEntity student;
}
