package com.example.tellme;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox SignUpCheckBoxFeMal;

    @FXML
    private CheckBox SignUpCheckBoxMal;

    @FXML
    private TextField SignUpCountry;

    @FXML
    private TextField SignUpLastName;

    @FXML
    private TextField SignUpName;

    @FXML
    private TextField SignUpName1;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button SignUpNextButtonOne;

    @FXML
    void initialize() {

        SignUpNextButtonOne.setOnAction(event -> {

            signUpNewUser();




        });


    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler =new DatabaseHandler();
        String firstName = SignUpName.getText();
        String lastName = SignUpLastName.getText();
        String userName =  SignUpName1.getText();
        String password = passwordField.getText();
        String location = SignUpCountry.getText();
        String gender = "";
        if (SignUpCheckBoxMal.isSelected())
            gender="мужской";
        else
            gender="женский";
        User user = new User(firstName,lastName,userName,password,location,gender);


        dbHandler.signUpUser(user);
    }

}
