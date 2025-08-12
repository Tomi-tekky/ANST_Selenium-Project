package Utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
    // Method to generate random string with a prefix
//    public static String getRandomString(String prefix, int bound) {
//        return prefix + new Random().nextInt(bound);
//    }
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return sb.toString();
    }

    // Method to generate random email
    public static String getRandomEmail(String domain) {
        return "user" + new Random().nextInt(1000) + "@" + domain;
    }
    // Generate a random phone number
    public static String getRandomPhoneNumber() {
        Random random = new Random();
        String[] prefixes = {
                "701", "703", "704", "705", "706", "707", "708", "709",
                "802", "803", "804", "805", "806", "807", "808", "809",
                "810", "811", "812", "813", "814", "815", "816", "817",
                "818", "819", "820", "821", "822", "823", "824", "825"
        };

        String prefix = prefixes[random.nextInt(prefixes.length)];
        int lineNumber = 1000000 + random.nextInt(9000000); // Ensures 7-digit number

        return "+234" + prefix + lineNumber; // Nigerian mobile format
    }

    // Method to generate a random UUID
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}
