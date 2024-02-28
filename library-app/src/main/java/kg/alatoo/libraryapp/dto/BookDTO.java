package kg.alatoo.libraryapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;

    @NotNull
    @NotBlank
    private String title;
    private String isbn;
    private int publishedYear;
    @Builder.Default
    private int edition = 1;

    private PublisherDTO publisher;
}
