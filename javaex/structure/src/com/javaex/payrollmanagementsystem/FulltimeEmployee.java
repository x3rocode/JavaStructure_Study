package com.javaex.payrollmanagementsystem;

enum Position {
    P1,  //0
    P2,
    P3,
    P4,
    P5,
    P6  //높
}

public class FulltimeEmployee extends Employee{

    
    private Position pos;
    public FulltimeEmployee(){

    }
    public FulltimeEmployee(String name, int id, String depart, int pw, String date, double pay,
    Position pos, int contract){
        super.setEmployee_name(name);
        super.setEmployee_id(id);
        super.setEmployee_department(depart);
        super.setEmployee_pw(pw);
        super.setEmployee_startdate(date);
        super.setEmployee_pay(pay);
        super.setEmployee_contract(contract);
        setPos(pos);

    }
    public Position getPos() {
        return pos;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }

    


}
