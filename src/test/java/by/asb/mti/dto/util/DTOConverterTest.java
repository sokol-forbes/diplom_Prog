package by.asb.mti.dto.util;

import by.asb.mti.dao.entity.ERole;
import by.asb.mti.dao.entity.Role;
import by.asb.mti.dao.entity.User;
import by.asb.mti.dao.repository.UserRepository;
import by.asb.mti.dto.RoleDto;
import by.asb.mti.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DTOConverterTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DTOConverter dtoConverter;

    @Test
    void userDtoToEntity() {
        UserDto userDto = UserDto.builder()
                .id(1L)
                .login("superAdminLogin")
                .username("Super Admin")
                .password("sdxfcgbjhmkFGHAJ23578dfbx")
                .authorities(List.of(RoleDto.builder().id(1L).authority(ERole.SUPER_ADMIN.toString()).build()))
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
        User user = dtoConverter.userDtoToEntity(userDto);
        assertEquals(userDto.getId(), user.getId(), "Different field ID!");
        assertEquals(userDto.getLogin(), user.getLogin(), "Different field LOGIN!");
        assertEquals(userDto.getUsername(), user.getUsername(), "Different field USERNAME!");
        assertTrue(() -> passwordEncoder.matches(userDto.getPassword(), user.getPassword()), "Passwords are not match!");
        assertAll(() -> {
            List<RoleDto> expectedRoleDtoList = userDto.getAuthorities();
            List<Role> actualRoleList = user.getAuthorities();
            for (int i = 0; i < expectedRoleDtoList.size(); i++) {
                assertEquals(expectedRoleDtoList.get(i).getId(), actualRoleList.get(i).getId(), "Fields ID are different!");
                assertEquals(expectedRoleDtoList.get(i).getAuthority(), actualRoleList.get(i).getAuthority(), "Fields ROLE are different!");
            }
        });
        assertEquals(userDto.isAccountNonExpired(), user.isAccountNonExpired(), "Different field ACCOUNT NON EXPIRED!");
        assertEquals(userDto.isAccountNonLocked(), user.isAccountNonLocked(), "Different field ACCOUNT NON LOCKED!");
        assertEquals(userDto.isCredentialsNonExpired(), user.isCredentialsNonExpired(), "Different field CREDENTIALS NON EXPIRED!");
        assertEquals(userDto.isEnabled(), user.isEnabled(), "Different field ENABLED!");
    }

    @Test
    void userEntityToDto() {
        Optional<User> optionalUser = userRepository.findById(1L);
        assertTrue(optionalUser.isPresent(), "Optional<User> is empty!");
        User user = optionalUser.get();
        UserDto userDto = dtoConverter.userEntityToDto(user);

        assertEquals(user.getId(), userDto.getId(), "Different field ID");
        assertEquals(user.getLogin(), userDto.getLogin(), "Different field LOGIN");
        assertEquals(user.getUsername(), userDto.getUsername(), "Different field USERNAME");
        assertNull(userDto.getPassword(), "Password is not null!");
        assertAll(() -> {
            List<Role> expectedRoleList = user.getAuthorities();
            List<RoleDto> actualRoleDtoList = userDto.getAuthorities();
            for (int i = 0; i < expectedRoleList.size(); i++) {
                assertEquals(expectedRoleList.get(i).getId(), actualRoleDtoList.get(i).getId(), "Fields ID are different!");
                assertEquals(expectedRoleList.get(i).getAuthority(), actualRoleDtoList.get(i).getAuthority(), "Fields ROLE are different!");
            }
        });
        assertEquals(user.isAccountNonExpired(), userDto.isAccountNonExpired(), "Different field ACCOUNT NON EXPIRED");
        assertEquals(user.isAccountNonLocked(), userDto.isAccountNonLocked(), "Different field ACCOUNT NON LOCKED");
        assertEquals(user.isCredentialsNonExpired(), userDto.isCredentialsNonExpired(), "Different field CREDENTIALS NON EXPIRED");
        assertEquals(user.isEnabled(), userDto.isEnabled(), "Different field ENABLED");
    }
}
