//GROUP FIVE 
//GUI CODE CONNECTING TO THE DATABASE


//CREATING AN ACCOUNT INTERFACE
package pkggroupfive;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashSet;
import javax.swing.*;

public class CreateAccount extends JFrame implements ActionListener{
   
    String url,name,password;
    String driver;
    Statement st;
    Connection con;
    
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,mainpan;
    JButton btn1,btn2,btn3,btn4,btn5;
    JTextField txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    JPasswordField pass;
    
    CreateAccount(){
        
//        initializing objects 
con=null;
url="jdbc:mysql://localhost:3306/interneship?useSSL=false";
name="root";
password="";
st=null;

       
        p1=new JPanel();
        l1=new JLabel("CREATE AN ACCOUNT");
         p1.add(l1);
        l1.setForeground(Color.RED);
        p1.setBackground(Color.BLUE);
      
        
        p2=new JPanel();
        l2=new JLabel("FIRST NAME");
        txt1=new JTextField(12);
        p2.add(l2);
        p2.add(txt1);
        p2.setBackground(Color.BLUE);
        l2.setForeground(Color.yellow);
       
        p3=new JPanel();
        l3=new JLabel("SECOND NAME");
        txt2=new JTextField(12);
        p3.add(l3);
        p3.add(txt2);
        p3.setBackground(Color.BLUE);
        l3. setForeground(Color.yellow); 
              
        p4=new JPanel();
        l4=new JLabel("GENDER");
        txt3=new JTextField(4);
        p4.add(l4);
        p4.add(txt3);
        p4.setBackground(Color.BLUE);
        l4.setForeground(Color.yellow);
      
        p5=new JPanel();
        l5=new JLabel("DATE OF BIRTH");
        txt4=new JTextField(4);
        p4.add(l5);
        p4.add(txt4);
        p5.setBackground(Color.BLUE);
        l5.setForeground(Color.yellow);
        
        p6=new JPanel();
        l6=new JLabel("PASSWORD");
        pass=new JPasswordField(12);
        p6.add(l6);
        p6.add(pass);
        p6.setBackground(Color.BLUE);
        l6.setForeground(Color.yellow);
        
        
        p7=new JPanel();
        l7=new JLabel("COUNTRY");
        txt5=new JTextField(12);
        p7.add(l7);
        p7.add(txt5);
        p7.setBackground(Color.BLUE);
        l7.setForeground(Color.yellow);
        
        p11=new JPanel();
        l9=new JLabel("PHONE NUMBER");
        txt6=new JTextField(12);
        p11.add(l9);
        p11.add(txt6);
        p11.setBackground(Color.BLUE);
        l9.setForeground(Color.yellow);
        
        p12=new JPanel();
        l10=new JLabel("EMAIL ADDRESS");
        txt7=new JTextField(12);
        p12.add(l10);
        p12.add(txt7);
        p12.setBackground(Color.BLUE);
        l10.setForeground(Color.yellow);
        
        
        
       p8=new JPanel();
       btn1=new JButton("CREATE");
       btn2=new JButton("CLEAR");
       btn3=new JButton("EXIT");
       p8.add(btn1);
       p8.add(btn2);
       p8.add(btn3);
       p8.setBackground(Color.BLUE);
       btn1.setForeground(Color.green);
       btn2.setForeground(Color.green);
       btn3.setForeground(Color.green);
     
       p9=new JPanel();
       l8=new JLabel("THANKS FOR USING THIS APPLICATION");
       p9.add(l8);
       l8.setForeground(Color.red);
       p9.setBackground(Color.yellow);
       
       p10=new JPanel();
       btn4=new JButton("SIGN IN");
       p10.add(btn4);
       
       p13=new JPanel();
       btn5=new JButton("LOGIN ANYWAY");
       p13.add(btn5);
       
       
       
       mainpan=new JPanel();
       p5.setLayout(new BoxLayout(p5,BoxLayout.Y_AXIS));
       mainpan.add(p1);
       mainpan.add(p2);
       mainpan.add(p3);
       mainpan.add(p6);
       mainpan.add(p7);
       mainpan.add(p11);
       mainpan.add(p12);
       mainpan.add(p4);
       mainpan.add(p5);
       mainpan.add(p8);
       mainpan.add(p10);
       mainpan.add(p13);
       mainpan.add(p9);
       mainpan.setBackground(Color.BLUE);
       
       getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
       getContentPane().add(mainpan);
        
       btn1.addActionListener(this);
       btn2.addActionListener(this);
       btn3.addActionListener(this);  
       btn4.addActionListener(this);
       btn5.addActionListener(this);
    }
    
