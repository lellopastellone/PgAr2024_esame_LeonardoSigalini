package it.unibs.fp.ArnaldoWest.CardManager;

import it.kibo.fp.lib.AnsiColors;
import it.unibs.fp.ArnaldoWest.main.UserInteraction;

public class Weapon extends Card{
    public static final String CARD_WORDING = "Carta: ";
    public static final String GITTATA_WORDING = "\nGittata: ";
    private int distance;

    public Weapon(String name, int distance) {
        super(name);
        this.distance = distance;
    }

    @Override
    public String toString() {
        return UserInteraction.coloredMessage(CARD_WORDING, AnsiColors.PURPLE)  + getName() + UserInteraction.coloredMessage(GITTATA_WORDING, AnsiColors.PURPLE) + distance;
    }
}
