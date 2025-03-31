package Utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
    // Method to generate random string with a prefix
    public static String getRandomString(String prefix, int bound) {
        return prefix + new Random().nextInt(bound);
    }

    // Method to generate random email
    public static String getRandomEmail(String domain) {
        return "user" + new Random().nextInt(1000) + "@" + domain;
    }
    // Generate a random phone number
    public static String getRandomPhoneNumber() {
        Random random = new Random();
        return "11" + (random.nextInt(900000000) + 100000000); // Nigerian mobile format
    }

    // Method to generate a random UUID
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}
