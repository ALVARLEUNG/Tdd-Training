import java.util.HashMap;
import java.util.Map;

public class PokerUtil {

    public String playPokerGame(Player player1, Player player2) {

        Map<String, Integer> player1PokerStatistics = PokerStatistics(player1);
        int player1Level = 1;
        int player2Level = 1;
        if (player1PokerStatistics.size() < player1.getPokers().size()) {
            player1Level = 2;
        }
        Map<String, Integer> player2PokerStatistics = PokerStatistics(player2);
        if (player2PokerStatistics.size() < player2.getPokers().size()) {
            player2Level = 2;
        }

        if (player1Level > player2Level) return Constant.PLAYER1_WIN;
        else if (player2Level > player1Level) return Constant.PLAYER2_WIN;
        else {
            Poker maxPoker1 = selectMaxPoker(player1);
            Poker maxPoker2 = selectMaxPoker(player2);
            return maxPoker1.comparePoker(maxPoker2);
        }
    }

    private Map<String, Integer> PokerStatistics(Player player) {
        Map<String, Integer> map = new HashMap<>();
        for (Poker poker : player.getPokers()) {
            Integer count = map.get(poker);
            map.put(poker.getNumber(), (count == null) ? 1 : count + 1);
        }
        return map;
    }

    private Poker selectMaxPoker(Player player) {
        Poker maxPoker = player.getPokers().get(0);
        for (int i = 0; i < player.getPokers().size(); i++) {
            if (Integer.valueOf(maxPoker.getNumber()) < Integer.valueOf(player.getPokers().get(i).getNumber())) {
                maxPoker = player.getPokers().get(i);
            }
        }
        return maxPoker;
    }
}
