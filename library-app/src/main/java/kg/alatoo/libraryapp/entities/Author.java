package kg.alatoo.libraryapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "writer")
public class Author {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "name",
            unique = true, nullable = false, length = 100)
    private String fullName;
    private String email;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
