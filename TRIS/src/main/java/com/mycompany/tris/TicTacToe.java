
package com.mycompany.tris;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TicTacToe {
    int larghezzatabella;
    int altezzatabella;
    
    JFrame frame= new JFrame("Tris");
    JLabel label=new JLabel();
    JPanel panelditesto = new JPanel();
    JPanel tabella=new JPanel();
    JButton[][] board = new JButton[3][3] ;
    String giocatoreX = "X";
    String giocatoreO= "O";
    String giocatoreattuale=giocatoreX;
    
    boolean gameover=false;
    int turns = 0;
   public TicTacToe(int larghezza,int altezza){
       this.larghezzatabella=larghezza;
       this.altezzatabella=altezza;
       frame.setVisible(true);
       frame.setSize(larghezza, altezza);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(new BorderLayout());
       
       label.setBackground(Color.DARK_GRAY);
       label.setForeground(Color.GREEN);
       label.setFont(new Font("Arial",Font.BOLD,50));
       label.setHorizontalAlignment(JLabel.CENTER);
       label.setText("TRIS");
       label.setOpaque(true);
       
       panelditesto.setLayout(new BorderLayout());
       this.panelditesto.add(label);
       this.frame.add(this.panelditesto,BorderLayout.NORTH);
       
       tabella.setLayout(new GridLayout(3,3));
       tabella.setBackground(Color.DARK_GRAY);
       frame.add(tabella);
       
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               JButton attuale = new JButton();
               this.board[i][j]=attuale;
               tabella.add(attuale);
               
               attuale.setBackground(Color.DARK_GRAY);
               attuale.setForeground(Color.WHITE);
               attuale.setFont(new Font("Arial",Font.BOLD,120));
               attuale.setFocusable(false);
               attuale.addActionListener(new ActionListener(){
                   public void actionPerformed(ActionEvent e){
                       if(gameover) return;
                       JButton attuale = (JButton) e.getSource();
                       if(attuale.getText() == ""){
                       attuale.setText(giocatoreattuale);
                       turns++;
                       checkWinner();
                       if (!gameover){
                       giocatoreattuale = giocatoreattuale == giocatoreX ? giocatoreO : giocatoreX;
                       label.setText("turno di "+ giocatoreattuale);
                       }
                       }
           };
               });
       
       
   }
       }
       
   }
   public void checkWinner(){
       for(int i=0;i<3;i++){
           if(board[i][0].getText() == "") continue;
           if(board[i][0].getText()== board[i][1].getText() && board[i][1].getText() == board[i][2].getText()){
               for(int j=0;j<3;j++){
                   setWinner(board[i][j]);
               }
               
               gameover = true;
               return;
           }
           }
       for(int z=0;z<3;z++){
           if(board[0][z].getText() == "") continue;
           if(board[0][z].getText() == board[1][z].getText() && board[1][z].getText() == board[2][z].getText()){
               for(int i=0;i<3;i++){
                   setWinner(board[i][z]);
               }
               gameover = true;
               return;
           }
       }
       
       if(board[0][0].getText() == board[1][1].getText() && board[1][1].getText() == board[2][2].getText() && board[0][0].getText() != ""){
           for(int i=0;i<3;i++){
               setWinner(board[i][i]);
           }
           gameover = true;
           return;
       }
       
       if(board[0][2].getText() == board[1][1].getText() && board[1][1].getText() == board[2][0].getText() && board[2][0].getText() != ""){
           setWinner(board[0][2]);
           setWinner(board[1][1]);
           setWinner(board[2][0]);
           gameover = true;
           return;
       }
       if(turns == 9){
           for(int i=0;i<3;i++){
               for(int j=0;j<3;j++){
                   setTie(board[i][j]);
               }
           }
           gameover = true;
       }
       }
   public void setWinner(JButton tile){
       tile.setForeground(Color.BLUE);
       tile.setBackground(Color.GRAY);
       label.setText(giocatoreattuale + " è il vincitore!");
   }
   
   public void setTie(JButton tile){
       tile.setForeground(Color.orange);
       tile.setBackground(Color.DARK_GRAY);
       label.setText("C'è un pareggio!");
   }
   }

   

   
   
    

