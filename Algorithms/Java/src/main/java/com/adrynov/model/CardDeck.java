package com.adrynov.model;

public class DeckOfCards {
    private Card cards[];

    static  {
        for (CardSuite s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                Card c = new Card(s,r);
            }
        }
    }

}
