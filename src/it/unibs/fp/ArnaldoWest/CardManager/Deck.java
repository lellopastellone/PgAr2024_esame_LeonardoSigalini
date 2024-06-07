package it.unibs.fp.ArnaldoWest.CardManager;

import java.util.*;

public class Deck {
    public static final String BANG = "BANG!";
    public static final String MANCATO = "Mancato!";
    public static final int MIN_CARD = 1;
    public static final int N_BANGS = 50;
    public static final int N_MISS = 24;
    public static final int N_SCHOFIELD = 3;
    public static final String SCHOFIELD = "Schofield";
    public static final String REMINGTON = "Remington";
    public static final String REV_CARABINE = "Rev. Carabine";
    public static final String WINCHESTER = "Winchester";
    public static final int SCHOFIELD_DISTANCE = 2;
    public static final int REMINGTON_DISTANCE = 3;
    public static final int REV_CARABINE_DISTANCE = 4;
    public static final int WINCHESTER_DISTANCE = 5;
    private Deque<Card> deck;
    private ArrayList<Card> waste = new ArrayList<>();

    public Deck() {
        createDeck();
    }

    private void createDeck() {
        for(int i = MIN_CARD; i <= N_BANGS; i++) {
            waste.add(new PlayAndDiscard(BANG));
        }
        for(int i = MIN_CARD; i < N_MISS; i++) {
            waste.add(new PlayAndDiscard(MANCATO));
        }
        for(int i = MIN_CARD; i < N_SCHOFIELD; i++) {
            waste.add(new Weapon(SCHOFIELD, SCHOFIELD_DISTANCE));
        }
        waste.add(new Weapon(REMINGTON, REMINGTON_DISTANCE));
        waste.add(new Weapon(REV_CARABINE, REV_CARABINE_DISTANCE));
        waste.add(new Weapon(WINCHESTER, WINCHESTER_DISTANCE));

        shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(waste);
        deck = new ArrayDeque<>(waste);
    }

    public Card exctractCard() {
        return deck.poll();
    }

    public void discard(Card card) {
        waste.add(card);
    }
}
