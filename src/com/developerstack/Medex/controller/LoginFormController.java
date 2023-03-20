package com.developerstack.Medex.controller;

import com.developerstack.Medex.db.Database;
import com.developerstack.Medex.dto.UserDto;
import com.developerstack.Medex.enums.AccountType;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import util.Cookie;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public ToggleGroup AccoutType;
    public JFXRadioButton rbtnDoctor;
    public AnchorPane loginContext;

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        String email=txtEmail.getText();
        String password=txtPassword.getText();
        AccountType accountType=rbtnDoctor.isSelected()? AccountType.DOCTOR:AccountType.PATIENT;

        for (UserDto userDto:Database.userTable) {
            if (email.trim().toLowerCase().equals(userDto.getEmail())){
                if(password.equals(userDto.getPassword())){
                    if (accountType.equals(userDto.getAccountType())){
                        Cookie.selectedUser=userDto;
                        setUi("DoctorDashBoard");
                        new Alert(Alert.AlertType.WARNING,"Sucsessfully Login!").show();
                        return;
                    }else {
                        new Alert(Alert.AlertType.WARNING,"Wrong Account Type!").show();
                        return;
                    }
                }else {
                    new Alert(Alert.AlertType.WARNING,"Wrong Password!").show();
                    return;
                }
            }
        }
        new Alert(Alert.AlertType.WARNING,String.format("We can't find email %s",email)).show();
    }

    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignupForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
