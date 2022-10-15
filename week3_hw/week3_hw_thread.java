import java.security.SecureRandom;

class ticketClass implements Runnable{
   static int total=10000;
//    static int num=0;
   int ticket;
   Thread t;

   ticketClass(String name){
        ticket=0;
        t=new Thread(this, name);
        t.start();
    }
   
    public void run(){
        
        while(buyTicket()==true){
            int num=numTicket();
            ticket+=num;
            // System.out.println(t.getName()+"賣了"+num+"張票");

        } 
        System.out.println(t.getName()+"總共賣了"+ticket+"張票");
    }

    private static int numTicket(){
        SecureRandom randomNumbers=new SecureRandom();
        int num=0;
        num=randomNumbers.nextInt(4)+1;
        return num;

    }




    synchronized private static boolean buyTicket(){
        int num;
        num=numTicket();
        if(total>0){  
            total-=num;
            return true;
           
        }else{
            return false;
        }
    }
}

public class week3_hw_thread{
    public static void main(String[] args){
        ticketClass tA=new ticketClass("售票機A");
        ticketClass tB=new ticketClass("售票機B");
        ticketClass tC=new ticketClass("售票機C");
        ticketClass tD=new ticketClass("售票機D");

    }
}