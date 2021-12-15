package com.javaex.payrollmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ParttimeManage  implements IPayrollManage{
    ParttimeEmployee fe; 
    ArrayList<ParttimeEmployee> felist;
 
    private ParttimeManage sm; // 급여관리클래스
    private int numOfRegular; // 정규직 최대 인원수
   
 
    public ParttimeManage() {
        this(0);
    }
 
    public ParttimeManage(int numOfRegular) {
        this.numOfRegular = numOfRegular;
 
        // 사람 수 만큼 정규직 직원 생성
        felist  = new ArrayList<>();
        sm = null;
    }
 
    // setter,getter
    public ArrayList<ParttimeEmployee> getFe() {
        return felist;
    }
 
    public void setFe(ArrayList<ParttimeEmployee> list) {
        this.felist = list;
    }
 
    public ParttimeManage getSm() {
        return sm;
    }
 

    // 입력
    public void input() {
 
        Scanner sc = new Scanner(System.in);
 
        
        System.out.println("--------- 직원 정보 입력 -------------");


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

   
        System.out.print("직원 퇴사일 입력 : (yyyyMMdd 형태로)");
        String exdate = sc.next();
        System.out.println();

        Position pos =  Position.valueOf("P1");
        double pay = getSalary(pos); 



        fe = new ParttimeEmployee(name, id, depart, pw, date, pay, 2, exdate);
        felist.add(fe);

    }

    @Override
    public double getSalary(Position pos){
        

        return 1000;

    }
 
    // 수정
    public void modifi() {
 
        Scanner sc = new Scanner(System.in);
 
        System.out.print("수정하고 싶은 직원 이름을 입력하세요 : ");
            String tmpName = sc.next();
 
            boolean exist = true;
 
            for (int i = 0; i < felist.size(); i++) {
                if (felist.get(i).getEmployee_name().equals(tmpName)) {
 
                    System.out.println("수정하고 싶은 데이터를 선택하세요..");
                    System.out.println("1.이름 2.부서 3.비밀번호 ");
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
 
        Scanner sc = new Scanner(System.in);
 
        System.out.print("삭제할 직원의 이름을 입력하세요 : ");
            String tmpName = sc.next();
 
            boolean exist = false;
 
            for (int i = 0; i <felist.size() ; i++) {
                if (felist.get(i).getEmployee_name().equals(tmpName)) {
                    felist.remove(i);
                    exist = true;
                }
                System.out.println("삭제완료!!");
            }
            if (!exist)
                System.out.println("검색하신 " + tmpName + " 직원에 대한 정보가 없습니다.");

    }
 
    // 검색
    public void search() { // 이름 검색
 
        Scanner sc = new Scanner(System.in);

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
        System.out.println("----------계약직 직원 전체 출력----------");
        System.out.println("-----------------------------------");

        for(int i = 0; i < felist.size(); i ++) {
        	disp(felist.get(i));
        }
    }
 
    //유저검색
    public void userSearch(int num, int password) { // 사용자에서 사번과 이름을 받아옴

        boolean exist = false;


        for(int i = 0; i < felist.size(); i++) {

            ParttimeEmployee data = new ParttimeEmployee();
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
    public void disp(ParttimeEmployee fe) {
        System.out.println("----------------------------------------");
        System.out.println("사번 : " + fe.getEmployee_id()); // 사번
        System.out.println("이름 : " + fe.getEmployee_name()); // 이름
        System.out.println("소속부서 : " + fe.getEmployee_department()); // 소속부서
        System.out.println("급여 : " + fe.getEmployee_pay()); // 급여
        System.out.println("입사일 : " + fe.getEmployee_startdate()); // 근속년도
        System.out.println("고용형태 : " + fe.getEmployee_contract()); // 근속년도
        System.out.println("퇴사일 : " + fe.getExitdate()); // 근속년도
        System.out.println("----------------------------------------");
    }
}
