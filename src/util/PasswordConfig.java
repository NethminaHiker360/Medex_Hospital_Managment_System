package util;

import org.mindrot.BCrypt;

public class PasswordConfig {
    public String encrypt(String text){
        return BCrypt.hashpw(text,BCrypt.gensalt(10));
    }
}
