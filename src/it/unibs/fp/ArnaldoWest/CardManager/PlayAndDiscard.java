package it.unibs.fp.ArnaldoWest.CardManager;

import it.kibo.fp.lib.AnsiColors;
import it.unibs.fp.ArnaldoWest.main.UserInteraction;

public class PlayAndDiscard extends Card{
    public static final String CARD_WORDING = "Carta: ";
    public PlayAndDiscard(String name){
        super(name);
    }
    
    @Override
    public String toString() {
        return UserInteraction.coloredMessage(CARD_WORDING, AnsiColors.PURPLE)  + getName();
    }
}
