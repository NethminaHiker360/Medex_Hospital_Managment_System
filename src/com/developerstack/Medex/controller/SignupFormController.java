package com.developerstack.Medex.controller;
import com.developerstack.Medex.db.DBConnection;
import com.developerstack.Medex.dto.User;
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
import util.CrudUtil;
import util.IdGenerator;
import util.PasswordConfig;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupFormController {
    public AnchorPane signupformContext;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXRadioButton rbtnDoctor;
    public ToggleGroup AccoutType;


    public void signupOnAction(ActionEvent actionEvent) throws IOException {
        AccountType accountType=rbtnDoctor.isSelected()? AccountType.DOCTOR:AccountType.PATIENT;
        User new_user=new User(txtFirstName.getText(),txtLastName.getText(),txtEmail.getText().trim().toLowerCase(),
                new PasswordConfig().encrypt(txtPassword.getText()),accountType);
        try {
            boolean isSaved = CrudUtil.executeUpdate("INSERT INTO user VALUES (?,?,?,?,?,?)",
                    new IdGenerator().generateId(),new_user.getFirstName(),
                    new_user.getLastName(),new_user.getEmail(),new_user.getPassword(),
                    new_user.getAccountType().name()
                    );
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved!").show();
                setUi("LoginForm");
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again").show();
            }
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
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
