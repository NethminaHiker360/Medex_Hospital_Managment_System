package com.developerstack.Medex.controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Cookie;

import java.io.IOException;

public class DoctorDashboardController {
    public AnchorPane DoctorDashboardContext;

    public void checkUser() throws IOException {
        if(null==Cookie.selectedUser){
            setUi("DoctorDashboard");
        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) DoctorDashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}