    public static void main(String[] args){
        
         CreateAccount account=new  CreateAccount();
         account.setSize(320,460);
         account.setVisible(true);
         account.setTitle("INTERNESHIP");
         account.setLocationRelativeTo(null);
        // account.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
      String call=e.getActionCommand();
      
      if(call.equals(btn1.getText())){
          
         if (txt1.getText().isEmpty() ||txt2.getText().isEmpty()||txt3.getText().isEmpty()||txt4.getText().isEmpty()||txt5.getText().isEmpty()||txt6.getText().isEmpty()||pass.getText().isEmpty())
             {
                 JOptionPane.showMessageDialog(null,"Please enter all fields");
                 //System.out.println(btn1.getText());
             }
         else
     try{
             Class.forName("com.mysql.jdbc.Driver");
              JOptionPane.showMessageDialog(null, "Driver registered succesfully");
              con=DriverManager.getConnection(url, name, password);
             // con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitbank?useSSL=false", name, password);
             
            
             
              st=con.createStatement();
              String q="INSERT into data(FirstName,SecondName,password,Country,PhoneNumber,EmailAddress,Gender,DateOfBirth)values"
                      + "('"+txt1.getText()+"','"+txt2.getText()+"','"+pass.getText().toString()+"','"+txt5.getText()
                      +"','"+txt6.getText().toString()+"','"+txt7.getText()+"','"+txt3.getText()+"','"+txt4.getText()+"')";
              st.executeUpdate(q);
              JOptionPane.showMessageDialog(null,"Data addeed successfully to the database");
              txt1.setText("");
              pass.setText("");
              txt2.setText("");                 
              txt3.setText("");
              txt4.setText("");
              txt5.setText("");                 
              txt6.setText("");
              txt7.setText("");
         }
         catch(Exception k){
         JOptionPane.showMessageDialog(null, k);
         }
      }
      
      
      
      else if(call.equals("SIGN IN")){
          
     JOptionPane.showMessageDialog(null,"YOU WILL BE UN ABLE TO LOGIN IF YOU DON'T HAVE AN ACCOUNT");
     
         this.dispose();
      UserLogin log=new UserLogin();
      log.setSize(320,340);
      log.setTitle("INTERNESHIP");
      log.setVisible(true);
     log.setLocationRelativeTo(null);
     log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     
      }
      
      else if(call.equals(btn2.getText())){
     
              txt1.setText("");
              pass.setText("");
              txt2.setText("");
              txt3.setText("");
              txt4.setText("");
              txt5.setText("");
              txt6.setText("");
              txt7.setText("");
              txt1.requestFocus();
          
          JOptionPane.showMessageDialog(null,"Entries cleared successfull","Reset Detail",JOptionPane.INFORMATION_MESSAGE);
      }
      
      else if(call.equals(btn3.getText())){
     System.exit(0);
        }  
      else if(call.equals(btn5.getText())){
          this.dispose();
          Choose s=new Choose();
        s.setSize(300,450);
        s.setVisible(true);
        s.setResizable(false);
        s.setLocationRelativeTo(null);
        s.setBackground(Color.BLUE);
        s.setTitle("COMPANIES");
      }
     }
     
   }

