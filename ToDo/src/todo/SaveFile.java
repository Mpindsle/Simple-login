package todo;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marius
 */
public class SaveFile {
    private String username;
    private String password;

    public SaveFile(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void saveUsernameToFile(String user) throws IOException{
        try{
            File usernameFile = new File("usernames.txt");
            FileWriter usernameFileWriter = new FileWriter(usernameFile);
            usernameFileWriter.write(user + "\n");
            usernameFileWriter.flush();
            usernameFileWriter.close();
            System.out.println("Username saved");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
