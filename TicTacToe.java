package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TicTacToe extends JFrame implements ActionListener
{
    JFrame f;
    JPanel p, p2, s1, s2;;
    JButton b[]=new JButton[9];

    int chance=0;
    String str;
    Font font;
    JButton reset,next;
    JLabel l, c;
    Font f2;

    int c1=0,c2=0;
    String st;

    ImageIcon img;
    TicTacToe()
    {
        
        f=new JFrame("Tic-Tac-Toe");
        f.setSize(500,500);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        // f.setResizable(false);
        
        f.setDefaultCloseOperation(3);

        p=new JPanel();
        p.setSize(300,300);
        p.setLayout(new GridLayout(3,3));
        p.setLocation(150,150);
        p.setBackground(Color.CYAN);
        f.add(p);

        for(int i=0;i<9;i++)
        {
            b[i]=new JButton();
            b[i].setSize(50,50);
            b[i].addActionListener(this);
            b[i].setFont(new Font("Arial",50,50));
            p.add(b[i]);
        }

        font=new Font("Arial",50,50);

        l=new JLabel("\tPLAY GAME");
        l.setForeground(Color.RED);
        l.setFont(font);
        l.setSize(500,80);
        l.setLocation(150,50);
        f.add(l);

        p2=new JPanel();
        p2.setSize(300,200);
        p2.setLocation(150,475);
        f.add(p2);

        reset=new JButton("RESET");
        reset.setSize(80,40);
        reset.setLocation(200,440);
        reset.addActionListener(this);
        p2.add(reset);

        next =new JButton("Next Match");
        next.setLocation(250,440);
        next.setSize(100,40);
        next.addActionListener(this);
        p2.add(next);

        s1=new JPanel();
        s1.setSize(100,300);
        s1.setLocation(20,170);
        f.add(s1);

        s2=new JPanel();
        s2.setSize(100,300);
        s2.setLocation(450,170);
        f.add(s2);







        c=new JLabel("Developed by Akhilendra.");
        c.setFont(new Font("Arial",10,10));
        c.setSize(300,25);
        c.setLocation(25,500);
        p2.add(c);


        f.pack();
    }

    public void actionPerformed(ActionEvent e)
    {
        chance++;
        if(chance%2==0)
        { str="X";
        }
        else
        {str="O";
        }
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==b[i])
            {
                b[i].setText(str);
                b[i].setEnabled(false);
                if(str.equals("X"))
                {
                    b[i].setForeground(Color.BLUE);
                }
                else if(str.equals("O"))
                { 
                    b[i].setForeground(Color.YELLOW);
                } 
            }
        }

        String t[]=new String[9];
        for(int i=0;i<9;i++)
        {
            t[i]=b[i].getText();
        }

        if(
        t[0].equals(t[4]) && t[0].equals(t[8]) && t[0].equals("X") 
        ||  t[0].equals(t[3]) && t[0].equals(t[6]) && t[0].equals("X")
        ||t[0].equals(t[1]) && t[0].equals(t[2]) && t[0].equals("X")
        || t[6].equals(t[7]) && t[6].equals(t[8]) && t[6].equals("X")
        ||t[2].equals(t[5]) && t[2].equals(t[8]) && t[2].equals("X")
        ||t[2].equals(t[4]) && t[2].equals(t[6]) && t[2].equals("X")
        ||t[1].equals(t[4]) && t[1].equals(t[7]) && t[1].equals("X")
        ||t[3].equals(t[4]) && t[3].equals(t[5]) && t[3].equals("X"))
        {
            l.setText("X WON O LOST !"); 
            freeze();
            c1++;

            c1--;
        }

        if(
        t[0].equals(t[4]) && t[0].equals(t[8]) && t[0].equals("O") 
        ||  t[0].equals(t[3]) && t[0].equals(t[6]) && t[0].equals("O")
        ||t[0].equals(t[1]) && t[0].equals(t[2]) && t[0].equals("O")
        || t[6].equals(t[7]) && t[6].equals(t[8]) && t[6].equals("O")
        ||t[2].equals(t[5]) && t[2].equals(t[8]) && t[2].equals("O")
        ||t[2].equals(t[4]) && t[2].equals(t[6]) && t[2].equals("O")
        ||t[1].equals(t[4]) && t[1].equals(t[7]) && t[1].equals("O")
        ||t[3].equals(t[4]) && t[3].equals(t[5]) && t[3].equals("O"))

        {
            l.setText("O WON X LOST !"); 
            freeze();
            c2++;

            c2--;
        }

        if(e.getSource()==reset)
        {

            for(int i=0;i<9;i++)
            {
                p.add(b[i]);
                b[i].setText("");
                b[i].setEnabled(true);
                b[i].setBackground(Color.GREEN);
                l.setText("PLAY GAME");
            }

            c1=0;
            c2=0;
            chance=0;
        }

        if (e.getSource()==next)
        {
            for(int i=0;i<9;i++)
            {
                b[i].setText("");
                b[i].setEnabled(true);
                b[i].setBackground(null);
                l.setText("PLAY GAME");

                if(chance%2==0)
                    chance=1;
                else
                    chance=0;
            }
        }

    }

    void freeze()
    {
        for(int i=0;i<9;i++)
        {
            b[i].setEnabled(false);
        }
    }

}