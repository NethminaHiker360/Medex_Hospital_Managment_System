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

import java.io.IOException;
import java.util.Optional;
import java.util.function.Predicate;

public class SignupFormController {
    public AnchorPane signupformContext;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXRadioButton rbtnDoctor;
    public ToggleGroup AccoutType;

    public void signupOnAction(ActionEvent actionEvent) throws IOException {
        String email=txtEmail.getText();
        AccountType accountType=rbtnDoctor.isSelected()? AccountType.DOCTOR:AccountType.PATIENT;
        Optional<UserDto> user = Database.userTable.stream().filter(userDto -> userDto.getEmail().equals(email.toLowerCase())).findFirst();
        if(user.isPresent()){
            new Alert(Alert.AlertType.WARNING,"Email Already exists!").show();
        }else {
            Database.userTable.add(new UserDto(txtFirstName.getText(),txtLastName.getText(),txtEmail.getText(),
                    txtPassword.getText(),accountType));
            new Alert(Alert.AlertType.CONFIRMATION,"User Added !").show();
            setUi("LoginForm");
        }
    }

    public void alreadyhaveanAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) signupformContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
