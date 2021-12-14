package javaex.structure.src.com.javaex.payrollmanagementsystem;

import java.util.Scanner;

public class PayrollApp {
	

	public static void main(String[] args) {
		
		SalaryManagement sm = new SalaryManagement();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("—————급여 관리 시스템—————");
		
		while(true) {
			boolean adcheck = false;
			System.out.println("1. 관리자 모드 2. 사용자 모드 3. 프로그램 종료");
		
			int num = sc.nextInt();
			int temp_id = 0;
            int temp_pw = 0;
			switch(num) {
			case 1:
				System.out.println("id와 pw를 입력하세요.");
				System.out.print("ID: ");
		
                temp_id = sc.nextInt();
				System.out.print("Password: ");
			
                temp_pw = sc.nextInt();
				
				if(sm.checkAdmin(temp_id, temp_pw)) {
					// 관리자 모드 진입
					sm.adminMode();
				} else {
					adcheck = false;
					break;
				}
				// 관리자 모드
				break;
			case 2:

				sm.UserMode();
				// 사용자 모드
				break;
			case 3:
				System.out.println("————급여 관리 시스템 종료————");
				sc.close();
				return;
			}
		}
	
	}
	
}