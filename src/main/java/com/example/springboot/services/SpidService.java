package com.example.springboot.services;

import com.example.springboot.entities.Spid;
import com.example.springboot.entities.Status;
import com.example.springboot.entities.User;
import org.springframework.stereotype.Service;

@Service
public class SpidService {
    public Spid createSpid(Spid spid) {
        return new Spid(
                spid.getId(),
                spid.getUser(),
                spid.getStatus(),
                spid.getDescription()
        );
    }

    public void editSpid(Spid spid, long id, User user, Status status, String description) {
        spid.setId(id);
        spid.setUser(user);
        spid.setStatus(status);
        spid.setDescription(description);
    }
}
