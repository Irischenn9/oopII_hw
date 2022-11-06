import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MyJFrame extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JPanel upPane;
    private JTextField contentResult;

    private JLabel  space1;
    private JLabel  space2;
    private JLabel  space3;

    String symbol;
    String num1;
    String num2;
    String operator;


    MyJFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//視窗只要按叉就會整個關掉(不會在背後繼續執行)
        setTitle("Calculator");//視窗標題
        setBounds(200, 200, 450, 300);//視窗大小
        
       
        operator=num1=num2="";

        upPane=new JPanel();
        upPane.setLayout(new BorderLayout(10,10));
        setContentPane(upPane);
       
        contentPane=new JPanel();
        contentPane.setLayout(new GridLayout(5,4,40,20));//GridLayout方法 用空格排序

        contentResult = new JTextField(20);
        upPane.add(contentResult, BorderLayout.NORTH);
  

       

        //計算機按鍵
        JButton c=new JButton("c");
        contentPane.add(c);

        space1 = new JLabel(" ");
        contentPane.add(space1);

        space2 = new JLabel(" ");
        contentPane.add(space2);

        space3 = new JLabel(" ");
        contentPane.add(space3);

        JButton btn7=new JButton("7");
        btn7.addActionListener(this);
        contentPane.add(btn7);

        JButton btn8=new JButton("8");
        btn8.addActionListener(this);
        contentPane.add(btn8);

        JButton btn9=new JButton("9");
        btn9.addActionListener(this);
        contentPane.add(btn9);

        JButton btndiv=new JButton("/");
        btndiv.addActionListener(this);
        contentPane.add(btndiv);

        JButton btn4=new JButton("4");
        btn4.addActionListener(this);
        contentPane.add(btn4);

        JButton btn5=new JButton("5");
        btn5.addActionListener(this);
        contentPane.add(btn5);

        JButton btn6=new JButton("6");
        btn6.addActionListener(this);
        contentPane.add(btn6);

        JButton btnmul=new JButton("x");
        btnmul.addActionListener(this);
        contentPane.add(btnmul);

        JButton btn1=new JButton("1");
        btn1.addActionListener(this);
        contentPane.add(btn1);

        JButton btn2=new JButton("2");
        btn2.addActionListener(this);
        contentPane.add(btn2);

        JButton btn3=new JButton("3");
        btn3.addActionListener(this);
        contentPane.add(btn3);
   
        JButton btnsub=new JButton("-");
        btnsub.addActionListener(this);
        contentPane.add(btnsub);
        
        space3 = new JLabel(" ");
        contentPane.add(space3);
       
        JButton btn0=new JButton("0");
        btn0.addActionListener(this);
        contentPane.add(btn0);

        JButton btneql=new JButton("=");
        btneql.addActionListener(this);
        contentPane.add(btneql);

        JButton btnadd=new JButton("+");
        btnadd.addActionListener(this);
        contentPane.add(btnadd);

        upPane.add(contentPane, BorderLayout.CENTER);
        //c按鍵的功能
        c.addActionListener(e->{
            operator=num1=num2="";   //將集合中的資料清零
			contentResult.setText("0");//預設為0
           
		});
        
        
        setVisible(true);//看的到視窗
    }

    public void actionPerformed(ActionEvent e){
        String symbol = e.getActionCommand();

        //讀取輸入的值
         if(symbol.charAt(0)>= '0'&& symbol.charAt(0)<= '9'){//Ascii值
            //如果輸入為數字時
   
            if (!operator.equals("")){//如果有輸入運算符號
                num2 = num2+symbol;
            }else{//如果沒有輸入運算符號
                num1 = num1+symbol;
            }
            contentResult.setText(num1+operator+num2);
           
            
        }else if (symbol.equals("=")){ //如果輸入為=時
            int result = 0;
            switch(operator){

            case "+":
                result = Integer.valueOf(num1)+Integer.valueOf(num2);
                break;

            case"-":
                result = Integer.valueOf(num1)-Integer.valueOf(num2);
                break;

            case"x":
                result = Integer.valueOf(num1)*Integer.valueOf(num2);
                break;

            case"/":
                result = Integer.valueOf(num1)/Integer.valueOf(num2);
                break;
        
            }
            contentResult.setText(num1+operator+num2+"="+result);

            operator = num2 = "";
            num1 = Integer.toString(result);

           
        }else{
            
            if(operator.equals("")){
                operator = symbol;

            }else if(num2.equals("")){
                contentResult.setText(operator);   
                
            }
            else{
                int result = 0;

                switch(operator){

                    case "+":
                        result = Integer.valueOf(num1)+Integer.valueOf(num2);
                        break;

                    case"-":
                        result = Integer.valueOf(num1)-Integer.valueOf(num2);
                        break;

                    case"x":
                        result = Integer.valueOf(num1)*Integer.valueOf(num2);
                        break;

                    case"/":
                        result = Integer.valueOf(num1)/Integer.valueOf(num2);
                        break;
                
                    }

                num1 = Integer.toString(result);
                operator = symbol;
                num2 = "";
            }
            
            contentResult.setText(num1+operator+num2);

        }

    }
}

public class week5_hw_calculator{
    public static void main(String[] args) throws Exception{
        MyJFrame f1=new MyJFrame();


    }

}
