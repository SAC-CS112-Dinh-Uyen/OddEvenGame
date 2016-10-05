package oddevengame;

/**
 *
 * @author uyen
 */
import java.util.Scanner; 
import java.util.Random;
import java.util.Arrays;
public class OddEvenGame 
{
    // Main method begins execution of Java application
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int userGuess; // user guess odd or even number.
        int i=0;
        int userWin=0;//Number of times user win;
        int totalPlay=1;//Number of times user have played.
        int rollOddNum=0; //Number of times the dice have been rolled an Odd Number.
        int rollEvenNum=0; //Number of times the dice have been rolled an Even Number.
        float percentageWin;
        int[] listDie= new int[100];
        String[] listUser=new String[100];
        String[] listResult=new String[100];
        
        do
        {   
           
            int die = 1 + (int)(Math.random()*6);
            listDie[i]= die;
            System.out.println("die is:" + die);
            System.out.println("Enter a guess number with 1 for Odd, 2 for Even:");
            userGuess = input.nextInt();
            if(userGuess==1)
                listUser[i]="Odd";
            else
                listUser[i]="Even";
            
            if(die%2==0)
                rollEvenNum++;
            else
                rollOddNum++;
            if(die%2==0 && userGuess==2)
            {
                userWin ++;
                listResult[i]="Win";
                System.out.println("You win!");
            }
            else if (die%2!=0 && userGuess==1)
            {
                userWin ++;
                System.out.println("You win!");
                listResult[i]="Win";
            }
            else
            {
                System.out.println("You lose!");
                listResult[i]="Lose";
            }
            
            System.out.println("Would you like to play again? Y/N");
            String answer = input.next(); 
            String upperCaseAnswer = answer.toUpperCase(); 
            if(upperCaseAnswer.equals("Y"))
            {
                i++;
                totalPlay ++;
            }
            else
            {             
                //create rows/columns of text representing array game history
                // int[][] aryGame = new int[totalPlay][3];
                System.out.printf("Game history is:%n");
                System.out.printf("                    ");
                System.out.printf("Die number     ");
                System.out.printf("User guess     ");
                System.out.printf("Result%n");
                for(int row=0; row<totalPlay;row++)
                {
                    System.out.printf("           Game %d", row +1);
                    //Out put game history
                    System.out.printf("       %d",listDie[row]);
                    System.out.printf("             %s",listUser[row]);
                    System.out.printf("          %s",listResult[row]);
                    System.out.println();
                }
                
                i=0;
            }
        }while(i!=0 && i<100);
        
        percentageWin = (float)((userWin*100)/totalPlay);
        System.out.printf("%nYou've won %d number of times.",userWin);
        System.out.printf("%nYou've played %d number of times.%n",totalPlay);
        System.out.printf("The system generate %d number of Odds and %d number of Even.%n",rollOddNum, rollEvenNum);
        System.out.printf("Your winning percentage is %s.%n",percentageWin+"%");
        System.out.println("Goodbye!");
   
    } // End main
 } // End class OddEvenGame
// Please see if you can combine the  if(die%2==0) statements.
