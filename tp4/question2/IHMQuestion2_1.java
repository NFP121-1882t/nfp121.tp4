package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_1 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);
    private boolean test = false;
 
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();show();

        // à compléter
        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3

        // le bouton B a 2 observateurs jbo1 et jbo2

        // le bouton C a 1 observateur jbo1
        
          add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        if (test)
            enHaut.setBackground(Color.magenta);
        else
            enHaut.setBackground(Color.blue);

        
        boutonA.addActionListener(new JButtonObserver("JButon1", contenu));//les 3 observer
        boutonA.addActionListener(new JButtonObserver("JButon2", contenu));
        boutonA.addActionListener(new JButtonObserver("JButon3", contenu));       
        boutonB.addActionListener(new JButtonObserver("JButton 2", contenu));//2 observer
        boutonB.addActionListener(new JButtonObserver("JButton2.2", contenu));
        boutonC.addActionListener(new JButtonObserver("JButton1", contenu));//1 observer

        if (test) {
     
            boutonA.addMouseListener(new JMouseObserver("JMouse 1", contenu));
          
            boutonB.addMouseListener(new JMouseObserver("JMouse 2", contenu));
          
            boutonC.addMouseListener(new JMouseObserver(" JMouse 3", contenu)); 
        }

      
    }
    
    public static void main(String[] args){
        new IHMQuestion2_1();
    }

}