package pl.coderslab.model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Messages {

    public Messages() {
    }

    public Messages(Password password) {

        this.password = password;
    }

    List<String> list = new ArrayList<>();
    Password password;

    public List<String> createList(String [] words){

        String s = password.getPassword();
        User user = password.getUser();
        String username = user.getUsername();
        String email = user.getEmail();
        List <String> list = new ArrayList<>();
        list.add(is123(s));
        list.add(is321(s));
        list.add(isShort(s));
        list.add(isUser(s,username));
        list.add(containsDupa(s));
        list.add(containsProfanity(s));
        list.add(containsUpperAndLowerCaseNOT(s));
        list.add(containsNumbersNOT(s));
        list.add(isEmail(s,email));
        list.add(containsRepeatedChars(s));
        list.add(containsWordInEnglish(s, words));
        list.add(containsPopularPass(s));
        return list;
    }

    public List<String> createListPositive () {

        String s = password.getPassword();

        List <String> list = new ArrayList<>();
        list.add(isLong(s));
        list.add(containsSpecial(s));
        list.add(containsUpperAndLowerCase(s));
        list.add(containsNumbers(s));
        return list;
    }

    public List<String> getList() {

        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String is123(String password){
        if (password.equals("123")){
            return "Twoje hasło to 123!";
        }
        else if (password.equals("1234")){
            return "Twoje hasło to 1234!";
        }
        else if (password.equals("12345")){
            return "Twoje hasło to 12345!";
        }
        else if (password.equals("123456")){
            return "Twoje hasło to 123456!";
        }
        else if (password.equals("1234567")){
            return "Twoje hasło to 1234567!";
        }
        else if (password.equals("12345678")){
            return "Twoje hasło to 12345678!";
        }
        else if (password.equals("123456789")){
            return "Twoje hasło to 123456789!";
        }
        else if (password.equals("qwerty")){
            return "Twoje hasło to qwerty!";
        }
        else {return null;}
    }

    public String is321(String password){
        if (password.equals("321")){
            return "Twoje hasło to 321!";
        }
        else {return null;}
    }
    public String isShort(String password){
        if (password.length()<=5) {
            return "Twoje hasło ma 5 znaków lub mniej!!!";
        }
        else if (password.length()<= 9 && password.length()>3){
            return "Twoje haslo ma 9 znaków lub mniej.";
        }

        else {
        return null;
        }
    }

    public String isLong (String password) {
        if (password.length() > 10 ){
            return "Twoje hasło ma więcej niż 10 znaków!";
        }
        else {
            return null;
        }
    }

    public String isUser (String password, String user) {
        if (password.toLowerCase().equals(user.toLowerCase())){
            return "Hasło identyczne jak nazwa użytkownika!";
        }
        else if (password.toLowerCase().contains(user.toLowerCase())){
            return "Hasło zawiera w sobie nazwę użytkownika!";
        }
        else {
            return null;
        }
    }

    public String isEmail (String password, String email) {

        String result = email.split("@")[0];

        if (password.toLowerCase().equals(email.toLowerCase())){
            return "Hasło jest takie same jak adres e-mail!";
        }
        else if (password.toLowerCase().contains(email.toLowerCase())){
            return "Hasło zawiera w sobie adres e-mail!";
        }
        else if (password.toLowerCase().contains(result)) {
            return "Hasło zawiera w sobie fragment adresu e-mail!";
        }
        else {
            return null;
        }
    }

    public String containsDupa (String password) {
        String dupa = "dupa";
        if (password.toLowerCase().contains(dupa)) {
            return "Hasło zawiera słowo DUPA!";
        }
        return  null;
    }

    public String containsSpecial (String password){

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        if (b) {
            return "Hasło zawiera znaki specjalne.";}
        return null;
    }

    public String containsUpperAndLowerCase (String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        if (hasLowercase == true && hasUppercase ==true) {
            return "Hasło zawiera zarówno małe, jak i wielkie litery.";
        }
        return null;
    }
    public String containsNumbers (String password){


        Pattern p = Pattern.compile(".*\\d+.*", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        if (b) {
            return "Hasło zawiera cyfry.";}
        return null;
    }
    public String containsProfanity (String password) {

        WordLists wulgaryzmy = new WordLists();

        String[] DIRTY_WORDS = wulgaryzmy.getDirtyWordsArray();

        boolean vulg = stringContainsItemFromList(password.toLowerCase(), DIRTY_WORDS);

        if (vulg== true) {

            return "Twoje hasło zawiera wulgaryzmy!";
        }

        return null;
    }

    public String containsPopularPass (String password) {

        WordLists wordLists = new WordLists();
        String[] popular = wordLists.getPopularPasswordsArray();

        boolean vulg = stringEqualsItemFromList(password.toLowerCase(), popular);

        if (vulg== true) {

            return "Twoje hasło znajduje się na liście 25 najpopularniejszych haseł w 2017 roku!";
        }

        return null;
    }

    public String containsWordInEnglish (String password, String[] words) {

        //EnglishWords englishWords = new EnglishWords();

        //String[] words = englishWords.getWords();

        boolean word = stringContainsItemFromList(password.toLowerCase(), words);

        if (word == true) {

            return "Twoje hasło zawiera instniejące słowo w języku angielskim";
        }

        return null;
    }

    public static boolean stringContainsItemFromList(String inputStr, String[] items) {
        return Arrays.stream(items).parallel().anyMatch(inputStr::contains);
    }
    public static boolean stringEqualsItemFromList(String inputStr, String[] items) {
        return Arrays.stream(items).parallel().anyMatch(inputStr::equals);
    }

    public String containsUpperAndLowerCaseNOT (String password) {

        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());

        if (hasLowercase == false || hasUppercase ==false){
            return "Hasło powinno zawierać małe i wielkie litery!";
        }
        return null;
    }

    public String containsNumbersNOT (String password){

        Pattern p = Pattern.compile(".*\\d+.*", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        if (b) {
            return null;}
        return "Hasło nie zawiera cyfr";
    }

    public String containsRepeatedChars (String password) {
        Pattern p = Pattern.compile("(.)\\1{2,}", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        boolean b = m.find();
        if (b) {
            return "Hasło zawiera ciąg 3 lub więcej identycznych znaków!";}
        return null;

    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
