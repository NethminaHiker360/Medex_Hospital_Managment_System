package com.developerstack.Medex.db;

import com.developerstack.Medex.dto.DoctorDto;
import com.developerstack.Medex.dto.UserDto;
import com.developerstack.Medex.enums.AccountType;
import com.developerstack.Medex.enums.Gender;

import java.util.ArrayList;

public class Database {
    public static ArrayList<UserDto> userTable=new ArrayList();
    public static ArrayList<DoctorDto> doctorTable=new ArrayList<>();


    static {
        userTable.add(new UserDto
                ("Ravindu","Nethmina",
                        "kar@nethu.com","1234",
                        AccountType.DOCTOR));
        userTable.add(new UserDto
                ("Madara","Nethmini",
                        "mmn@nethu.com","1234",
                        AccountType.PATIENT));

//        ------------------------------------------------
        doctorTable.add(new DoctorDto("Ravindu","Nethmina"
        ,"964374823v","+947684932","kar@nethu.com",
                "Eye","Galle", Gender.MALE));
    }


}
