package com.developerstack.Medex.enums;

public enum Gender {
    MALE(1),FEMALE(2);

    final int state;

    Gender(int state) {
        this.state = state;
    }
}
