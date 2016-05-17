import java.util.ArrayList;

/**
 * Created by Iulkolog on 12.05.2016.
 */
public class Player {
    private static int count = 0;
    private int id;
    private ArrayList<Game> possibleGamesForPlayer;

    public Player(){
        id = ++count;
        possibleGamesForPlayer = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public void addGame(Game g){
        possibleGamesForPlayer.add(g);
    }

    public int countPossibleGames(){
        return possibleGamesForPlayer.size();
    }

    public Game getGameNumber(int number){
        return possibleGamesForPlayer.get(number);
    }

    public void printGames(){
        System.out.print(possibleGamesForPlayer.size()+ " ");
        System.out.println();
        for(Game p : possibleGamesForPlayer) {
            p.printGame();
        }
        //System.out.println();
    }

}
