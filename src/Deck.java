

public class Deck{
    private Card[] deck; // contains the cards to play with
    private int top; // controls the "top" of the deck to deal from
    // constructs a default Deck
    public Deck(){
        top = 0;
        deck = new Card [52];
        char [] ranks = new char [] {'s' , 'h', 'c' , 'd' };
        for(int i = 0; i<13; i++){
            deck [i] = new Card ( 's' , i+1);
            deck [i+13] = new Card ( 'h' , i+1);
            deck [i+26] = new Card ( 'c' , i+1);
            deck [i+39] = new Card ( 'd' , i+1);
        }

        shuffle();
    }
    // Deals the top card off the deck
    public Card deal(){
        // your code here
        Card temp = deck [top];
        deck[top] = null;
        top++;
        return temp;


    }
    // returns true provided there is a card left in the deck to deal
    public boolean canDeal(){
        // your code here
        for (int i = 0; i<deck.length; i++)
        {
            if (deck[i] != null)
            {
                return true;
            }
        }
        return false;
    }
    // Shuffles the deck
    public void shuffle(){
        // your code here
        int r = 0;
        Card temp = null;
        for (int i = 51; i>=1; i--)
        {
            r= (int)((i-0+1)*Math.random() +0);
            temp = deck[i];
            deck [i] = deck [r];
            deck[r] = temp;
        }

    }
    // Returns a string representation of the whole deck
    public String toString(){
        // your code here
        String rep = "";
        for (int i = 0; i<deck.length; i++)
        {
            rep +=  deck[i].toString() + " " ;
        }
        return rep;
    }
    // you may wish to have more helper methods to simplify
    // and shorten the methods above.
}
