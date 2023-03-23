package com.developerstack.Medex.controller;

import com.developerstack.Medex.db.Database;
import com.developerstack.Medex.dto.PatientDto;
import com.developerstack.Medex.view.tm.PatientTm;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class PatientManagmentFormController {

    public JFXTextField txtSearch;
    public JFXButton btnBack;
    public AnchorPane patientContext;
    public TableView<PatientTm> tblPatient;
    public TableColumn colNic;
    public TableColumn coloFirstName;
    public TableColumn colLastName;
    public TableColumn colDOB;
    public TableColumn colgender;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableColumn colEmail;

    public void initialize(){
        loadAllData("");
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            loadAllData(newValue);
        });

        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        coloFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colgender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    private void loadAllData(String s) {
        s=s.toLowerCase();
        ObservableList<PatientTm> patientTmList= FXCollections.observableArrayList();
//        Filtering
        for (PatientDto dto: Database.patientTable) {
            if(
                    dto.getFirstName().toLowerCase().contains(s)||
                    dto.getLastName().toLowerCase().contains(s)||
                    dto.getEmail().toLowerCase().contains(s)
            ){
                patientTmList.add(new PatientTm(
                        dto.getNic(), dto.getFirstName(),
                        dto.getLastName(),
                        new SimpleDateFormat("yyyy-MM-dd").format(dto.getDob()), // ------ make simple date format
                        dto.getGender(),
                        dto.getAddress(),
                        10, // ----------- Dynamically calculate Age
                        dto.getEmail()
                ));
            }
        }
        tblPatient.setItems(patientTmList);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        // Implement when logout button click function
    }

    public void btnPatientManagmentOnAction(ActionEvent actionEvent) {
    }
}
