package com.developerstack.Medex.controller;

import com.developerstack.Medex.db.Database;
import com.developerstack.Medex.dto.UserDto;
import com.developerstack.Medex.enums.AccountType;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;

public class LoginFormController {
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public ToggleGroup AccoutType;
    public JFXRadioButton rbtnDoctor;

    public void signInOnAction(ActionEvent actionEvent) {
        String email=txtEmail.getText();
        String password=txtPassword.getText();
        AccountType accountType=rbtnDoctor.isSelected()? AccountType.DOCTOR:AccountType.PATIENT;

        for (UserDto userDto:Database.userTable) {
            if (email.trim().toLowerCase().equals(userDto.getEmail())){
                if(password.equals(userDto.getPassword())){
                    if (accountType.equals(userDto.getAccountType())){
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

    public void createAnAccountOnAction(ActionEvent actionEvent) {
    }
}
