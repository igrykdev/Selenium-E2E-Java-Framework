package utils;

import java.util.UUID;

public class Utils {
    public String generateRandomEmail() {
        return System.currentTimeMillis() + "@test.pl";
    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 10);
    }
}
