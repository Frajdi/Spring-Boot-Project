package com.example.springboot;

import com.example.springboot.entities.Spid;
import com.example.springboot.entities.Status;
import com.example.springboot.entities.User;
import com.example.springboot.services.SpidService;
import com.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    public UserService userService;

    @Autowired
    public SpidService spidService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User createdUser1 = userService.createUser(new User(1,"Frajdi","frajdimalaj"));
        User createdUser2 = userService.createUser(new User(2, "Era", "erazefi"));
        User createdUser3 = userService.createUser(new User(3, "Artan", "artanlenja"));

        userService.editUser(createdUser1, 1, "Frajdi", "frajdi_malaj");
        userService.editUser(createdUser2, 2, "Era", "era_zefi");
        userService.editUser(createdUser3, 3, "Artan", "artan_lenja");

        Spid createdSpid1 = spidService.createSpid(new Spid(1, createdUser1, Status.PENDING, "Frajdi Malaj's SPID"));
        Spid createdSpid2 = spidService.createSpid(new Spid(2, createdUser1, Status.PENDING, "Era Zefi's SPID"));
        Spid createdSpid3 = spidService.createSpid(new Spid(3, createdUser1, Status.PENDING, "Artan Lenja's SPID"));

        spidService.editSpid(createdSpid1, 1, createdUser1, Status.APPROVED, "Frajdi_Malaj's SPID");
        spidService.editSpid(createdSpid2, 2, createdUser2, Status.APPROVED, "Era_Zefi's SPID");
        spidService.editSpid(createdSpid3, 3, createdUser3, Status.APPROVED, "Artan_Lenja's SPID");

        System.out.println("List of spids:\n");
        System.out.println("ID: " + createdSpid1.getId() + " Status: " + createdSpid1.getStatus() + " Description: " + createdSpid1.getDescription());
        System.out.println("ID: " + createdSpid2.getId() + " Status: " + createdSpid2.getStatus() + " Description: " + createdSpid2.getDescription());
        System.out.println("ID: " + createdSpid3.getId() + " Status: " + createdSpid3.getStatus() + " Description: " + createdSpid3.getDescription());

        System.out.println("\nList of spids connected to a user:\n");
        System.out.println("Username: " + createdUser1.getUsername() + " is connected to SPID: " + createdSpid1.getUser().getUsername().equals(createdUser1.getUsername()));
        System.out.println("Username: " + createdUser2.getUsername() + " is connected to SPID: " + createdSpid2.getUser().getUsername().equals(createdUser2.getUsername()));
        System.out.println("Username: " + createdUser3.getUsername() + " is connected to SPID: " + createdSpid3.getUser().getUsername().equals(createdUser3.getUsername()));
    }
}
