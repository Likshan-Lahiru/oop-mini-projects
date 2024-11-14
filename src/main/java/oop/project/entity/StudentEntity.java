package oop.project.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class StudentEntity {
    @Id
    private String email;
    private String name;
    private String contact;
    private String description;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<BookEntity> books;

}
