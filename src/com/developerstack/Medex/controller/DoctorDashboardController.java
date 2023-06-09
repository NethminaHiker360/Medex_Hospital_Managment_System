package com.developerstack.Medex.controller;


import com.developerstack.Medex.db.Database;
import com.developerstack.Medex.dto.DoctorDto;
import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Cookie;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DoctorDashboardController {
    public AnchorPane DoctorDashboardContext;
    public Label lblDate;
    public Label lblTime;
    public JFXButton btnPatientManagment;

    public void checkUser() throws IOException {
        if(null==Cookie.selectedUser){
            setUi("LoginForm");
        }
    }

    private void intializeData() {
//        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        lblDate.setText(String.valueOf(LocalDate.now()));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime now = LocalTime.now();
            String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            lblTime.setText(formattedTime);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        // Set Time to label
    }

    public void initialize() throws IOException {
//        checkUser();
        intializeData();
        checkDoctorDto();
    }

    private void checkDoctorDto() throws IOException {
        Optional<DoctorDto> selecterDoctor = Database.doctorTable.stream().
                filter(doctorDto -> doctorDto.getEmail().
                        equals("kar@neth.com")).findFirst();
        if(!selecterDoctor.isPresent()){
            Stage stage=new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DoctorRegistrationForm.fxml"))));
            stage.show();
        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) DoctorDashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        // Avoid Boiler Plate code to optimize performance and code readabiliy
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    public void btnPatientManagmentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PatientManagmentForm");
    }
}


