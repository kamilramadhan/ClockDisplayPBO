import java.util.HashMap;
import java.util.Scanner;

class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getDescription() {
        return description;
    }

    public String getExitString() {
        StringBuilder exitString = new StringBuilder("Exits: ");
        for (String exit : exits.keySet()) {
            exitString.append(exit).append(" ");
        }
        return exitString.toString();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}

class Command {
    private String commandWord;
    private String secondWord;

    public Command(String commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean hasSecondWord() {
        return secondWord != null;
    }

    public boolean isUnknown() {
        return commandWord == null;
    }
}

class CommandWords {
    private static final String[] validCommands = {"go", "quit", "help"};

    public boolean isCommand(String aString) {
        for (String command : validCommands) {
            if (command.equals(aString)) {
                return true;
            }
        }
        return false;
    }

    public String getCommandList() {
        return String.join(", ", validCommands);
    }
}

class Parser {
    private CommandWords commandWords;
    private Scanner reader;

    public Parser() {
        commandWords = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");
        String inputLine = reader.nextLine();
        String[] words = inputLine.split(" ");
        String word1 = words.length > 0 ? words[0] : null;
        String word2 = words.length > 1 ? words[1] : null;

        if (commandWords.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2);
        }
    }

    public void showCommands() {
        System.out.println("Valid commands: " + commandWords.getCommandList());
    }
}

public class WorldOfZuul {
    private Parser parser;
    private Room currentRoom;

    public WorldOfZuul() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room outside = new Room("outside the main entrance of the university");
        Room theater = new Room("in a lecture theater");
        Room pub = new Room("in the campus pub");
        Room lab = new Room("in a computing lab");
        Room office = new Room("in the admin office");

        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Goodbye!");
    }

    private void printWelcome() {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.println(currentRoom.getExitString());
    }

    private boolean processCommand(Command command) {
        if (command.isUnknown()) {
            System.out.println("I don't understand what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            return quit(command);
        }
        return false;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.println(currentRoom.getExitString());
        }
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        WorldOfZuul game = new WorldOfZuul();
        game.play();
    }
}
