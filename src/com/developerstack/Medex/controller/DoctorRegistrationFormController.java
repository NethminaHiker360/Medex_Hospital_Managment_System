package com.developerstack.Medex.controller;

import com.developerstack.Medex.db.Database;
import com.developerstack.Medex.dto.DoctorDto;
import com.developerstack.Medex.enums.Gender;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class DoctorRegistrationFormController {

    public JFXRadioButton rbtnMale;
    public ToggleGroup gender;
    public JFXTextArea txtAddress;
    public JFXTextField txtSpecialization;
    public JFXTextField txtEmail;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtNic;
    public JFXTextField txtContact;
    public JFXButton doctorRegistrationFormPane;

    public void submitDataOnAction(ActionEvent actionEvent) {
        DoctorDto doctorDto=new DoctorDto(txtFirstName.getText(),
                txtLastName.getText(),txtNic.getText(),
                txtContact.getText(),txtEmail.getText(),
                txtSpecialization.getText(),txtAddress.getText(),
                rbtnMale.isSelected()? Gender.MALE:Gender.FEMALE);

        Database.doctorTable.add(doctorDto);
        Stage stage = (Stage) doctorRegistrationFormPane.getScene().getWindow();
        stage.close();
    }
}
