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
public class Publisher {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Book> books;

}
