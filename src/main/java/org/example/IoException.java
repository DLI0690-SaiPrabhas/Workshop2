package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IoException {
    public static void main(String[] args) {
        try(BufferedReader reader=new BufferedReader(new FileReader("input.txt"))) {
            String ch;
            while ((ch=reader.readLine())!=null){
                System.out.println(ch);
            }

        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }
}
