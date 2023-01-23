package com.adrynov.model;

public class Card {

    private CardSuite suit;
    private CardRank rank;

    public Card(CardSuite suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }
}