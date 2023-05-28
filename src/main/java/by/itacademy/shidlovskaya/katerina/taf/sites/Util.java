package by.itacademy.shidlovskaya.katerina.taf.sites;

import com.github.javafaker.Faker;

public class Util {
    static Faker faker = new Faker();

    public static String generateInvalidEmail() {
        String str = "qwertyuiopasdfghjklzxcvbnm123456789";
        char ch;
        String result = "";
        for (int i = 0; i < 5; i++) {
            int j = (int) Math.floor(Math.random() * str.length());
            ch = str.charAt(j);
            result = result.concat(String.valueOf(ch));
        }
        return result;
    }

    public static String generateEmail() {
        String email = faker.internet().emailAddress();
        return email;
    }

    public static String generatePassword() {
        String password = faker.internet().password();
        return password;
    }
}
