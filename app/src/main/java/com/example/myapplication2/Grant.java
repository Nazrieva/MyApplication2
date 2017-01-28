package com.example.myapplication2;

/**
 * Created by N on 29.01.2017.
 */
public class Grant {

    //свойства
    private String grantName;
    private String grantDescription;
    private String grantData;

    //конструктор для Firebase
    public Grant() {
    }

    //конструктор
    public Grant(String grantName, String grantDescription, String grantData) {
        this.grantName = grantName;
        this.grantDescription = grantDescription;
        this.grantData = grantData;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public String getGrantDescription() {
        return grantDescription;
    }

    public void setGrantDescription(String grantDescription) {
        this.grantDescription = grantDescription;
    }

    public String getGrantData() {
        return grantData;
    }

    public void setGrantData(String grantData) {
        this.grantData = grantData;
    }

}
