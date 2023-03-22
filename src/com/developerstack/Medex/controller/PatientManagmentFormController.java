package com.developerstack.Medex.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class PatientManagmentFormController {

    public JFXTextField txtSearch;
    public JFXButton btnBack;
    public AnchorPane patientContext;
    public TableView tblPatient;
    public TableColumn colNic;
    public TableColumn coloFirstName;
    public TableColumn colLastName;
    public TableColumn colDOB;
    public TableColumn colgender;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableColumn colEmail;

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        
    }
}
