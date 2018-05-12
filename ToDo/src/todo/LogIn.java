/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.awt.Image;
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
public class LogIn extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Sets the title of the window
       primaryStage.setTitle("Log in");
       //Removes the ability to resize the log in window
       primaryStage.setResizable(false);
       
       //Creates a new grid
       GridPane grid = new GridPane();
       grid.setAlignment(Pos.CENTER);
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(25, 25, 25, 25));
       
       //Sets a welcome text
       Text scenetitle = new Text("Welcome");
       scenetitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
       grid.add(scenetitle, 0,0,2,1);
       
       //Creates input field
       Label userName = new Label("Username: ");
       grid.add(userName, 0,1);
       
       TextField userTextField = new TextField();
       grid.add(userTextField, 1,1);
       
       Label password = new Label("Password: ");
       grid.add(password, 0,2);
       
       TextField passwordTextField = new TextField();
       grid.add(passwordTextField,1,2); 
       
       //Shows the grid
       //grid.setGridLinesVisible(true);
       
       Button logIn = new Button("Sign in");
       HBox hbBtn = new HBox(10);
       hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
       hbBtn.getChildren().add(logIn);
       grid.add(hbBtn, 1,4);
       
       Button createUser = new Button("Or create an account");
       HBox userBtn = new HBox(10);
       userBtn.setAlignment(Pos.BOTTOM_RIGHT);
       userBtn.getChildren().add(createUser);
       grid.add(userBtn, 1,5);
       
       Text actiontarget = new Text();
       grid.add(actiontarget,1,6);
       
       
       logIn.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent e){
               if(userTextField.getText().isEmpty()){
                   actiontarget.setFill(Color.FIREBRICK);
                   actiontarget.setText("Enter your username.");
               }
               else if(passwordTextField.getText().isEmpty()){
                   actiontarget.setFill(Color.FIREBRICK);
                   actiontarget.setText("Enter your passsword.");
               }
               else if(userTextField.getText().equals("Marius") && passwordTextField.getText().equals("Test")){
                  actiontarget.setFill(Color.GREEN);
                  actiontarget.setText("Success!");
              }
              else{
                  actiontarget.setFill(Color.FIREBRICK);
                  actiontarget.setText("Wrong username or password.");
              }
           }
       });
       
       Scene scene = new Scene(grid, 300, 300);
       
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
