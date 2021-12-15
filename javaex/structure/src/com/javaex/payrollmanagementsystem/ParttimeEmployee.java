package com.javaex.payrollmanagementsystem;

import java.sql.Date;

public class ParttimeEmployee extends Employee{
    
    private String exitdate;
    
    public ParttimeEmployee(){

    }
    public ParttimeEmployee(String name, int id, String depart, int pw, String date, double pay,
     int contract, String exitdate){
        super.setEmployee_name(name);
        super.setEmployee_id(id);
        super.setEmployee_department(depart);
        super.setEmployee_pw(pw);
        super.setEmployee_startdate(date);
        super.setEmployee_pay(pay);
        super.setEmployee_contract(contract);

        this.exitdate = exitdate;

    }
    public String getExitdate() {
        return exitdate;
    }
    public void setExitdate(String exitdate) {
        this.exitdate = exitdate;
    }

    
}
