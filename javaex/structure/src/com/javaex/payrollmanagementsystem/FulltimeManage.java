package com.javaex.payrollmanagementsystem;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FulltimeManage implements IPayrollManage {    
 
    FulltimeEmployee fe; 
    ArrayList<FulltimeEmployee> felist;
    Scanner sc;
 
   
 
    public FulltimeManage() {
        felist  = new ArrayList<>();
    }
    // 입력
    public void input() {
 
        sc = new Scanner(System.in);
 
        
        System.out.println("정규직 " +  "직원 정보 입력");

        System.out.print( "직원 이름 입력 : ");
        String name = sc.next();
        System.out.println();

        System.out.print( "직원 사번 입력 : ");
        int id = sc.nextInt();
        System.out.println();

        System.out.print("직원 부서 입력: ");
        String depart = sc.next();
        System.out.println();

        System.out.print( "직원 비밀번호 입력 : ");
        int pw = sc.nextInt();
        System.out.println();

     
        System.out.print( "직원 입사일 입력 : (yyyyMMdd 형태로)");
        String date = sc.next();
        System.out.println();

    
        System.out.print("직원 직책 입력 : ");
        String positon = sc.next();
        Position pos =  Position.valueOf(positon);
        System.out.println();


        double pay = getSalary(pos); 


        fe = new FulltimeEmployee(name, id, depart, pw, date, pay, pos, 1);
        felist.add(fe);
    }

    @Override
    public double getSalary(Position pos){
        
        double insen = 0;
        double pay = 3000000;

        switch(pos){
            case P1 :
                insen += 0;
                return insen + pay;
            case P2:
                insen += 1000000;
                return insen + pay;
            case P3 :
                insen += 2000000;
                return insen + pay;
            case P4 :
                insen += 3000000;
                return insen + pay;
            case P5 :
                insen += 4000000;
                return insen + pay;
            case P6 :
                insen += 5000000;
                return insen + pay;
        }
        return insen + pay;

    }
 
    // 수정
    public void modifi() {
 
        sc = new Scanner(System.in);
 
        System.out.print("수정하고 싶은 직원 이름을 입력하세요 : ");
            String tmpName = sc.next();
 
            boolean exist = true;
 
            for (int i = 0; i < felist.size(); i++) {
                if (felist.get(i).getEmployee_name().equals(tmpName)) {
 
                    System.out.println("수정하고 싶은 데이터를 선택하세요..");
                    System.out.println("1.이름 2.부서 3.비밀번호 4.직책");
                    System.out.print("-> ");
                    int num = sc.nextInt(); // 번호 선택
 
                    String sTmp = "";
                    int iTmp = 0;
                    long salary = 0;
 
                    switch (num) {
                    case 1: // 이름수정
                        System.out.print("수정할 데이터를 입력하세요 : ");
                        sTmp = sc.next();
                        felist.get(i).setEmployee_name(sTmp);
                        break;
                    case 2: // 부서 수정
                        System.out.print("수정할 데이터를 입력하세요 : ");
                        sTmp = sc.next();
                        felist.get(i).setEmployee_department(sTmp);
                        break;
                    case 3: // 비번
                        System.out.print("수정할 데이터를 입력하세요 : ");
                        iTmp = sc.nextInt();
                        felist.get(i).setEmployee_pw(iTmp);
                        break;
                
                    case 4: // 직책 수정
                        System.out.print("수정할 데이터를 입력하세요 : ");
                        sTmp = sc.next();
                        Position pos =  Position.valueOf(sTmp);
                        felist.get(i).setPos(pos);
                        felist.get(i).setEmployee_pay(getSalary(pos));
                        break;
                 
                    default:
                        System.out.println("잘못 입력하였습니다.");
                    }
                    exist = true;
                    System.out.println();
                    System.out.println("수정완료!!");
                }
                if (!exist)
                    System.out.println("검색하신 " + tmpName + " 직원에 대한 정보가 없습니다.");
 
            }
    }
 
    // 삭제
    public void delete() {
 
        System.out.print("삭제할 직원의 이름을 입력하세요 : ");
        String tmpName = sc.next();
 
        boolean exist = false;
 
            
            
           for (int i = 0; i <felist.size() ; i++) {
               if (felist.get(i).getEmployee_name().equals(tmpName)) {
                    felist.remove(i);
                   exist = true;
                    System.out.println("삭제완료!!");
                    break;
                }
            
           }
            if (!exist)
              System.out.println("검색하신 " + tmpName + " 직원에 대한 정보가 없습니다.");
    }
 
    // 검색
    public void search() { // 이름 검색
 
        

        System.out.print("검색하고 싶은 직원 이름을 입력하세요 : ");
        String tmpName = sc.next();

        boolean exist = false;

        for (int i = 0; i < felist.size(); i++) {
            if (felist.get(i).getEmployee_name().equals(tmpName)) {
                disp(felist.get(i));

                exist = true;
            }
        }
        if (!exist)
            System.out.println("검색하신 " + tmpName + " 직원에 대한 정보가 없습니다.");

        exist = !exist;
 
    
     
    }

    // 출력
    public void allOutput() {

        System.out.println("-----------------------------------");
        System.out.println("----------정규직 직원 전체 출력----------");
        System.out.println("-----------------------------------");

        for(int i = 0; i < felist.size(); i ++) {
        	disp(felist.get(i));
        }
        
    }
 
    //유저검색
    public void userSearch(int num, int password) { 

        boolean exist = false;


        for(int i = 0; i < felist.size(); i++) {

            FulltimeEmployee data = new FulltimeEmployee();
            data  = felist.get(i);
 
            if(num == data.getEmployee_id() && password == data.getEmployee_pw()){
                disp(fe);

                exist = true;
            }
            if (!exist)
                System.out.println("직원 정보 없음");

            exist = !exist;

    }
}

 
    //출력
    public void disp(FulltimeEmployee fe) {
        System.out.println("----------------------------------------");
        System.out.println("사번 : " + fe.getEmployee_id()); // 사번
        System.out.println("이름 : " + fe.getEmployee_name()); // 이름
        System.out.println("직책 : " + fe.getPos()); // 직책
        System.out.println("소속부서 : " + fe.getEmployee_department()); // 소속부서
        System.out.println("급여 : " + fe.getEmployee_pay()); // 급여
        System.out.println("입사일 : " + fe.getEmployee_startdate()); // 근속년도
        System.out.println("고용형태 : " + fe.getEmployee_contract()); // 근속년도
        System.out.println("----------------------------------------");
    }
}

