package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.UserDetailsImpl;
import kg.alatoo.libraryapp.entities.User;
import kg.alatoo.libraryapp.exceptions.UsernameBlankException;
import kg.alatoo.libraryapp.repostiories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AtomicReference<User> user = new AtomicReference<>();

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format("Username %s not found", username)
                )
        );

        /*userRepository.findByUsername(username).ifPresentOrElse(
                u -> {
                    user.set(u);
                },
                () -> {
                    throw new UsernameNotFoundException(
                            String.format("Username %s not found", username)
                    );
                }
        );*/

        return new UserDetailsImpl(user);
    }

    @Override
    public void createUser(User user) throws UsernameBlankException {
        user.setId(null);

        if (!StringUtils.hasText(user.getUsername())) {
            throw new UsernameBlankException("Username cannot be blank");
        }
        //TODO: check password acceptance

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

    }
}
