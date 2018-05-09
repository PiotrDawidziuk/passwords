package pl.coderslab.model;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    public Messages() {
    }

    public Messages(Password password) {
        this.password = password;
    }

    List<String> list = new ArrayList<>();
    Password password;

    public List<String> createList(Password password){

        String s = password.getPassword();

        List <String> list = new ArrayList<>();
        list.add(is123(s));
        list.add(is321(s));
        list.add(isShort(s));
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
            return "haslo to 123";
        }
        else {return null;}
    }

    public String is321(String password){
        if (password.equals("321")){
            return "haslo to 321";
        }
        else {return null;}
    }
    public String isShort(String password){
        if (password.length()<=3) {
            return "twoje haslo mniej niż 3 znaki";
        }
        else if (password.length()<= 6 && password.length()>3){
            return "twoje haslo ma 6 znakow lub mniej";
        }

        else {
        return null;
        }
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
