package cmpe313_project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author STLab_4G
 */
public class Inventory extends JFrame implements ActionListener {
    private JLabel l1, l2, l3, l4, l5, l6, l7;
    private JButton b1, b2;
    private JComboBox c1;
    private JRadioButton r1, r2;
    private JTextField t1, t2, t3, t4;
    ButtonGroup gr1;

    public Inventory() {
        setTitle("CAR INFO");
        setSize(400, 350);
        setLayout(null); // use setbound for the components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Choose the Brand: ");
        l1.setFont(new Font("Verdana", Font.BOLD, 12));
        l1.setBounds(20, 48, 300, 20);
        l2 = new JLabel("Choose the GearBox: ");
        l2.setFont(new Font("Verdana", Font.BOLD, 12));
        l2.setBounds(20, 80, 300, 20);

        l3 = new JLabel("Enter the Model: ");
        l3.setFont(new Font("Verdana", Font.BOLD, 12));
        l3.setBounds(20, 105, 300, 20);// 20=distance from the origin, 105= height from the top, 300=width, 20=size of
                                       // the word
        l4 = new JLabel("Enter the Year: ");
        l4.setFont(new Font("Verdana", Font.BOLD, 12));
        l4.setBounds(20, 130, 300, 20);

        l5 = new JLabel("Enter the MaxSpeed: ");
        l5.setFont(new Font("Verdana", Font.BOLD, 12));
        l5.setBounds(20, 160, 300, 20);

        l6 = new JLabel("Enter the Color: ");
        l6.setFont(new Font("Verdana", Font.BOLD, 12));
        l6.setBounds(20, 190, 300, 20);

        l7 = new JLabel("Enter the Car's Information");// make this bold
        l7.setBounds(70, 10, 300, 20);
        l7.setFont(new Font("Verdana", Font.BOLD, 15));
        l7.setForeground(Color.orange);

        c1 = new JComboBox();
        c1.setBounds(165, 45, 180, 25);
        c1.setFont(new Font("Verdana", Font.BOLD, 13));
        c1.setBackground(Color.WHITE);
        c1.setForeground(Color.BLUE);

        r1 = new JRadioButton("Manual", false);
        r1.setFont(new Font("Verdana", Font.BOLD, 12));
        r1.setBounds(160, 80, 75, 20);
        r1.setActionCommand("Manual");
        gr1 = new ButtonGroup();

        r2 = new JRadioButton("Automatic", false);
        r2.setFont(new Font("Verdana", Font.BOLD, 12));
        r2.setBounds(240, 80, 100, 20);
        r2.setActionCommand("Automatic");
        gr1.add(r1);
        gr1.add(r2);

        t1 = new JTextField(10);
        t1.setFont(new Font("Verdana", Font.BOLD, 12));
        t1.setBounds(165, 105, 180, 20);

        t2 = new JTextField(10);
        t2.setFont(new Font("Verdana", Font.BOLD, 12));
        t2.setBounds(165, 130, 180, 20);

        t3 = new JTextField(10);
        t3.setFont(new Font("Verdana", Font.BOLD, 12));
        t3.setBounds(165, 160, 180, 20);

        t4 = new JTextField(10);
        t4.setFont(new Font("Verdana", Font.BOLD, 12));
        t4.setBounds(165, 190, 180, 20);

        b1 = new JButton("Add Car to the file");
        b1.setFont(new Font("Verdana", Font.BOLD, 16));
        b1.setBounds(20, 230, 325, 25);

        b2 = new JButton("Open the Search Form");
        b2.setFont(new Font("Verdana", Font.BOLD, 16));
        b2.setBounds(20, 260, 325, 25);

        add(l7);
        add(l1);
        c1.addItem("--Choose--"); // add the other items of the comboxbox.....
        c1.addItem("Mercedes");// add the other items of the comboxbox.....
        c1.addItem("BMW");// add the other items of the comboxbox.....
        c1.addItem("Honda");
        c1.addItem("Ferrari");
        c1.addItem("Hyundai");
        c1.addItem("volkswagen");

        add(c1);
        add(l2);
        add(r1);
        add(r2);
        add(l3);
        add(t1);
        add(l4);
        add(t2);
        add(l5);
        add(t3);
        add(l6);
        add(t4);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1) {
            
            if (!(t1.getText() == "" && t2.getText() == "" && t3.getText() == "" && t4.getText() == "" || r1.isSelected()
                    || r2.isSelected())){
            JOptionPane.showMessageDialog(null, "All fields must be fill!");
            } else {
            try { 
                File car = new File("C:\\carinventory.txt");
                FileWriter writecar = new FileWriter("carinventory.txt", true);// the true is seting append while reading the file to add values at the end of the file
                
                writecar.write(c1.getSelectedItem().toString()+"   "+gr1.getSelection().getActionCommand()+ 
                        "    "+t1.getText() + "    " + t2.getText() + "    "  + t3.getText() + "    " + t4.getText()+"\n");
       
                writecar.close();
                JOptionPane.showMessageDialog(null, "Car Info has been stored!");
            } catch (IOException s) {
                JOptionPane.showMessageDialog(null, "An error occured!");

            }
            }
        }
        
        if(e.getSource()==b2){
            Search_form f2 = new Search_form();
            
        }
    }
}
