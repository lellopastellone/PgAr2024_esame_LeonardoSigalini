package it.unibs.fp.ArnaldoWest.Game;

import it.kibo.fp.lib.AnsiColors;
import it.unibs.fp.ArnaldoWest.CardManager.Card;
import it.unibs.fp.ArnaldoWest.main.UserInteraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    public static final int SHERIFF_PF = 5;
    private static final int TOURNAMENT_AMOUNT = 500;
    private static final int STANDARD_AMOUNT = 0;
    public static final String PLAYER_CALL = ",Tocca a te!\n";
    public static final String SHERIFF = "sheriff";
    public static final int STANDARD_PF = 4;
    private String name;
    private String role;
    private int PF;
    private Map<Card, Integer> cards;
    private int sbleuri;
    
    public Player(String name, String role, boolean tournament) {
        this.name = name;
        this.role = role;
        this.PF = role.equals(SHERIFF) ? SHERIFF_PF : STANDARD_PF;
        this.cards = new HashMap<>();
        sbleuri = tournament ? TOURNAMENT_AMOUNT : STANDARD_AMOUNT;
    }

    public void addCard(Card card) {
        if(cards.containsKey(card)) {
            cards.put(card, cards.get(card) + 1);
        } else {
            cards.put(card, 1);
        }
    }

    public Map<Card, Integer> getCards(){
        return cards;
    }

    public void getDamage(int amount) {
        PF--;
    }

    public boolean isDead() {
        return PF == 0;
    }

    public String toString() {
        return UserInteraction.coloredMessage(name + PLAYER_CALL, AnsiColors.YELLOW);
    }
}
