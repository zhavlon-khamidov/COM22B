package kg.alatoo.libraryapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.log4j.Log4j;

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
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String isbn;
    private int publishedYear;
    @Builder.Default
    private int edition = 1;

}
