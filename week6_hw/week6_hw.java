import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//事件監聽
import java.io.IOException;
import java.util.ArrayList;


class MyJFrame extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JPanel jPane;
    private String[][] Lists = new String[3][2];
    private int count=0;

    MyJFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//視窗只要按叉就會整個關掉(不會在背後繼續執行)
        setTitle("Pictures!!!");//視窗標題
        setBounds(100, 100, 400, 300);//視窗大小
        

        contentPane=new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        jPane = new JPanel();
        jPane.setLayout(new GridLayout(1, 2));

        Lists[0][0] ="cat1";
        Lists[0][1] ="C:\\Users\\user\\Desktop\\oop2\\hw\\week6_hw\\a.jpg";
        Lists[1][0] ="cat2";
        Lists[1][1]= "C:\\Users\\user\\Desktop\\oop2\\hw\\week6_hw\\b.jpg";
        Lists[2][0] ="cat3";
        Lists[2][1] ="C:\\Users\\user\\Desktop\\oop2\\hw\\week6_hw\\c.jpg";

        //圖片
        JLabel pic=new JLabel(new ImageIcon(Lists[0][1]));
        contentPane.add(pic,BorderLayout.CENTER);

        //文字
        JLabel name=new JLabel("cat1",JLabel.CENTER);
        contentPane.add(name,BorderLayout.NORTH);


        JButton btn1=new JButton("上一張");
        btn1.setBackground(Color.pink);
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                --count;
                if(count>=0){
                    ImageIcon img1 = new ImageIcon(Lists[count][1]);
                    pic.setIcon(img1);
                    name.setText(Lists[count][0]);
                }else{
                    JOptionPane.showMessageDialog(null,"沒有圖了","訊息",JOptionPane.WARNING_MESSAGE);
                } 
            }
        });
        jPane.add(btn1);

        JButton btn2=new JButton("下一張");
        btn2.setBackground(Color.pink);
        btn2.addActionListener(new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                ++count;
                if(count<=2){
                    ImageIcon img1 = new ImageIcon(Lists[count][1]);
                    pic.setIcon(img1);
                    name.setText(Lists[count][0]);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"沒有圖了","訊息",JOptionPane.WARNING_MESSAGE);
                } 
  
                
            }
        });
        jPane.add(btn2);

        contentPane.add(jPane, BorderLayout.SOUTH);

        setVisible(true);//看的到視窗//把此行放到最後就可以直接顯示
    }

}
public class week6_hw{
    public static void main(String[] args) throws Exception{
        MyJFrame f1=new MyJFrame();


    }

}