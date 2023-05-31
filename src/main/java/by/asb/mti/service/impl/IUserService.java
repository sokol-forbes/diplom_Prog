package by.asb.mti.service.impl;

import by.asb.mti.dao.entity.User;
import by.asb.mti.dao.repository.UserRepository;
import by.asb.mti.dto.UserDto;
import by.asb.mti.dto.util.DTOConverter;
import by.asb.mti.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class IUserService implements UserService {

    private UserRepository userRepository;
    private DTOConverter dtoConverter;

    @Override
    public Page<UserDto> getAllUser(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<User> userPage = userRepository.findAll(pageRequest);
        return userPage.map(user -> dtoConverter.userEntityToDto(user));
    }

    @Override
    public UserDto findUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(dtoConverter::userEntityToDto)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден!"));
    }

    @Override
    public UserDto findUserByLogin(String login) {
        var userOptional = userRepository.findByLogin(login);
        return userOptional.map(dtoConverter::userEntityToDto)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден!"));
    }

    @Override
    public UserDto save(UserDto bean) {
        var user = userRepository.save(dtoConverter.userDtoToEntity(bean));
        return dtoConverter.userEntityToDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOptional = userRepository.findByLogin(username);
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден!"));
    }
}
