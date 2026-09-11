import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {

    static String draftAndRank(Player[] players) {

        int count = 0;

        // Count draftable players
        for (Player player : players) {

            if (Player.isDraftable(player.getMatchesPlayed()) ||
                    Player.isDraftable(
                            player.getMatchesPlayed(),
                            player.isInjured()
                    )) {

                count++;
            }
        }

        // Create array of exact required size
        Player[] draftable = new Player[count];

        int index = 0;

        // Store draftable players
        for (Player player : players) {

            if (Player.isDraftable(player.getMatchesPlayed()) ||
                    Player.isDraftable(
                            player.getMatchesPlayed(),
                            player.isInjured()
                    )) {

                draftable[index] = player;
                index++;
            }
        }

        // Sort using Player.compareTo()
        Arrays.sort(draftable);

        // Build output
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {

            result.append(i + 1)
                    .append(". ")
                    .append(draftable[i].getName());

            if (i < draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}