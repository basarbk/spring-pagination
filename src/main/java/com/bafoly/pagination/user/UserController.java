package com.bafoly.pagination.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/api/1.0/users")
  Page<User> getUsers(Pageable page) {
    return userService.getUsers(page);
  }

  @GetMapping("/api/1.0/ordered-users")
  Page<User> getUsersAlternative(@PageableDefault(sort="id", direction = Direction.DESC, size = 10) Pageable page) {
    return userService.getUsers(page);
  }
}
