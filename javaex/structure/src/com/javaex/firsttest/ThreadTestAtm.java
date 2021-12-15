package com.javaex.firsttest;

class ATM implements Runnable {
    private long depositeMoney = 10000;

    @Override
    public void run() {
        synchronized(this) {   //동기화 처리
            for( int i = 0; i < 10; i ++)
            {
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                if(getDepositeMoney() <= 0)
                {
                    break;
                }
                withDraw(1000);
                this.notify();

                try{
                    this.wait();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        }
      
    }


    public void withDraw(long howMuch) {
        System.out.println(Thread.currentThread().getName() + ", ");
        if(getDepositeMoney() > 0) {
            depositeMoney -= howMuch;
            System.err.printf("잔액 : %d원 %n", getDepositeMoney());
        }else {
            System.out.println("잔액 부족");
        }
    }

    public long getDepositeMoney(){
        return depositeMoney;
    }
}

public class ThreadTestAtm {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread trd_mom = new Thread(atm, "mom");
        Thread trd_son = new Thread(atm, "son");

        trd_mom.start();
        trd_son.start();
    }
}
