package pl.coderslab.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnglishWords {

    private static final String FILENAME = "/home/piotrdawidziuk/enable1.txt";

    String [] words = readFile().toArray(new String[0]);

    public String[] getWords() {
        return words;
    }

    public List<String> readFile() {

        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                list.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


}
