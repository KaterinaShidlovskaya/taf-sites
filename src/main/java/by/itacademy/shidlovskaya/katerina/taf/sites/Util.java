package by.itacademy.shidlovskaya.katerina.taf.sites;


public class Util {
    public static String generateEmail(){
        String[] elements = {"a", "b", "!", "7", "A", "#", "$", "C", "K", "1","5", "E","i","z" };
       return chooseRandomElement(elements, 5)+"@mail.com";
    }

    public static String generatePassword(){
        String[] elements = {"a", "b", "!", "7", "A", "#", "$", "C", "K", "1","5", "E","w","q" };
       return chooseRandomElement(elements, 12);
    }

    public static String chooseRandomElement(String[]array, int numberOfChars){
        String result = "";
        for (int i = 0; i < numberOfChars; i++) {
            int j;
            j = (int)Math.floor(Math.random() * array.length);
            result = result.concat(array[j]);
        }
        return result;
    }
}
