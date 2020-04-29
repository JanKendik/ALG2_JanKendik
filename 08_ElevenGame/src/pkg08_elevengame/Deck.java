package pkg08_elevengame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {//balíček karet

    private List<Card> deckCards;
    private int nCards;

    public Deck() {
    }

    public Deck(List<Card> deckCards, int nCards) {
        this.deckCards = deckCards;
        this.nCards = nCards;
    }

    public int getnCards() {
        return nCards;
    }

    public static Deck packOfCards() {
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] symbols = {"kule", "žaludy", "černý", "červený"};
        List<Card> pack = new ArrayList<>();
        for (String value : values) {
            for (String symbol : symbols) {
                Card card = new Card(symbol, value);
                pack.add(card);
            }

        }
        Deck balik = new Deck(pack, pack.size());
        return balik;

    }

    public void shuffleCards() {
        Collections.shuffle(this.deckCards);
    }

    public Card giveCard() {
        if (this.nCards == 0) {
            return null;
        }
        Card card = this.deckCards.get(this.nCards - 1);//vrátí "vrchní" kartu balíčku
        this.nCards--;
        return card;
    }

}
