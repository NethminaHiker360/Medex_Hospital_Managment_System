package com.developerstack.Medex.controller;

import com.developerstack.Medex.db.Database;
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

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

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
                txtPassword.getText(),accountType);
        try {
            Class.forName("com.mysql.jdbc.cj.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/medex_home_git",
                            "root","1234");
            String sql="INSERT INTO user VALUES (?,?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,1001);
            pstm.setString(2,new_user.getFirstName());
            pstm.setString(3,new_user.getLastName());
            pstm.setString(4,new_user.getEmail());
            pstm.setString(5,new_user.getPassword());
            pstm.setString(6,new_user.getAccountType().name());

            int isSaved = pstm.executeUpdate();
            if (isSaved>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved!").show();
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