//LOGIN INTERFACE
package pkggroupfive;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashSet;

public class UserLogin extends JFrame implements ActionListener{

String url,name,password;
    String driver;
    PreparedStatement st;
    Connection con;
    
    JPanel p1,p2,p3,p4,p5,mainpan;
    JLabel l1,l2,l3,l4;
    JTextField txt1;
    JPasswordField txt2;
    JButton btn1,btn2,btn3;
    
   public  UserLogin(){
       
 con=null;
url="jdbc:mysql://localhost:3306/interneship?useSSL=false";
name="root";
password="";
PreparedStatement ps=null;

       
       p1=new JPanel();
       l1=new JLabel("USER INTERFACE");
       p1.add(l1);
       l1.setForeground(Color.red);
       p1.setBackground(Color.BLUE);
       
       p2=new JPanel();
       p2.setBackground(Color.YELLOW);
       l2=new JLabel("Email/PhoneNo");
       l2.setForeground(Color.red);
       txt1=new JTextField(15);
       p2.add(l2);
       p2.add(txt1);
       
       p3=new JPanel();
       p3.setBackground(Color.red);
       l3=new JLabel("PassWord");
       l3.setForeground(Color.YELLOW);
       txt2=new JPasswordField(15);
       p3.add(l3);
       p3.add(txt2);
       
       p4=new JPanel();
       p4.setBackground(Color.black);
       btn1=new JButton("Login");
       btn1.setForeground(Color.PINK);
       btn2=new JButton("Clear");
       btn2.setForeground(Color.green);
       btn3=new JButton("Exit");
        btn3.setForeground(Color.gray);
       p4.add(btn1);
       p4.add(btn2);
       p4.add(btn3);
       
       p5=new JPanel();
       l4=new JLabel("USER ACCOUNT");
       p5.add(l4);
       p5.setBackground(Color.blue);
       l4.setForeground(Color.red);
       
       
       mainpan=new JPanel(); 
       mainpan.setLayout(new BoxLayout(mainpan,BoxLayout.Y_AXIS));
       mainpan.add(p1);
       mainpan.add(p2);
       mainpan.add(p3);
       mainpan.add(p4);
       mainpan.add(p5);
       
       getContentPane().set Layout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
       getContentPane().add(mainpan);
       
       btn1.addActionListener(this);
       btn2.addActionListener(this);
       btn3.addActionListener(this);
       
      
   }

    public static void main(String[] args) {
       UserLogin log=new UserLogin();
      /* log.setSize(320,300);
       log.setTitle("MOZART DEVELOPER");
       log.setVisible(true);
       log.setLocationRelativeTo(null);
       log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);*/
    }

    @Override
   public void actionPerformed(ActionEvent e){
      String press=e.getActionCommand();
      String name=txt1.getText();
      String regno=txt2.getText();
      
      
      if(press.equals(btn1.getText())){
      if (txt1.getText().isEmpty() || txt2.getText().isEmpty())
      {
         
               JOptionPane.showMessageDialog(null,"Please Enter Email/PhoneNo and password");
      }
      
     else 
       try{
           Class.forName("com.mysql.jdbc.Driver");
     java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interneship?zeroDateTimeBehavior=convertToNull","root","");
    //  String sql1="select concat (FirstName, SecondName) AS fullname";
       String sql="select * from data where FirstName='"+txt1.getText()+"' OR PhoneNumber='"
                    +txt1.getText()+"'OR EmailAddress='"+txt1.getText()+"' AND password='"+txt2.getText()+"'";
      PreparedStatement ps=con.prepareStatement(sql);
      ResultSet rs=ps.executeQuery(sql);
  
             if(rs.next()){
             JOptionPane.showMessageDialog(null,"LOGED IN SUCCESSFULY");
       
                     this.dispose();
                     
       Choose s=new Choose();
        s.setSize(400,420);
        s.setVisible(true);
        s.setResizable(false);
        s.setLocationRelativeTo(null);

             }
      
      else{
      
           JOptionPane.showMessageDialog(null,"INVALID"); 
      }
       }
       catch(Exception m){System.out.println(m);
       }
     }
     else if(press.equals(btn2.getText())){
           txt1.setText("");
           txt2.setText("");
           txt1.requestFocus();
           JOptionPane.showMessageDialog(null,"Fields Empty","Reset InPUT",JOptionPane.INFORMATION_MESSAGE);
           
    }
      else if(press.equals(btn3.getText())){
           System.exit(0);
           
       
       }
      
      
   }
}

           
       //CHOOSING INTERFACE
