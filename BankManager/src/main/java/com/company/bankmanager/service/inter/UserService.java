package com.company.bankmanager.service.inter;

import com.company.bankmanager.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void create(UserDto userDto);
    UserDto findById(int id);
    List<UserDto> getAllUsers();
    void delete(int id);
    void update(UserDto userDto, int id);

}
