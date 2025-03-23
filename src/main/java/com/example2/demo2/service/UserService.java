package com.example2.demo2.service;

import com.example2.demo2.dto.UserDTO;
import com.example2.demo2.model.UserModel;
import com.example2.demo2.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        List<UserModel> userModelList = userRepo.findAll();
        return modelMapper.map(userModelList, new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    public UserDTO saveUser(UserDTO userDTO) {
       userRepo.save(modelMapper.map(userDTO, UserModel.class));
       return userDTO;
}

    public UserDTO upuser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, UserModel.class));
        return userDTO;
}

    public String deleteUser(UserDTO userDTO) {
        userRepo.delete(modelMapper.map(userDTO,UserModel.class));
        return "User Deleted";
}
    public UserDTO getUserById(Integer id){
        UserModel userModel=userRepo.getUserbyId(id);
        return modelMapper.map(userModel,UserDTO.class);
    }
}
