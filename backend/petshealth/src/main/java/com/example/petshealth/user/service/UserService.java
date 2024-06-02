package com.example.petshealth.user.service;

import com.example.petshealth.user.dto.UserLoginDto;
import com.example.petshealth.user.dto.UserRegistrationDto;
import com.example.petshealth.user.model.User;
import com.example.petshealth.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.petshealth.pet.model.Pet;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long authorizeAnUser(UserLoginDto userDTO) {

        Optional<User> fetchedUser = userRepository.findByEmail(userDTO.getEmail());

        if (fetchedUser.isEmpty()) {
            throw new RuntimeException("User with the username: " + userDTO.getEmail() + "does not exist");
        }
        return fetchedUser.get().getId();
    }



    public User registerUsers(UserRegistrationDto registrationDTO) {

            User user = User.builder()
                .password(registrationDTO.getPassword())
                .name(registrationDTO.getName())
                .surname(registrationDTO.getSurname())
                .email(registrationDTO.getEmail())
                .oib(registrationDTO.getOib())
                .build();

            userRepository.save(user);
            System.out.println(user);
            return user;


    }

    public List<Pet> listUsersPets(Long id) {

        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get().getPets();
        }
        return null;
    }
}



