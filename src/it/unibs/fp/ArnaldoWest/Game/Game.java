package it.unibs.fp.ArnaldoWest.Game;

import it.kibo.fp.lib.Menu;
import it.unibs.fp.ArnaldoWest.CardManager.Deck;

import java.util.*;

public class Game {
    public static final String SHERIFF = "sheriff";
    public static final String RENEGADE = "renegade";
    public static final String OUTLAW = "outlaw";
    public static final String VICE = "vice";
    public static final String PLAYER_1 = "giocatore 1";
    public static final String PLAYER_WORDING = "giocatore ";
    public static final String MENU_TITLE = "SCEGLI LA CARTA DA VOLER UTILIZZARE";
    private final String[] roles = {RENEGADE, OUTLAW, OUTLAW, OUTLAW, VICE, OUTLAW};

    private Deque<Player> players;
    private Deck deck;

    public Game(boolean tournament, int numPlayers) {
        deck = new Deck();
        players = new ArrayDeque<>();
        ArrayList<String> subRoles = new ArrayList<>(List.of(Arrays.copyOfRange(roles, 0, numPlayers)));
        Collections.shuffle(subRoles);
        players.add(new Player(PLAYER_1, SHERIFF, tournament));
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(PLAYER_WORDING + (i + 1), subRoles.get(i), tournament));
        }

    }

    public void play() {
        while (!players.isEmpty()) {
            Player activePlayer = players.pop();
            drawCard(activePlayer, 2);
            String[] entries = activePlayer.getCards().entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).toArray(String[]::new);
            Menu cardMenu = new Menu(MENU_TITLE, entries, false, true, true);

        }
    }

    public void drawCard(Player player, int amount) {
        for (int i = 0; i < amount; i++) {
            player.addCard(deck.exctractCard());
        }
    }

}