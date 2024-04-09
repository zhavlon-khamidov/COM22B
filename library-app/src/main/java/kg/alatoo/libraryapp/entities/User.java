package kg.alatoo.libraryapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "\"user\"")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 3, max = 50)
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9_]+$")
    private String username;
    private String password;
    private boolean enabled;
    @Email
    private String email;

}
