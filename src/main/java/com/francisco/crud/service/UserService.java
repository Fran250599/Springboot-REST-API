package com.francisco.crud.service;

import com.francisco.crud.model.User;
import com.francisco.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public ResponseEntity<Object> getUserById(Long id){
        Optional<User> res = userRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Dato encontrado:", res.get());
            data.put("Message", "Usuario encontrado.");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }
        data.put("Error", true);
        data.put("Message", "No existe un usuario con este id.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }

    public ResponseEntity<Object> newUser(User user){
        Optional<User> res = userRepository.findUserByUsername(user.getUsername());
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            data.put("Error", true);
            data.put("Message", "Ya existe un usuario con este nombre de usuario.");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }
        userRepository.save(user);
        data.put("Message", "Usuario creado.");
        data.put("Dato creado:", user);
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
        );
    }

    // Login user
    public ResponseEntity<Object> loginUser(User user){
        Optional<User> res = userRepository.findUserByUsername(user.getUsername());
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            if(user.getPassword().equals(res.get().getPassword())){
                data.put("Message", "Usuario logueado.");
                // Retrieves user role
                User auxUser = userRepository.findUserByUsername(user.getUsername()).get();
                data.put("role", auxUser.getRole());
                data.put("PLU", auxUser.getId());
                data.put("username", auxUser.getUsername());
                return new ResponseEntity<>(
                        data,
                        HttpStatus.OK
                );
            }
            data.put("Error", true);
            data.put("Message", "Contraseña incorrecta.");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.UNAUTHORIZED
            );
        }
        data.put("Error", true);
        data.put("Message", "No existe un usuario con este nombre de usuario.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }


    // Update user
    public ResponseEntity<Object> updateUser(Long id, User user){
        Optional<User> res = userRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            User userToUpdate = res.get();
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setRole(user.getRole());
            userRepository.save(userToUpdate);
            data.put("Message", "Usuario actualizado.");
            data.put("Dato actualizado:", userToUpdate);
            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }
        data.put("Error", true);
        data.put("Message", "No existe un usuario con este id.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }

    // Delete user
    public ResponseEntity<Object> deleteUser(Long id){
        Optional<User> res = userRepository.findById(id);
        HashMap<String, Object> data = new HashMap<>();

        if(res.isPresent()){
            userRepository.delete(res.get());
            data.put("Message", "Usuario eliminado.");
            data.put("Dato eliminado:", res.get());
            return new ResponseEntity<>(
                    data,
                    HttpStatus.OK
            );
        }
        data.put("Error", true);
        data.put("Message", "No existe un usuario con este id.");
        return new ResponseEntity<>(
                data,
                HttpStatus.NOT_FOUND
        );
    }

}
