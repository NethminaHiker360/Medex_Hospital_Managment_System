package com.developerstack.Medex.controller;

import com.developerstack.Medex.db.DBConnection;
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
import util.PasswordConfig;

import java.io.IOException;
import java.sql.*;

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

        //===========================

        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM user WHERE email=? AND account_type=?",
                    email,accountType.name());
            if(rst.next()){
                new PasswordConfig().decrypt(password,rst.getString("password"));
                if (accountType.equals(AccountType.DOCTOR)){
                    setUi("DoctorDashBoard");
                }else {
                    setUi("PatientDashboardForm");
                }
            }else {
                new Alert(Alert.AlertType.WARNING,String.format("We can't find email %s",email)).show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignupForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
