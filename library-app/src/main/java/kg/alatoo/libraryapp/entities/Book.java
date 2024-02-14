package kg.alatoo.libraryapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString*/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String title;
    private String isbn;
    private int publishedYear;
    @Builder.Default
    private int edition = 1;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors;
}