package pkggroupfive;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Choose extends JFrame implements ActionListener {
    
    JLabel lab1,l2,l3,l4;
    JPanel p1,p2,p3,p4,p5,endpan;
    JButton btn1,btn2,btn3,btn4;
    
     Choose(){
      
       p1=new JPanel();
      lab1=new JLabel("GOVERMENT COMPANIES"); 
      btn1=new JButton("1");
       p1.add(lab1);
       p1.add(btn1);
       lab1.setForeground(Color.red);
       p1.setForeground(Color.BLUE);
       
       
      p2=new JPanel();
      l3=new JLabel("PRIVATE COMPANIES"); 
      btn2=new JButton("2");
      p2.add(l3);
      p2.add(btn2);
      l3.setForeground(Color.red);
      p2.setForeground(Color.BLUE);
   
      
      p3=new JPanel();
      p3.setBackground(Color.BLACK);
      l4=new JLabel("CHOOSE EITHER GOVERNMENT OR PRIVATE");
      l4.setForeground(Color.ORANGE);
      p3.add(l4);
      l4.setForeground(Color.yellow);
      p3.setForeground(Color.BLUE);
    
      p4=new JPanel();
      btn3=new JButton("EXIT");
      btn4=new JButton("BACK");
      p4.add(btn3);
      p4.add(btn4);
      p4.setForeground(Color.BLUE);
     
      
      
      endpan=new JPanel();
      
     endpan.setLayout(new BoxLayout(endpan,BoxLayout.Y_AXIS));
      endpan.add(p3);
      endpan.add(p1);
      endpan.add(p2);
      endpan.add(p4);
       endpan.setBackground(Color.BLUE);
    
      
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      btn3.addActionListener(this);
      btn4.addActionListener(this);
      
      getContentPane().setLayout(new BoxLayout( getContentPane(),BoxLayout.Y_AXIS));
      getContentPane().add(endpan);
      
     }
    public static void main(String[] args){
       
          Choose s=new Choose();
           s.setSize(620,600);
           s.setVisible(true);
           s.setResizable(false);
           s.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String click=e.getActionCommand();
        
        if(click.equals(btn1.getText())){
         
         JOptionPane.showMessageDialog(null,"GOVERNMENT SELECTION","THANKS",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Government govt=new Government();
           govt.setSize(320,750);
           govt.setVisible(true);
           govt.setResizable(false);
           govt.setLocationRelativeTo(null);
           govt.setTitle("GOVERNMENT");
        
        
        }
        else if(click.equals(btn2.getText())){
         
         JOptionPane.showMessageDialog(null,"PRIVATE SELECTION","THANKS",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
         Private p=new Private();
           p.setSize(200,550);
           p.setVisible(true);
           p.setResizable(false);
           p.setLocationRelativeTo(null);
           p.setTitle("PRIVATE");
        } 
        else if(click.equals(btn3.getText())){
                 System.exit(0);
             } 
          
          else if(click.equals(btn4.getText())){
                  this.dispose();
                   UserLogin log=new UserLogin();
                    log.setSize(320,310);
                    log.setTitle("INTERNESHIP");
                    log.setVisible(true);
                    log.setLocationRelativeTo(null);
                    log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     
                }  
        }
        
    }
    

    //GOVERNMENT INTERFACE
package pkggroupfive;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Government extends JFrame implements ActionListener {
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27; 
JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,mainpan;
JButton btn1;
    
    
     Government (){
         
         
         p1=new JPanel();
         l1=new JLabel("GOVERNMENT COMPANIES");  
         p1.add(l1);
         p1.setBackground(Color.BLUE);
         l1.setForeground(Color.YELLOW);
         p2=new JPanel();
         l2=new JLabel("1:>>UGANDA REVENUE AUTHORITY(URA)<<:");
         p2.add(l2);
         p2.setBackground(Color.YELLOW);
         l2.setForeground(Color.BLUE);
         p3=new JPanel();
         l3=new JLabel("KAMPALA NAKAWA");
         p3.add(l3);   
         p3.setBackground(Color.YELLOW);
         l3.setForeground(Color.red);
         p4=new JPanel();
         l4=new JLabel("PLOT M193/4");
         p4.add(l4);
         p4.setBackground(Color.YELLOW);
         l4.setForeground(Color.red);
         p5=new JPanel();
         l5=new JLabel("KINAWATAKA ROAD");
         p5.add(l5);
         p5.setBackground(Color.YELLOW);
         l5.setForeground(Color.red);
         p6=new JPanel();
         l6=new JLabel("2:>>UGANDA NATIONAL ROADS AUTHORITY(UNRA)<<:");
         p6.add(l6);
         p6.setBackground(Color.YELLOW);
         l6.setForeground(Color.BLUE);
         p7=new JPanel();
         l7=new JLabel("PLOT 345,NEW PORTBELL ROAD");
         p7.add(l7);   
         p7.setBackground(Color.YELLOW);
         l7.setForeground(Color.red);   
         p8=new JPanel();
         l8=new JLabel("UAP NAKAWA BUSINESS PARK");
         p8.add(l8);   
         p8.setBackground(Color.YELLOW);
         l8.setForeground(Color.red);
         p9=new JPanel();
         l9=new JLabel("P.O.BOX 28487");
         p9.add(l9);
         p9.setBackground(Color.YELLOW);
         l9.setForeground(Color.red);
         p10=new JPanel();
         l10=new JLabel("PhoneNo:+256414318111,");
         p10.add(l10);
         p10.setBackground(Color.YELLOW);
         l10.setForeground(Color.red);
         p11=new JPanel();
         l11=new JLabel("Email:info@unra.go.ug");
         p11.add(l11);
         p11.setBackground(Color.YELLOW);
         l11.setForeground(Color.red);
         p12=new JPanel();
         l2=new JLabel("3:>>CIVIL AVIATION AUTHORITY<<:");
         p12.add(l2);
         p12.setBackground(Color.YELLOW);
         l2.setForeground(Color.BLUE);
         p13=new JPanel();
         l13=new JLabel("ENTEBBE INTERNATIONAL AIRPORT");
         p13.add(l13);
         p13.setBackground(Color.YELLOW);
         l13.setForeground(Color.red);
         p14=new JPanel();
         l14=new JLabel("P.O.BOX 55636 KAMPALA");
         p14.add(l14); 
         p14.setBackground(Color.YELLOW);
         l14.setForeground(Color.red);
         p15=new JPanel();
         l15=new JLabel("+256312352000");
         p15.add(l15);
         p15.setBackground(Color.YELLOW);
         l15.setForeground(Color.red);
         p16=new JPanel();
         l16=new JLabel("Email:aviation@caa.co.ug");
         p16.add(l16);
         p16.setBackground(Color.YELLOW);
         l16.setForeground(Color.red);
         p17=new JPanel();
         l17=new JLabel("4:>>JOINT CLINICAL RESEACH CENTRE<<:");
         p17.add(l17);
         p17.setBackground(Color.YELLOW);
         l17.setForeground(Color.BLUE);
         p18=new JPanel();
         l18=new JLabel("LUBOWA HILL,PLOT 101 ENTEBBE ROAD");
         p18.add(l18); 
         p18.setBackground(Color.YELLOW);
         l18.setForeground(Color.red);
         p19=new JPanel();
         l19=new JLabel("P.O.BOX 10005");
         p19.add(l19); 
         p19.setBackground(Color.YELLOW);
         l19.setForeground(Color.red);
         p20=new JPanel();
         l20=new JLabel("WAKISO UGANDA");
         p20.add(l20);
         p20.setBackground(Color.YELLOW);
         l20.setForeground(Color.red);
         p21=new JPanel();
         l21=new JLabel("PhoneNO:+256414201148");
         p21.add(l21);
         p21.setBackground(Color.YELLOW);
         l21.setForeground(Color.red);
         p22=new JPanel();
         l22=new JLabel("5:>>KAMPALA CITY CAUNCIL AUTHORITY<<:");
         p22.add(l22);   
         p22.setBackground(Color.YELLOW);
         l22.setForeground(Color.BLUE);
         p23=new JPanel();
         l23=new JLabel("CITY HALL ");
         p23.add(l23);
         p23.setBackground(Color.YELLOW);
         l23.setForeground(Color.red);
         p24=new JPanel();
         l24=new JLabel("PLOT 123 APOLLO KAGGWA ROAD");
         p24.add(l24);
         p24.setBackground(Color.YELLOW);
         l24.setForeground(Color.red);
         p25=new JPanel();
         l25=new JLabel("P.O.BOX 7010 KAMPALA");
         p25.add(l25);
         p25.setBackground(Color.YELLOW);
         l25.setForeground(Color.red);
         p26=new JPanel();
         l26=new JLabel("Email:info@kcca.go.ug");
         p26.add(l26);
         p26.setBackground(Color.YELLOW);
         l26.setForeground(Color.red);
         p27=new JPanel();
         l27=new JLabel("PhoneNo:0800990000");
         p27.add(l27);
         p27.setBackground(Color.YELLOW);
         l27.setForeground(Color.red);
         
         mainpan=new JPanel();
    
        // mainpan.setLayout(new BoxLayout(mainpan,BoxLayout.Y_AXIS));
       
         mainpan.add(p1);
         mainpan.add(p2);
         mainpan.add(p3);
         mainpan.add(p4);
         mainpan.add(p5);
         mainpan.add(p6);
         mainpan.add(p7);
         mainpan.add(p8);
         mainpan.add(p9);
         mainpan.add(p10);
         mainpan.add(p11);
         mainpan.add(p12);
         mainpan.add(p13);
         mainpan.add(p14);
         mainpan.add(p15);
         mainpan.add(p16);
         mainpan.add(p17);
         mainpan.add(p18);
         mainpan.add(p19);
         mainpan.add(p20);
         mainpan.add(p21);
         mainpan.add(p22);
         mainpan.add(p23);
         mainpan.add(p24);
         mainpan.add(p25);
         mainpan.add(p26);
         mainpan.add(p27);
         mainpan.setBackground(Color.YELLOW);
         
         getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
         getContentPane().add(mainpan);
         
     }
    
    
    public static void main(String[] args){
        
        Government govt=new Government();
       
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        
    }

   
}


//PRIVATE INTERFACE
package pkggroupfive;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Private extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21; 
    JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,mainpan;
    JButton btn1;
    
    
    Private(){
        
        
        
         p1=new JPanel();
         l1=new JLabel("PRIVATE COMPANIES");
         p1.add(l1);
         p1.setForeground(Color.blue);
         l1.setForeground(Color.GREEN);
         p2=new JPanel();
         l2=new JLabel("1:>>MOVIT PRODUCTS LIMITED<<:");
         p2.add(l2);  
         p2.setBackground(Color.BLUE);
         l2.setForeground(Color.red);
         p3=new JPanel();
         l3=new JLabel("PLOT 4454.OFF ENTEBBE ROAD ");
         p3.add(l3);
         p3.setBackground(Color.BLUE);
         l3.setForeground(Color.GREEN);
         p4=new JPanel();
         l4=new JLabel("PhoneNo:0800203011");
         p4.add(l4);
         p4.setBackground(Color.BLUE);
         l4.setForeground(Color.GREEN);
         p5=new JPanel();
         l5=new JLabel("Email:sales@movit.co.ug");
         p5.add(l5);
         p5.setBackground(Color.BLUE);
         l5.setForeground(Color.GREEN);
         p6=new JPanel();
         l6=new JLabel("KAMPALA UGANDA");
         p6.add(l6);
         p6.setBackground(Color.BLUE);
         l6.setForeground(Color.GREEN);
         p7=new JPanel();
         l7=new JLabel("2:>>STODACOM<<:");
         p7.add(l7); 
         p7.setBackground(Color.BLUE);
         l7.setForeground(Color.red);
         p8=new JPanel();
         l8=new JLabel("PhoneNo:+256393208289");
         p8.add(l8); 
         p8.setBackground(Color.BLUE);
         l8.setForeground(Color.GREEN);
         p9=new JPanel();
         l9=new JLabel("Email:info@stodacom.com");
         p9.add(l9);
         p9.setBackground(Color.BLUE);
         l9.setForeground(Color.GREEN);
         p10=new JPanel();
         l10=new JLabel("AMBER HOUSE");
         p10.add(l5);
         p10.setBackground(Color.BLUE);
         l10.setForeground(Color.GREEN);
         p11=new JPanel();
         l11=new JLabel("Email:www.stodacom.com");
         p11.add(l11);
         p11.setBackground(Color.BLUE);
         l11.setForeground(Color.GREEN);
         p12=new JPanel();
         l2=new JLabel("3:>>MTI<<:");
         p12.add(l2);
         p12.setBackground(Color.BLUE);
         l2.setForeground(Color.red);
         p13=new JPanel();
         l13=new JLabel("8JQ5+6Q KAMPALA");
         p13.add(l13); 
         p13.setBackground(Color.BLUE);
         l13.setForeground(Color.GREEN);
         p14=new JPanel();
         l14=new JLabel("PhoneNo:08009594325");
         p14.add(l14); 
         p14.setBackground(Color.BLUE);
         l14.setForeground(Color.GREEN);
         p15=new JPanel();
         l15=new JLabel("+256312352000");
         p15.add(l15);
         p15.setBackground(Color.BLUE);
         l15.setForeground(Color.GREEN);
         p16=new JPanel();
         l16=new JLabel("Email:info@medicalteams.org");
         p16.add(l16);
         p16.setBackground(Color.BLUE);
         l16.setForeground(Color.GREEN);
         
         
         
         mainpan=new JPanel();
    
        // mainpan.setLayout(new BoxLayout(mainpan,BoxLayout.Y_AXIS));
       
         mainpan.add(p1);
         mainpan.add(p2);
         mainpan.add(p3);
         mainpan.add(p4);
         mainpan.add(p5);
         mainpan.add(p6);
         mainpan.add(p7);
         mainpan.add(p8);
         mainpan.add(p9);
         mainpan.add(p10);
         mainpan.add(p11);
         mainpan.add(p12);
         mainpan.add(p13);
         mainpan.add(p14);
         mainpan.add(p15);
         mainpan.add(p16);
         mainpan.setBackground(Color.BLUE);
        
         getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
         getContentPane().add(mainpan);
    }
    
    public static void main(String[] args){

        Private p=new Private();
       
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        
    }

   
    
    
}




//END OF THE CODE
//THANKS



       
    
