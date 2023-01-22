package com.example.tellme;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.tellme.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField loginField;

    @FXML
    void initialize() {
        SignInButton.setOnAction(event -> {
            String loginText=loginField.getText().trim();
            String loginPassword=PasswordField.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals(""))
            {
                loginUser(loginText,loginPassword);

            }
            else System.out.println("Error Login and password is empty");
        });
        SignUpButton.setOnAction(event -> {
            SignUpButton.getScene().getWindow().hide();

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("signUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root =loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });


    }

    private void loginUser(String loginText, String loginPassword) {
        System.out.println("login:"+loginText);
        System.out.println("loginPassword:"+loginPassword);
        DatabaseHandler databaseHandler= new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);

        ResultSet result = databaseHandler.getUser(user);


        int counter = 0;
        try {
             if (result.next()) {
                 counter++;
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >= 1) {
            openNewScene("app.fxml");

        } else {
            Shake userLoginAnim =new Shake(loginField);
            Shake userPassAnim =new Shake(PasswordField);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();



        }

    }
    public  void openNewScene(String window)
    {
        SignUpButton.getScene().getWindow().hide();

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root =loader.getRoot();
        Stage stage=new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
/*
    void initialize() {

        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert login1 != null : "fx:id=\"login1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert register != null : "fx:id=\"register\" was not injected: check your FXML file 'hello-view.fxml'.";
        register.setOnAction(event -> {
            register.getScene().getWindow().hide();

            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("SingUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

    }
*/