package pkg08_elevengame;

/**
 *
 * @author HP
 */
public class Board implements BoardInterface {

    private Card[] cards; //devet karet vylozenych na stole
    private Deck deck; //balíček

    public Board() {
    }

    public Board(Card[] cards, Deck deck) {
        this.cards = cards;
        this.deck = deck;
    }

    public String getName() {
        return "Hra Jedenáct";
    }

    public int nCards() {
        return cards.length;
    }

    public String getCardDescriptionAt(int index) {
        if (cards[index] == null) {
            return "               ";
        }
        return cards[index].toString();
    }

    public int getDeckSize() {
        return deck.getnCards();
    }

    public boolean isAnotherPlayPossible() {
        int jqk = 0;
        int nEmpty = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) {
                nEmpty++;
            } else {
                if (cards[i].getnPoints() == 0) {
                    jqk++;
                }
                for (int j = i + 1; j < cards.length; j++) {
                    if (i < cards.length - 1 && cards[j] != null && cards[i].getnPoints() + cards[j].getnPoints() == 1) {
                        return true;
                    }
                }
            }
        }
        return jqk>2;
        
    }

    public boolean playAndReplace(String[] selectedCardsPositions) {
        int nPoints = 0;
        int[] selected = new int[selectedCardsPositions.length];
        for (int i = 0; i < selectedCardsPositions.length; i++) {
            selected[i] = Integer.parseInt(selectedCardsPositions[i]) - 1;
        }
        if (whichPosition(selected)) {
            for (int i : selected) {
                nPoints = nPoints + cards[i].getnPoints();
            }
        } else {
            return false;
        }
        if ((nPoints == 11 && selected.length == 2) || (nPoints == 0 && selected.length == 3)) {
            for (int i : selected) {
                cards[i] = deck.giveCard();
            }
            return true;
        }
        return false;
    }

    public boolean whichPosition(int[] selected) {
        for (int i : selected) {
            if (i < 0 || i > 8) {
                return false;
            }
        }
        return true;
    }

    public boolean hasWon() {
        return deck.getnCards() == 0;
    }
    
    public static Board newBoard(){
    Deck deck = Deck.packOfCards();
        deck.shuffleCards();
        Card[] cards = new Card[9];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = deck.giveCard();
        }
        return new Board(cards, deck);
    }
}
