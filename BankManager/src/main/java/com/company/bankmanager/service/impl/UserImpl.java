package com.company.bankmanager.service.impl;

import com.company.bankmanager.dto.UserDto;
import com.company.bankmanager.entity.UserEntity;
import com.company.bankmanager.enums.ErrorCodeEnum;
import com.company.bankmanager.exception.UserException;
import com.company.bankmanager.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import com.company.bankmanager.repository.UserEntityRepository;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserEntityRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void create(UserDto userDto) {
        UserEntity user = UserEntity.builder()
                .name(userDto.getName())
                .surName(userDto.getSurName())
                .age(userDto.getAge())
                .build();

        userRepository.save(user);
    }

    @Override
    public UserDto findById(int id) {
        Optional<UserEntity> findBook = userRepository.findById(id);
        if(findBook.isEmpty()){
            throw new UserException(ErrorCodeEnum.USER_NOT_FOUND);
        }
        return findBook.map(userE->modelMapper.map(userE,UserDto.class)).orElseThrow();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> getAllBooks = userRepository.findAll();
        return getAllBooks.stream()
                .map(userEntity ->modelMapper.map(userEntity, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserDto userDto, int id) {

    }
}
