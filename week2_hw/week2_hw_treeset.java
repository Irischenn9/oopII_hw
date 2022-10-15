import java.util.*;
import java.util.Random;
public class week2_hw_treeset {
    public static void main(String[]args){

        var t=new TreeSet<>();
        var tt=new TreeSet<>();
        
        while(t.size()<10){ //總共10個數字
            
                int r = 0;
                r = (int)(Math.random()*100)+1;

                if(t.contains(r)){
                    continue;     //重複的不加入
                }else{
                    t.add(r);
                }
                if(r>=30&&r<=70){
                    tt.add(r);
                }
            System.out.println("第"+t.size()+"個號碼:"+r);         
   
           
        }
        System.out.println("物件內元素個數為"+t.size());
        System.out.println("物件內元素的內容"+t);
        System.out.println("第一個元素的內容為"+t.first());
        System.out.println("最後一個元素的內容"+t.last());
        System.out.println("內容介於30-70者:"+tt);
    }
}