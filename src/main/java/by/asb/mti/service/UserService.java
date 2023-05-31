package by.asb.mti.service;

import by.asb.mti.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {
    Page<UserDto> getAllUser(Integer page, Integer size);

    UserDto findUserById(Long id);

    UserDto findUserByLogin(String login);

    UserDto save(UserDto bean);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
