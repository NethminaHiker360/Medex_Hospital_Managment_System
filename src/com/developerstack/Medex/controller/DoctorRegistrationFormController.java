package com.developerstack.Medex.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleGroup;

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

    public void submitDataOnAction(ActionEvent actionEvent) {
    }
}
