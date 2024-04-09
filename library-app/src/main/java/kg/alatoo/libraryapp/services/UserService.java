package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void createUser(User user);
}
