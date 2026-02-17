package com.rkolla.starter.users;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

  @Autowired
  MockMvc mvc;

  @MockBean
  UserRepository repo;

  @Test
  void create_trims_name_and_lowercases_email() throws Exception {
    when(repo.save(any(User.class))).thenAnswer(inv -> inv.getArgument(0));

    mvc.perform(
            post("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\" Rahul \",\"email\":\"RKOLLA112@GMAIL.COM\"}"))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value("Rahul"))
        .andExpect(jsonPath("$.email").value("rkolla112@gmail.com"));
  }
}
