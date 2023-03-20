package com.developerstack.Medex.db;

import com.developerstack.Medex.dto.UserDto;
import com.developerstack.Medex.enums.AccountType;

import java.util.ArrayList;

public class Database {
    public static ArrayList<UserDto> userTable=new ArrayList();



    static {
        userTable.add(new UserDto
                ("Ravindu","Nethmina",
                        "kar@nethu.com","1234",
                        AccountType.DOCTOR));
        userTable.add(new UserDto
                ("Madara","Nethmini",
                        "mmn@nethu.com","1234",
                        AccountType.PATIENT));
    }


}
