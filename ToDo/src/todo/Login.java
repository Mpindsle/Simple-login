/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Marius
 */
public class Login extends Application {
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        //Sets the title of the window
       primaryStage.setTitle("Log in");
       //Removes the ability to resize the log in window
       primaryStage.setResizable(false);
       
       // SCENE LOGIN START
       
       //Creates a new grid for the log in window
       GridPane gridLogin = new GridPane();
       gridLogin.setAlignment(Pos.CENTER);
       gridLogin.setHgap(10);
       gridLogin.setVgap(10);
       gridLogin.setPadding(new Insets(25, 25, 25, 25));
       
        //Creates new scene
       Scene scene = new Scene(gridLogin, 1024, 800);
       
       //Sets a welcome text for the log in window
       Text scenetitle = new Text("   Welcome");
       scenetitle.setId("welcome-text");
       gridLogin.add(scenetitle, 0,0,2,1);
       
       //Creates input field
       TextField userTextField = new TextField();
       userTextField.setId("textfield-user");
       userTextField.setPromptText("Username");
       userTextField.setPrefHeight(40);
       gridLogin.add(userTextField, 1,1);
       
       /* Label password = new Label("Password: ");
       gridLogin.add(password, 0,2);*/
       
       TextField passwordTextField = new TextField();
       passwordTextField.setId("textfield-password");
       passwordTextField.setPromptText("Password");
       passwordTextField.setPrefHeight(40);
       gridLogin.add(passwordTextField,1,2); 
       
       //Shows the grid
       //gridLogin.setGridLinesVisible(true);
       
       //Creates new button
       Button logIn = new Button("Sign in");
       logIn.setId("login-button");
       logIn.setPrefWidth(500);
       HBox hbBtn = new HBox(10);
       hbBtn.setAlignment(Pos.BOTTOM_CENTER);
       hbBtn.getChildren().add(logIn);
       gridLogin.add(hbBtn, 1,3);
       
       //Creates new button to access the create account window
       Button toUserScene = new Button("Or create an account");
       HBox userBtn = new HBox(10);
       userBtn.setAlignment(Pos.BOTTOM_RIGHT);
       userBtn.getChildren().add(toUserScene);
       gridLogin.add(userBtn, 1,4);
       
       //Creates new text for error message
       Text error = new Text();
       error.setId("error-text");
       gridLogin.add(error,2,1);
       
       //Creates new text for success message
       Text success = new Text();
       success.setId("success-text");
       gridLogin.add(success,1,5);
       
       //Sets text based on values in input fields
       logIn.setOnAction(e ->{
           if(userTextField.getText().isEmpty()){
                   success.setText("");
                   error.setText("Enter your username.");
               }
               else if(passwordTextField.getText().isEmpty()){
                   success.setText("");
                   error.setText("Enter your passsword.");
               }
               else if(userTextField.getText().equals("Marius") && passwordTextField.getText().equals("Test")){
                  error.setText(""); 
                  success.setText("Success!");
              }
              else{
                  success.setText("");
                  error.setText("Wrong username or password.");
              }
       });
       
       //SCENE LOGIN END
       
       //SCENE CREATE ACCOUNT START
       
       //Creates a new grid for the account window
       GridPane gridCreateAccount = new GridPane();
       gridCreateAccount.setAlignment(Pos.TOP_CENTER);
       gridCreateAccount.setHgap(10);
       gridCreateAccount.setVgap(10);
       gridCreateAccount.setPadding(new Insets(25, 25, 25, 25));
       
       //Creates new scene for creating of accounts
       Scene createAccount = new Scene(gridCreateAccount, 1024, 800);
       
       //Sets a title for the account window
       Text accountTitle = new Text("Create account");
       accountTitle.setId("account-title");
       gridCreateAccount.add(accountTitle, 0,0,2,1);
       
       //Creates text
       /*Label userName = new Label("Username: ");
       gridLogin.add(userName, 0,1);*/
       
       //Creates new button to return to the main window
       Button returnToLogIn = new Button("Go back");
       HBox returnBtn = new HBox(10);
       returnBtn.setAlignment(Pos.TOP_LEFT);
       returnBtn.getChildren().add(returnToLogIn);
       gridCreateAccount.add(returnBtn, 1, 1);
       
       //Textfield for creating username
       TextField createUsername = new TextField();
       createUsername.setId("create-username");
       createUsername.setPromptText("Username");
       createUsername.setPrefHeight(40);
       gridCreateAccount.add(createUsername, 1,15);
       
       //Textfield for creating password
       TextField createPassword = new TextField();
       createPassword.setId("create-password");
       createPassword.setPromptText("Type your password");
       createPassword.setPrefHeight(40);
       gridCreateAccount.add(createPassword, 1, 16);
       
       //Textfield for checking if passwords match
       TextField checkPassword = new TextField();
       checkPassword.setId("check-password");
       checkPassword.setPromptText("Retype your password");
       checkPassword.setPrefHeight(40);
       gridCreateAccount.add(checkPassword, 1, 17);
       
       //Button to register account
       Button registerAccount = new Button("Register account");
       HBox registerBtn = new HBox(10);
       registerBtn.setAlignment(Pos.BOTTOM_RIGHT);
       registerBtn.getChildren().add(registerAccount);
       gridCreateAccount.add(registerBtn, 1, 19);
       
       registerAccount.setOnAction(e -> {
           try {
               saveToFile("USERNAME: " + createUsername.getText() + "\r\n" , "PASSWORD: " + checkPassword.getText() + "\r\n"  + "\r\n");
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           } catch (UnsupportedEncodingException ex) {
               Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
       
       //SCENE CREATE ACCOUNT END
       
       //Changes scene to create account if pressed
       toUserScene.setOnAction(e -> {
           primaryStage.setScene(createAccount);
           primaryStage.setTitle("Create account");
               });
       
       //Returns to the login page
       returnToLogIn.setOnAction(e -> {
           primaryStage.setScene(scene);
           primaryStage.setTitle("Log in");
               });
       
       //Sets scene in stage
       primaryStage.setScene(createAccount);
       //Sets the path for the stylesheet
       scene.getStylesheets().add(Login.class.getResource("style.css").toExternalForm());
       createAccount.getStylesheets().add(Login.class.getResource("style.css").toExternalForm());
       
       //Calls the show method to show the window
       primaryStage.show();
    }

    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    //Saves username and password to file
    public static void saveToFile(String user, String password) throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter(new FileOutputStream(new File("accounts.txt"), true));
        
        writer.append(user);
        writer.append(password);
        writer.close();
        
    }
    
}
