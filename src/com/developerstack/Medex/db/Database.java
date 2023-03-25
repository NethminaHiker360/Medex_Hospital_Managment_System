package com.developerstack.Medex.db;

import com.developerstack.Medex.dto.DoctorDto;
import com.developerstack.Medex.dto.PatientDto;
import com.developerstack.Medex.dto.User;
import com.developerstack.Medex.enums.AccountType;
import com.developerstack.Medex.enums.Gender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Database {
    public static ArrayList<User> userTable=new ArrayList();
    public static ArrayList<DoctorDto> doctorTable=new ArrayList();

    public static ArrayList<PatientDto> patientTable=new ArrayList();


    static {
        userTable.add(new User
                ("Ravindu","Nethmina",
                        "kar@nethu.com","1234",
                        AccountType.DOCTOR));
        userTable.add(new User
                ("Madara","Nethmini",
                        "mmn@nethu.com","1234",
                        AccountType.PATIENT));

//        ------------------------------------------------
        doctorTable.add(new DoctorDto("Ravindu","Nethmina"
        ,"1234v","+947684932","kar@nethu.com",
                "Eye","Galle", Gender.MALE));
        //------------------------------------------------------
        try {
            patientTable.add(new PatientDto("123","Wasantha","Namal",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1995-02-07"),
                    Gender.MALE,"galle","wasth.nam@gmail.com"));
            patientTable.add(new PatientDto("345","aruni","gamage",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1999-04-24"),
                    Gender.FEMALE,"kadawatha","Devop.nam@gmail.com"));
            patientTable.add(new PatientDto("677","Wasantha","basnayaka",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1988-08-10")
                    ,Gender.MALE,"rathnapura","Canda.nam@gmail.com"));
            patientTable.add(new PatientDto("765","maleesha","Namal",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1997-11-17"),
                    Gender.FEMALE,"mathara","acer.nam@gmail.com"));
            patientTable.add(new PatientDto("9789","pankaja","pathum",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1993-04-12"),
                    Gender.MALE,"tanglle","mudali.nam@gmail.com"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
