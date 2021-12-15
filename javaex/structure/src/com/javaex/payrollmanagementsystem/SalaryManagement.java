package com.javaex.payrollmanagementsystem;


import java.util.ArrayList;
import java.util.Scanner;

public class SalaryManagement {

     // private String empNum; // 사원(사원번호를 통해 검색)
     private FulltimeManage fm;
     private ParttimeManage partTime;
     Scanner sc = new Scanner(System.in);
  
          
     public SalaryManagement() { // 정규직
       
      fm = new FulltimeManage();
      partTime = new ParttimeManage();
     }


     public boolean checkAdmin(int id, int pw){
         if(id == 1111 && pw == 2222)
         {
            return true;
         }
         return false;

     }

     public void adminMode() {
        System.out.println("------------관리자 모드 ----------------");
        
        
        boolean flag = false;
    
        while(true) {
           
           System.out.println("1.번 등록 2.수정 3.삭제 4.검색 5.전체 조회 6.되돌아가기");
           int num = sc.nextInt();
           
           switch(num) {
           case 1:
              input();
              break;
           case 2:
              modifi();
              break;
           case 3:
              delete();
              break;
           case 4:
              search();
              break;
           case 5:
              allOutput();
              break;
           case 6:
              flag = true;
              break;
           }
           
           if(flag) {
              System.out.println("---------------관리자 모드 종료 -----------------");
              break;
              
           }
              
        }
        
     }

     public void UserMode(){
        System.out.println("------------사원 모드 ----------------");
        
        
        FulltimeManage fm = new FulltimeManage();
        
        
        while(true) {
  
           userSearch();
           System.out.println("---------------사원 모드 종료 -----------------");
            break;

           
              
        }
     }


     public void input(){

         System.out.println("1.정직원 등록 2.계약직 등록");
         int num = sc.nextInt();

         switch(num) {
            case 1:
               fm.input();
               break;
            case 2:
               partTime.input();
               break;
         }

     }

         public void modifi(){

            

            System.out.println("1.정직원 수정 2.계약직 수정");
            int num = sc.nextInt();

            switch(num) {
               case 1:
                  fm.modifi();
                  break;
               case 2:
                  partTime.modifi();
                  break;
            }

      }

      public void delete(){

         System.out.println("1.정직원 삭제 2.계약직 삭제");
         int num = sc.nextInt();

         switch(num) {
            case 1:
               fm.delete();
               break;
            case 2:
               partTime.delete();
               break;
         }

      }

      public void search(){

         System.out.println("1.정직원 검색 2.계약직 검색");
         int num = sc.nextInt();

         switch(num) {
            case 1:
               fm.search();
               break;
            case 2:
               partTime.search();
               break;
         }

      }

      
      public void allOutput(){

         System.out.println("1.정직원 출력 2.계약직 출력");
         int num = sc.nextInt();

         switch(num) {
            case 1:
               fm.allOutput();
               break;
            case 2:
               partTime.allOutput();
               break;
         }

      }

      public void userSearch(){

         System.out.println("1.정직원 조회 2.계약직 조회");
         int num = sc.nextInt();

         System.out.println("id와 pw를 입력하세요.");
         System.out.print("ID: ");

         int temp_id = sc.nextInt();
         System.out.print("Password: ");
         int temp_pw = sc.nextInt();

         switch(num) {
            case 1:
               fm.userSearch(temp_id, temp_pw);
               break;
            case 2:
               partTime.userSearch(temp_id, temp_pw);
               break;
         }

     }

  
 }
 