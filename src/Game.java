import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Iulkolog on 12.05.2016.
 */
public class Game {
    public static final int count = 4;

    private static int countGames = 0;
    private int number;
    private ArrayList<Player> gp;
    //TreeSet<Player> treePl;

    public Game(Player a, Player b, Player c, Player d){

        gp = new ArrayList<>();

        gp.add(a);
        gp.add(b);
        gp.add(c);
        gp.add(d);
        number = ++countGames;

        //treePl.addAll(gp);

    }

    public boolean containPlayer(Player p){
        return gp.contains(p);
    }

    public boolean containsPlayerLessThen(int p){
        return true;
    }

    public void printGame(){
        System.out.print(number + ": ");
        for(Player p : gp) {
            System.out.print(p.getId() + " ");
        }
        System.out.println();
    }

    public ArrayList<Player> getPlayers(){

        return gp;
    }



}
