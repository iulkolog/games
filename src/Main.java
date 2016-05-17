import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Iulkolog on 12.05.2016.
 */

public class Main {

    private static ArrayList<Tournament> tournaments;
    private static ArrayList<Player> gp;
    private static int countGamesforPwP = 3;
    private static int countGamesOnePlayer = 15;

    public static void main(String[] args) {
        // write your code here
        gp = new ArrayList<>();

        int playersCount = 16;
        for(int i = 0; i < playersCount; i++){
            gp.add(new Player());
        }
        int count = 0;
        ArrayList<Game> allPossibleGames = new ArrayList<>();
        for(int a = 1; a <= playersCount - Game.count + 1; a++){
            for(int b = a+1; b <= playersCount - Game.count + 2; b++){
                for(int c = b+1; c <= playersCount - Game.count + 3; c++){
                    for(int d = c+1; d <= playersCount - Game.count + 4; d++){
                        allPossibleGames.add(new Game(gp.get(a-1), gp.get(b-1), gp.get(c-1), gp.get(d-1)));

                        //allPossibleGames.get(count).printGame();
                        gp.get(a-1).addGame(allPossibleGames.get(count));
                        //gp.get(b-1).addGame(allPossibleGames.get(count));
                        //gp.get(c-1).addGame(allPossibleGames.get(count));
                        //gp.get(d-1).addGame(allPossibleGames.get(count));

                        count++;
                    }
                }
            }
        }

        /*for(int i = 0; i < playersCount; i++){
            System.out.println();
            System.out.print(gp.get(i).getId()+ " ");
            gp.get(i).printGames();
        }*/

        tournaments = new ArrayList<>();

        gameFinder(0);

        System.out.println("size = " + tournaments.size());


    }


    private static void gameFinder(int player){

        gameFinderForOnePlayer(0, 0, 1, null);


    }

    private static void gameFinderForOnePlayer(int player, int gameNumber, int start, Tournament oldTournament) {

        //Scanner in = new Scanner(System.in);
        //String s = in.nextLine();

        int gamesCount = gp.get(player).countPossibleGames();

        //System.out.println("pl = " + player + ", gameN = " + gameNumber + ", start = " + start + " gCountPLN " + gamesCount + "-N" + gp.get(player).getId());
        if ((start-1) < gamesCount) {
            for (int a = start; a < (gamesCount - (countGamesOnePlayer - gameNumber) + 1); a++) {

                //System.out.println("a = " + a);
                Tournament tournament = new Tournament();

                if (oldTournament != null) {
                    for (Game g : oldTournament.getTours()) {
                        tournament.addGame(g);
                    }
                    tournament.addStory(oldTournament.story);
                }
                //gp.get(player).getGameNumber(a - 1).printGame();
                if (!tournament.addGame(gp.get(player).getGameNumber(a - 1))) {
                    //System.out.print(" - fail");
                    //tournament.printTournament();
                    // tournament.table.printTable();
                    continue;
                } else {

                    //System.out.println("pl = " + player + ", gameN = " + gameNumber + ", start = " + start);

                    //System.out.print(" - nice");
                    //tournament.printTournament();
                    //tournament.table.printTable();

                    if (gameNumber + 1 < countGamesOnePlayer) {
                        //System.out.println("gN + 1 = " + (gameNumber + 1) + " start = " + (a + 1));
                        gameFinderForOnePlayer(player, gameNumber + 1, a + 1, tournament);
                    } else {
                        System.out.println("elsecase");

                        System.out.println("find tournament table");
                        tournaments.add(tournament);
                        tournament.printTournament();

                        /*if (player < gp.size() - 1) {

                            int k = player + 1;
                            while (k < (gp.size() - Game.count + 1)) {
                                gameNumber = tournament.getCountGamesForOne(k);
                                System.out.println(gameNumber);
                                if (gameNumber < countGamesOnePlayer) {
                                    System.out.println("newpl = " + k);
                                    gameFinderForOnePlayer(k, gameNumber, 1, tournament);
                                    break;
                                }
                                k++;

                            }
                        }*/

                        /*if (tournament.isFullTable()) {
                            System.out.println("find tournament table");
                            tournaments.add(tournament);
                            tournament.printTournament();
                        }*/

                    }
                }
            }
        }



    }

}
