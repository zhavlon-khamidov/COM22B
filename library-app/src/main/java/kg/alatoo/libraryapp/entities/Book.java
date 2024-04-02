package kg.alatoo.libraryapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(uniqueConstraints = @UniqueConstraint(name = "uniq_title_ed",
        columnNames = {"title","edition"}))
public class Book {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String title;
    private String isbn;
    private int publishedYear;
    @Builder.Default
    private int edition = 1;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors;
}
