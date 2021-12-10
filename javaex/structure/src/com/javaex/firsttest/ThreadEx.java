package javaex.structure.src.com.javaex.firsttest;

public class ThreadEx implements Runnable {

    private int [] arr;
    public ThreadEx(){
        arr = new int[4];

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = i;
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i = 0; i < arr.length; i++)
        {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " " + arr[i]);
        }
        
    }

    public static void main(String[] args) {
        ThreadEx te = new ThreadEx(); // 쓰레드 생성x 환경을 만든거
        //te.start();  // runnable 상태
        Thread th = new Thread(te);  //동적 바인딩
        th.start();
    }


}
