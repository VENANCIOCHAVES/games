import javax.swing.*;
import java.util.Random;
class guessTheNumber{
    public static void main (String args[]){
        int guess=0, guessTake=1;
        String name="";
        
        Random randNumber = new Random();
        int number = randNumber.nextInt(21);
        
        name=JOptionPane.showInputDialog(null,"Hello, what's your name?");
        JOptionPane.showMessageDialog(null,name+", I'm thinking of a number between 1 and 20, you have five chances to guess");
        
        int i=1;
        while(i<=5){
            guess=Integer.parseInt(JOptionPane.showInputDialog(null, "Take a guess"));
            if(guess==number){
                JOptionPane.showMessageDialog(null,"Good job "+name+", you guessed my number in "+guessTake+" guesses");
                break;
            }
            if(guess>number){
                JOptionPane.showMessageDialog(null,"Your guess is too high");
                i++;
                guessTake=i;
            }else{
                JOptionPane.showMessageDialog(null,"Your guess is too low");
                i++;
                guessTake=i;
             }
            if(i==5 && guess!=number){
                JOptionPane.showMessageDialog(null,"The number I was thinking was "+number);
            }
        }
    }
}