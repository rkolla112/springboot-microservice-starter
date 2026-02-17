package com.rkolla.starter.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {
  private final UserRepository repo;

  public UserController(UserRepository repo) {
    this.repo = repo;
  }

  @GetMapping
  public List<User> list() {
    return repo.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@Valid @RequestBody UserCreateRequest req) {
    var user = new User(req.name().trim(), req.email().trim().toLowerCase());
    return repo.save(user);
  }
}
