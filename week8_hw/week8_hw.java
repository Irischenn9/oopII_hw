import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

class MyJFrame extends JFrame{ 
  
    private JScrollPane jsp=new  JScrollPane();
   
    private JPanel jp1=new  JPanel();
    private JTextArea jta=new  JTextArea();


    MyJFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Taiwan Popular Thing");
        setBounds(50,50,250,300);
        setLayout(null);//這行必加才會顯示正確位置的JPanel


        //JList清單(可複選)
        String[] city={"台北","台中","嘉義","台南","高雄","屏東"};
        JList<String>jl1=new JList<>(city);
        add(jl1);

        jl1.setVisibleRowCount(4);
        jl1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jl1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    List<String> str = jl1.getSelectedValuesList();
                    String pop="";
                    for (int i = 0; i < str.size(); i++) {
                   
                    if(str.get(i).equals("台北")){
                        pop+="台北有名的的景點是101"+"\n";
                    }if(str.get(i).equals("台中")){
                        pop+="台中的名產是太陽餅"+"\n";
                    }if(str.get(i).equals("嘉義")){
                        pop+="嘉義的名產是雞肉飯"+"\n";
                    }if(str.get(i).equals("台南")){
                        pop+="台南的名產是牛肉湯"+"\n";
                    }if(str.get(i).equals("高雄")){
                        pop+="高雄有名的的景點是西子灣"+"\n";
                    }if(str.get(i).equals("屏東")){
                        pop+="屏東的名產是肉粿"+"\n";
                    }
                } jta.setText(pop);
            }

        }

    });
       

       //捲軸面板
       jsp=new JScrollPane(jl1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jsp.setBounds(20,20,50,100);
       add(jsp);


        jta=new JTextArea();//多行文字欄位
       add(jta);
       jta.setBounds(20,150,170,100);

        setVisible(true);

    };
    
    
}

public class week8_hw{
    public static void main(String[] args){
        MyJFrame f1=new MyJFrame();
    }
}