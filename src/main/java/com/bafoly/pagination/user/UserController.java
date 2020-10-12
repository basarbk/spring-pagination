package com.bafoly.pagination.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/api/1.0/users")
  Page<User> getUsers(@RequestParam int pageSize, @RequestParam(defaultValue = "0", required = false) int pageNumber) {
    return userService.getUsers(pageNumber, pageSize);
  }

}
