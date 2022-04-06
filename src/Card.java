public class Card{

    private char suit;
    private int rank;

    // Initializes a card instance
    public Card(char suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    // Accessor for suit
    public char getSuit(){
        return suit;
    }

    // Accessor for rank
    public int getRank(){
        return rank;
    }

    // Returns a human readable form of the card (eg. King of Diamonds)
    public String toString(){
        String suitWord = "";
        String rankWord = "";
        if(suit == 'h')
            suitWord = "Hearts";
        if(suit == 'c')
            suitWord = "Clovers";
        if(suit == 'd')
            suitWord = "Diamonds";
        if(suit == 's')
            suitWord = "Spades";
        if (rank == 1)
            rankWord = "Ace";
        if (rank == 2)
            rankWord = "Two";
        if (rank == 3)
            rankWord = "Three";
        if (rank == 4)
            rankWord = "Four";
        if (rank == 5)
            rankWord = "Five";
        if (rank == 6)
            rankWord = "Six";
        if (rank == 7)
            rankWord = "Seven";
        if (rank == 8)
            rankWord = "Eight";
        if (rank == 9)
            rankWord = "Nine";
        if (rank == 10)
            rankWord = "Ten";
        if (rank == 11)
            rankWord = "Queen";
        if (rank == 12)
            rankWord = "King";
        return rankWord + " of " + suitWord;
    }
}