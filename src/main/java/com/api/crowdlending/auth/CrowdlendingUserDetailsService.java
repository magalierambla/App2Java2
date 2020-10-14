package com.api.crowdlending.auth;

import com.api.crowdlending.model.User;
import com.api.crowdlending.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrowdlendingUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CrowdlendingUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByLogin(login);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("cannot find username: " + login);
        }
        return new CrowdlendingUserPrincipal(user.get());
    }
}
