/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cmpe313_project;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;





/**
 *
 * @author DJOUKAN STEVEN
 */
public class Search_form extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    
    
    public Search_form(){
        setSize(700, 200);
        setTitle("Search Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        
        l1 = new JLabel(" Brand ");
        l1.setFont(new Font("Verdana", Font.BOLD, 12));
        l1.setBounds(25, 5, 300, 20);
        l2 = new JLabel(" GearBox ");
        l2.setFont(new Font("Verdana", Font.BOLD, 12));
        l2.setBounds(130, 5, 300, 20);
        l3 = new JLabel(" Model ");
        l3.setFont(new Font("Verdana", Font.BOLD, 12));
        l3.setBounds(250, 5, 300, 20);
        l4 = new JLabel(" Year ");
        l4.setFont(new Font("Verdana", Font.BOLD, 12));
        l4.setBounds(350, 5, 300, 20);
        l5 = new JLabel(" MaxSpeed ");
        l5.setFont(new Font("Verdana", Font.BOLD, 12));
        l5.setBounds(430, 5, 300, 20);
        l6 = new JLabel(" Color ");
        l6.setFont(new Font("Verdana", Font.BOLD, 12));
        l6.setBounds(570, 5, 300, 20);
        
        t1 = new JTextField(10);
        t1.setFont(new Font("Verdana", Font.BOLD, 12));
        t1.setBounds(5, 40, 100, 30);
        t2 = new JTextField(10);
        t2.setFont(new Font("Verdana", Font.BOLD, 12));
        t2.setBounds(110, 40, 100, 30);
        t3 = new JTextField(10);
        t3.setFont(new Font("Verdana", Font.BOLD, 12));
        t3.setBounds(215, 40, 100, 30);
        t4 = new JTextField(10);
        t4.setFont(new Font("Verdana", Font.BOLD, 12));
        t4.setBounds(320, 40, 100, 30);
        t5 = new JTextField(10);
        t5.setFont(new Font("Verdana", Font.BOLD, 12));
        t5.setBounds(425, 40, 100, 30);
        t6 = new JTextField(10);
        t6.setFont(new Font("Verdana", Font.BOLD, 12));
        t6.setBounds(530, 40, 100, 30);
        
        b1 = new JButton("Find the Fastest Car");
        b1.setFont(new Font("Verdana", Font.BOLD, 16));
        b1.setBounds(5, 80, 520, 25);
        b2 = new JButton("Clear");
        b2.setFont(new Font("Verdana", Font.BOLD, 16));
        b2.setBounds(530, 80, 100, 25);
        
        add(l1); add(l2); add(l3); add(l4); add(l5); add(l6);
        add(t1); add(t2); add(t3); add(t4); add(t5); add(t6);
        add(b1); add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent e){
        if (e.getSource()== b1){
            try {
            FileReader fr= new FileReader("carinventory.txt");
            BufferedReader readcar = new BufferedReader(fr);
            
           Double max = 0;
           String values = readcar.readLine();     
           while ((values = readcar.readLine()) != null) {
                StringTokenizer stn = new StringTokenizer(values); // to a build-in function to traverse each line in the file and check word by word
                String brand = stn.nextToken();
                String gearbox = stn.nextToken();
                String model = stn.nextToken();
                int year = Integer.parseInt(stn.nextToken());
                int maxspeed = Integer.parseInt(stn.nextToken());
                String color = stn.nextToken();
                
                if (max < maxspeed){
                    max = maxspeed;
                    
                    t1.setText(brand);
                    t2.setText(gearbox);
                    t3.setText(model);
                    t4.setText(String.valueOf(year));//tis is to convert int to String....
                    t5.setText(String.valueOf(maxspeed));
                    t6.setText(color);
                    
                }
               
              //JOptionPane.showMessageDialog(null, values);
        
           }
          
           
           readcar.close();
         } catch (IOException n){
         
         } 
         
           

            }
        
        
        
        if (e.getSource()== b2){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        }
        
        //dispose();
    }
    
}
