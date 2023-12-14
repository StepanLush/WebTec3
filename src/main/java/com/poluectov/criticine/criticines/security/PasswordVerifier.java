package com.poluectov.criticine.criticines.security;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordVerifier {

    public String createPasswordHash(String password) {
        // Hash a password with a randomly generated salt
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verifyPassword(String password, String storedHash) {
        // Check if the input password matches the stored hash
        return BCrypt.checkpw(password, storedHash);
    }

}
