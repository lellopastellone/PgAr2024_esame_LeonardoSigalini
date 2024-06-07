package it.unibs.fp.ArnaldoWest.CardManager;

public abstract class Card {
    private String name;

    protected String getName() {
        return name;
    }

    public Card(String name) {
        this.name = name;
    }

    public abstract String toString();
}
