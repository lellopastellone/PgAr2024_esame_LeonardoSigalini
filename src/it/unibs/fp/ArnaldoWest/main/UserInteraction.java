package it.unibs.fp.ArnaldoWest.main;

import it.kibo.fp.lib.AnsiColors;
import it.kibo.fp.lib.Menu;

//TODO: sistemare la classe.

/*
 * This class manages every interaction with the user,
 * mostly messages. It follows this precise
 * color scheme:
 * RED: for every "negative" message
 * GREEN: for every "positive" message
 * YELLOW: for status information
 * */
public class UserInteraction {

    private static final int ERROR_SLEEP_TIME = 5000;
    private static final int TITLE_SLEEP_TIME = 3000;
    private static final int INTRODUCTION_SLEEP_TIME = 5000;
    private static final String TITLE =
            "██████╗  ██████╗ ██╗   ██╗██╗███╗   ██╗███████╗    ██████╗ ███████╗██████╗ ██████╗ ██╗   ██╗████████╗███████╗\n" +
            "██╔══██╗██╔═══██╗██║   ██║██║████╗  ██║██╔════╝    ██╔══██╗██╔════╝██╔══██╗██╔══██╗██║   ██║╚══██╔══╝██╔════╝\n" +
            "██████╔╝██║   ██║██║   ██║██║██╔██╗ ██║█████╗      ██████╔╝█████╗  ██████╔╝██║  ██║██║   ██║   ██║   █████╗  \n" +
            "██╔══██╗██║   ██║╚██╗ ██╔╝██║██║╚██╗██║██╔══╝      ██╔═══╝ ██╔══╝  ██╔══██╗██║  ██║██║   ██║   ██║   ██╔══╝  \n" +
            "██║  ██║╚██████╔╝ ╚████╔╝ ██║██║ ╚████║███████╗    ██║     ███████╗██║  ██║██████╔╝╚██████╔╝   ██║   ███████╗\n" +
            "╚═╝  ╚═╝ ╚═════╝   ╚═══╝  ╚═╝╚═╝  ╚═══╝╚══════╝    ╚═╝     ╚══════╝╚═╝  ╚═╝╚═════╝  ╚═════╝    ╚═╝   ╚══════╝\n" +
            "                                                                                                             ";
    private static final String WELCOME_MESSAGE = "Benvenuti, avventurieri!!";
    private static final String INTRODUCTION_MESSAGE = "Ora calcolerò la rotta ottimale in base alla mappa inserita.";
    private static final String READING_MESSAGE = "Lettura in corso...";
    private static final String CALCULATING_MESSAGE = "Calcolo in corso...";
    private static final String WRITING_MESSAGE = "Scrittura in corso...";
    private static final String FAREWELL_MESSAGE = "Perfetto! Le indicazioni sono disponibili per la visualizzazione all'interno del file \"routes\"";
    private static final int MESSAGE_SLEEP_TIME = 1000;

    public static void welcome() {
        System.out.println(TITLE);
        waitAndClear(TITLE_SLEEP_TIME);
        printColoredMessage(WELCOME_MESSAGE, AnsiColors.YELLOW);
        System.out.println(INTRODUCTION_MESSAGE);
        try {
            Menu.wait(INTRODUCTION_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reading() {
        printColoredMessage(READING_MESSAGE, AnsiColors.YELLOW);
        try {
            Menu.wait(MESSAGE_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void calculating() {
        printColoredMessage(CALCULATING_MESSAGE, AnsiColors.YELLOW);
        try {
            Menu.wait(MESSAGE_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writing() {
        printColoredMessage(WRITING_MESSAGE, AnsiColors.YELLOW);
        try {
            Menu.wait(MESSAGE_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void farewell() {
        printColoredMessage(FAREWELL_MESSAGE, AnsiColors.GREEN);
        try {
            Menu.wait(MESSAGE_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String coloredMessage(String message, AnsiColors color) {
        return color + message + AnsiColors.RESET;
    }

    public static void printColoredMessage(String message, AnsiColors color) {
        System.out.println(coloredMessage(message, color));
    }

    public static void fatalError(String message) {
        printColoredMessage(message, AnsiColors.RED);
        try {
            Thread.sleep(ERROR_SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    public static void waitAndClear(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(AnsiColors.CLEAR);
        System.out.flush();
    }
}
