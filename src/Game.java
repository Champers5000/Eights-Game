import java.util.Scanner;
import java.util.ArrayList;

public class Game{

    private char currentSuit; // need in case an 8 is player
    private static Card faceup;
    private Scanner input;
    private Player p1;
    private ArrayList<Card> compHand;
    private Deck cards;
    private boolean gameover;
    
    // sets up the Game object for play
    public Game(){
        cards = new Deck();
        compHand = new ArrayList<Card>(7);
        p1 = new Player();
        for(int i=0; i<7 ; i++){
            compHand.add(cards.deal());
            p1.addCard(cards.deal());
        }


        faceup = cards.deal();
        currentSuit = faceup.getSuit();
        input = new Scanner(System.in);
        gameover=false;
    }

   

    // Plays a game of crazy eights. 
    // Returns true to continue playing and false to stop playing
    public boolean play() {
        System.out.println("The top card is " + faceup.toString());
        while (!gameover) {
            System.out.println(p1.handToString());


            Card playerCard = null;

            playerCard = p1.playsTurn(cards);

            if (playerCard == null) {
                checkless();
                break;
            }
            faceup = playerCard;
            if(p1.getHand().size()==0){
                System.out.println("You win!!");
                break;
            }

            faceup = computerTurn();
            System.out.println("Computer has played a " + faceup.toString()+"\nComputer has "+compHand.size()+" cards left");
            if(compHand.size()==0){
                System.out.println("Computer wins, and YOU LOSE!!");
                break;
            }
            if(faceup==null){
                checkless();
                break;
            }

        }

        System.out.println("Do you want to play again? Enter \"yes\" to play again, anything else will be no");
        String playagain = input.nextLine();
        return playagain.equals("yes");
    }

    /* Naive computer player AI that does one of two actions:
        1) Plays the first card in their hand that is a valid play
        2) If no valid cards, draws until they can play

        You may choose to use a different approach if you wish but
        this one is fine and will earn maximum marks
     */
     private Card computerTurn(){
        for(int i=0; i<compHand.size(); i++){
            Card temp = compHand.get(i);
            if(verifyCard(temp)){
                compHand.remove(i);
                return temp;
            }
        }

        while(cards.canDeal()){
            Card temp = cards.deal();
            compHand.add(temp);
            if(verifyCard(temp)){
                compHand.remove(compHand.size()-1);
                return temp;
            }
        }

        return null;
    }

    public static boolean verifyCard(Card temp){
         if(temp==null){
             return false;
         }
        if(temp.getSuit()== faceup.getSuit() || temp.getRank() == faceup.getRank() || temp.getRank() == 8){
            return true;
        }
        return false;
    }

    public void checkless(){
         if(p1.getHand().size()<compHand.size()){
             System.out.println("No cards left, but you have less cards so you win!!");
         }else if (p1.getHand().size()==compHand.size()){
             System.out.println("No cards left. You and computer have same number of cards so it's a tie");
         }else{
             System.out.println("No cards left. Computer has less cards so YOU LOSE!");;
         }
    }
   // you will likely wish to have several more helper methods to simplify
   // and shorten the methods above.


}