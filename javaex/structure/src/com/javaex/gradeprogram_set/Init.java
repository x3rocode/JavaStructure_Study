package javaex.structure.src.com.javaex.gradeprogram_set;

import java.util.Scanner;

public class Init {

    public Student [] data = {}; 

    Scanner scanner = new Scanner(System.in);

    public void Start(){

        boolean b = true;
        while(b)
        {
            
            System.out.println("성적처리프로그램");
            System.err.println("1. 입력  // 2. 검색  //3. 출력 //4. 종료");
            int c = scanner.nextInt();

            switch(c){
                case 1:
                    Scan();
                    break;
                case 2:
                    NameSearch();
                    break;

                case 3: 
                    Print();
                    break;
                case 4:
                    b = false;
                    break;
                

            }
           
        }
        scanner.close();
    }

    public void AveSearch(){
        for(int i = 0; i <= data.length - 1; i++){
            if(data[i].getAverage() >= 50)
            {
                Print(data[i]);
                //System.out.println(data[i].toString());
            }

        }

    }

    public Student Search(String name){
        for(int i = 0; i <= data.length - 1; i++){
            if(data[i].getName().equals(name) )
            {
                return data[i];
            }

        }
        return null;

    }

    public void NameSearch(){
        String name = null;
        Student s = null;
        System.out.println("1. 이름검색 // 2. 평균검색");
        int c = scanner.nextInt();
        switch(c){
            case 1:
                name = scanner.next();
                s = Search(name);
                Print(s);
                break;
            case 2:
                AveSearch();
                break;
        
        }

    }


    public void Average(){
        for(int i = 0; i <= data.length - 1; i++){
            int sum = 0; 

            sum = data[i].getKor_grade() + data[i].getEng_grade() + data[i].getMat_grade();

            data[i].setAverage((float)sum / 3);
        }
    }

    public void Scan(){

        int count, kor, eng, mat;
        String name = ""; 

        System.out.println("인원 수 : ");
        count = scanner.nextInt();



        data = new Student[count];

        for(int i = 0; i <= count - 1; i++)
        {
            Student s = new Student();
            System.out.println(i + 1 + "번째 학생 이름 입력 : ");
            name = scanner.next();
            System.out.println("국어 점수 : " );
            kor = scanner.nextInt();
            System.out.println("영어 점수 : "  );
            eng = scanner.nextInt();
            System.out.println("수학 점수 : " );
            mat = scanner.nextInt();

            s.setName(name);
            s.setKor_grade(kor);
            s.setEng_grade(eng);
            s.setMat_grade(mat);

            data[i] = s;

            
        }
        Average();

    }

    public void Print(){
        for(int i = 0; i <= data.length-1; i++)
        {
            System.out.println(data[i].toString());
        }
    }

    public void Print(Student s){
        System.out.println(s.toString());
    }
}
