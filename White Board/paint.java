import java.awt.*;  
import java.awt.event.*;
import java.io.ObjectInputFilter.Status;
import java.util.Random;

import javax.swing.JButton;

import org.w3c.dom.events.Event;

import java.lang.Math;
public class paint extends MouseMotionAdapter implements ActionListener{  
    Frame f; 
    int size = 5;
    double i=0;
    String ch = "1";
    int red,green,blue;
    int stat = 1;
    paint(){  
        f=new Frame("Mouse Motion Adapter");  
        f.addMouseMotionListener(this);  
        f.setSize(900,800);  
        f.setLayout(null);  
        f.setVisible(true);
        JButton btn = new JButton("+");
        btn.setBounds(800, 40, 70, 20);
        f.add(btn);
        JButton btn2 = new JButton("-");
        btn2.setBounds(800, 65, 70, 20);
        f.add(btn2);
        JButton btn3 = new JButton("clear");
        btn3.setBounds(800, 90, 70, 20);
        f.add(btn3);
        JButton btn4 = new JButton("style");
        btn4.setBounds(800, 115, 70, 20);
        f.add(btn4);
        btn.addActionListener(this);btn2.addActionListener(this);btn3.addActionListener(this);btn4.addActionListener(this);
    }  
    public void mouseDragged(MouseEvent e) {
        Graphics g=f.getGraphics(); 
        double frequency = 1;
        for (; i < 256;)
        {
            i+=.05;
            red   = Integer.valueOf((int) (Math.sin(frequency*i + 0) * 100 + 127));
            green = Integer.valueOf((int) (Math.sin(frequency*i + 2) * 100 + 127));
            blue  = Integer.valueOf((int) (Math.sin(frequency*i + 4) * 100 + 127));
            g.setColor(new Color(red,green,blue));
            break;
        }
        if(i>255) i=1;
        if(stat == 1){
            g.fillRect(e.getX(),e.getY(),size,size);
        }
        if(stat == 2){
            g.drawLine(e.getX(),e.getY(),size,size);
        }
        if(stat == 3){
            g.fillOval(e.getX(),e.getY(),size,size);
        }
        if(stat == 4){
            g.fill3DRect(e.getX(),e.getY(),size,size, false);
        }
    }  
    public void actionPerformed(ActionEvent e){
        ch = String.valueOf(e.getActionCommand());
        if(ch == "+"){
            size+=1;
        }
        if(ch == "-"){
            size-=1;
        }
        if(ch == "clear"){
            f.repaint();
        }
        if(ch == "style"){
            f.repaint();
            if(stat == 1) stat = 2;
            else if(stat == 2) stat = 3;
            else if(stat == 3) stat = 4;
            else if(stat == 4) stat = 1;
        }
    }
public static void main(String[] args) {  
    new paint();  
}  
}