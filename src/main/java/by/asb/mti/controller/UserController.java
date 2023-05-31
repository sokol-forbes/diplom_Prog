package by.asb.mti.controller;

import by.asb.mti.dto.UserDto;
import by.asb.mti.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static by.asb.mti.config.bean.URL.GET_USER_BY_ID;
import static by.asb.mti.config.bean.URL.USERS;

@RestController
@RequestMapping(USERS)
@AllArgsConstructor
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class UserController {

    private UserService userService;

    @GetMapping
    public Page<UserDto> getAllUsers(@RequestParam(defaultValue = "0", required = false) Integer page,
                                     @RequestParam(defaultValue = "20", required = false) Integer size) {
        return userService.getAllUser(page, size);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto, HttpServletRequest request) {
        UserDto save = userService.save(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.CONTENT_LOCATION, request.getRequestURI() + "/" + save.getId())
                .build();
    }

    @GetMapping(GET_USER_BY_ID)
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

}
