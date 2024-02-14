package kg.alatoo.libraryapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Author {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String fullName;
    private String email;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
