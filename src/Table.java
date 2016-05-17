/**
 * Created by Iulkolog on 12.05.2016.
 */
public class Table {

    private int[][] table;
    //в +1 строке с каждой стороны храним количество игр для одного
    int playersCount;
    private static int countGamesOnePlayer = 15;

    public Table(int _playersCount) {
        playersCount = _playersCount;

        table = new int[playersCount + 1][playersCount + 1];
        for (int i = 0; i < playersCount + 1; i++) {
            for (int j = 0; j < playersCount; j++)
                table[i][j] = 0;
        }

    }

    public boolean addGame(Game g) {


        if (!addPairPlayer(g.getPlayers().get(0), g.getPlayers().get(1)))
            return false;
        if (!addPairPlayer(g.getPlayers().get(0), g.getPlayers().get(2)))
            return false;
        if (!addPairPlayer(g.getPlayers().get(0), g.getPlayers().get(3)))
            return false;
        if (!addPairPlayer(g.getPlayers().get(1), g.getPlayers().get(2)))
            return false;
        if (!addPairPlayer(g.getPlayers().get(1), g.getPlayers().get(3)))
            return false;
        if (!addPairPlayer(g.getPlayers().get(2), g.getPlayers().get(3)))
            return false;

        int id1, id2, id3, id4;
        id1 = g.getPlayers().get(0).getId() - 1;
        id2 = g.getPlayers().get(1).getId() - 1;
        id3 = g.getPlayers().get(2).getId() - 1;
        id4 = g.getPlayers().get(3).getId() - 1;

        table[id1][playersCount]++;
        table[id2][playersCount]++;
        table[id3][playersCount]++;
        table[id4][playersCount]++;
        table[playersCount][id1]++;
        table[playersCount][id2]++;
        table[playersCount][id3]++;
        table[playersCount][id4]++;

        if (table[id1][playersCount] <= countGamesOnePlayer &&  table[id2][playersCount] <= countGamesOnePlayer &&
                table[id3][playersCount] <= countGamesOnePlayer &&     table[id4][playersCount] <= countGamesOnePlayer)
            return true;
        return false;
    }

    public int getPlayerGamesCount2(int player){
        int countGamesForOne = 0;
        for(int i = 0; i < playersCount; i++){
            countGamesForOne += table[player][i];
        }
        return countGamesForOne;
    }

    public int getPlayerGamesCount(int player){
        return table[player][playersCount];
    }

    public boolean isFullTable(){
        int gamescount = 0;

        for(int i = 0; i < playersCount; i++){
            gamescount += table[i][playersCount];
        }
        if (gamescount == playersCount * countGamesOnePlayer)
            return true;
        return false;
    }

    private boolean addPairPlayer(Player p1, Player p2) {

        table[p1.getId() - 1][p2.getId() - 1]++;
        table[p2.getId() - 1][p1.getId() - 1]++;


        if (table[p2.getId() - 1][p1.getId() - 1] > 3) {

            //System.out.println("lll" + table[p2.getId() - 1][p1.getId() - 1]);
            return false;
        }
        return true;
    }

    public void printTable(){
        System.out.println();
        for(int i = 0; i <= playersCount; i++){
            for(int j = 0; j <= playersCount; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}