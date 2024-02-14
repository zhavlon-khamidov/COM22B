package kg.alatoo.libraryapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

}
