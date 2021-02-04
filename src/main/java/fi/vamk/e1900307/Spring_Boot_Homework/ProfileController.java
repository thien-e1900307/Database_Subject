package fi.vamk.e1900307.Spring_Boot_Homework;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {
    
    @Autowired 
    private ProfileRepository profileRepository;

    @PostMapping("/profile")
    public Profile create(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @PutMapping("/profile")
    public Profile update(@RequestBody Profile profile) {
        System.out.println("Data Saved!");
        return profileRepository.save(profile);
    }

    @GetMapping("/profiles/")
    public Iterable<Profile> getProfiles() {
        return profileRepository.findAll();
    }

    @DeleteMapping("/profile")
    public String delete(@RequestBody Profile profile) {
        profileRepository.delete(profile);
        return "Delete Successfully!";
    }

    @DeleteMapping("/profile/{id}")
    public String deleteById(@PathVariable int id) {
        profileRepository.deleteById(id);
        String output = "Delete Profile Whose ID is " + id + " Successfully!";
        return output;
    }

    @GetMapping("/profile/{id}")
    public Optional<Profile> getItem(@PathVariable("id") int id) {
        return profileRepository.findById(id);
    }
}

