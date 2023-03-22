package com.developerstack.Medex.controller;

import com.developerstack.Medex.db.Database;
import com.developerstack.Medex.dto.PatientDto;
import com.developerstack.Medex.view.tm.PatientTm;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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
    }

    private void loadAllData(String s) {
        s=s.toLowerCase();
        ObservableList<PatientTm> patientTmList= FXCollections.observableArrayList();
//        Filtering
        for (PatientDto dto: Database.patientTable) {
            if(
                    dto.getFirstName().contains(s) ||
                            dto.getLastName().contains(s)||
                            dto.getEmail().contains(s)
            ){
                patientTmList.add(new PatientTm(
                        dto.getNic(), dto.getFirstName(),
                        dto.getLastName(), dto.getDob(),
                        dto.getGender(), dto.getAddress(),
                        10, dto.getEmail()
                ));
            }
        }
        tblPatient.setItems(patientTmList);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        
    }
}
