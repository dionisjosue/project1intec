package com.example.android.intecademy;

/**
 * Created by USER on 8/27/2017.
 */

public class SubjetcInfo {
    String name;
    int credits;
    String code;
    int nota;
    public SubjetcInfo(String name, String code, int credits){
        this.name = name;
        this.code = code;
        this.credits = credits;
    }
    public SubjetcInfo(String name, int credits){
        this.name = name;
        this.credits = credits;
        this. code = "NULL";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.credits;
    }
}
