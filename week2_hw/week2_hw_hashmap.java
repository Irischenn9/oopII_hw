import java.util.*;
public class week2_hw_hashmap {
    public static void main(String[]args){
        var month=new HashMap<>();
        month.put("1","January");
        month.put("2","Febuary");
        month.put("3","March");
        month.put("4","April");
        month.put("5","May");
        month.put("6","June");
        month.put("7","July");
        month.put("8","August");
        month.put("9","September");
        month.put("10","October");
        month.put("11","November");
        month.put("12","December");

        System.out.println("請輸入1~12:");
        Scanner sc=new Scanner(System.in);
        String num=sc.next();
        while(month.get(num)==null){
            System.out.println("範圍輸入錯誤");
            System.out.println("請輸入1~12:");
            num=sc.next();
        }
        System.out.println("第"+num+"月的英文單字為"+month.get(num));
        






    }
    
}
