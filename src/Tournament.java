import java.util.ArrayList;

/**
 * Created by Iulkolog on 13.05.2016.
 */
public class Tournament {
    private static int count = 0;
    private int number;
    ArrayList<Game> tornament;
    Table table;

    public String story = "";

    public Tournament(){


        tornament = new ArrayList<>();
        table = new Table(16);
        number = ++count;

        story = Integer.toString(number);
    }
    public void addStory(String _story){
        story = String.format("%s-%s", story, _story);
    }

    public boolean addGame(Game g){
        tornament.add(g);
        boolean b = table.addGame(g);
        return b;
    }

    public int getNumberofTours(){
        return tornament.size();
    }

    public int getTournamentNumber(){
        return number;
    }

    public ArrayList<Game> getTours(){
        return tornament;
    }

    public int getCountGamesForOne(int player){
        return table.getPlayerGamesCount(player);
    }

    public boolean isFullTable(){
        return table.isFullTable();

    }

    public void printTournament(){
        System.out.println();
        System.out.println("Tour N" + getTournamentNumber() + " = " + getNumberofTours() + ";  " + story);
        for(Game g: tornament){
            g.printGame();
        }
    }
}
