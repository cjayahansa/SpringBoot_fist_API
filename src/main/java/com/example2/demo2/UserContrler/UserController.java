package com.example2.demo2.UserContrler;

import com.example2.demo2.dto.UserDTO;
import com.example2.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/users/")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/getusers")
  public List<UserDTO> getUsers() {

    return userService.getAllUsers();
  }

  @GetMapping("/getuserbyid/{id}")
  public UserDTO getuserbuid(@PathVariable Integer id){
    return userService.getUserById(id);
  }


  @PostMapping("/saveUsers")
  public UserDTO saveUser(@RequestBody UserDTO userDTO) {
    return userService.saveUser(userDTO);
  }

  @PutMapping("/upuser")
  public UserDTO upuser(@RequestBody UserDTO userDTO) {
    return userService.upuser(userDTO);
  }
  @DeleteMapping("/deleteuser")
  public String deleteUser(@RequestBody UserDTO userDTO){
    return userService.deleteUser(userDTO);
  }
}
