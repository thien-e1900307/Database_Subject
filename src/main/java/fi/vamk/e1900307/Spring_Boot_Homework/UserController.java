package fi.vamk.e1900307.Spring_Boot_Homework;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        System.out.println("Data Saved!");
        return userRepository.save(user);
    }

    @GetMapping("/users/")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/user")
    public String delete(@RequestBody User user) {
        userRepository.delete(user);
        return "Delete Successfully!";
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id) {
        userRepository.deleteById(id);
        String output = "Delete User Whose ID is " + id + " Successfully!";
        return output;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getItem(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }
}
