import java.util.HashMap;
import java.util.Map;

public class PokerUtil {

    public String playPokerGame(Player player1, Player player2) {

        PlayerDo playerDo1 = generatePlayerDo(player1);
        PlayerDo playerDo2 = generatePlayerDo(player2);

        if (playerDo1.getLevel() > playerDo2.getLevel()) return Constant.PLAYER1_WIN;
        else if (playerDo2.getLevel() > playerDo1.getLevel()) return Constant.PLAYER2_WIN;
        else {
            return comparePokers(playerDo1, playerDo2);
        }
    }

    private PlayerDo generatePlayerDo(Player player) {
        Map<String, Integer> playerPokerStatistics = PokerStatistics(player);
        PlayerDo playerDo = new PlayerDo();
        playerDo.setPlayer(player);
        playerDo.setPlayerPokerStatistics(playerPokerStatistics);

        if (isLevel2OrLevel3(playerPokerStatistics)==3) {
            playerDo.setLevel(3);
        }
        if (isLevel2OrLevel3(playerPokerStatistics)==2) {
            playerDo.setLevel(2);
        }
        return playerDo;
    }

    private int isLevel2OrLevel3(Map<String, Integer> playerPokerStatistics) {
        int number = 1;
        for (Map.Entry entry : playerPokerStatistics.entrySet()) {
            if (Integer.valueOf(entry.getValue().toString()) == 2) {
                number++;
            }
        }
        return number;
    }

    private String comparePokers(PlayerDo playerDo1, PlayerDo playerDo2) {
        Poker maxPoker1 = findMaxPoker(playerDo1);
        Poker maxPoker2 = findMaxPoker(playerDo2);
        return maxPoker1.comparePoker(maxPoker2);
    }

    private Poker findMaxPoker(PlayerDo playerDo) {
        switch (playerDo.getLevel()) {
            case 2:
                return selectMaxPokerByLevel2(playerDo);
            case 3:
                return selectMaxPokerByLevel3(playerDo);
            default:
                return selectMaxPokerByLevel1(playerDo.getPlayer());
        }
    }

    private Map<String, Integer> PokerStatistics(Player player) {
        Map<String, Integer> map = new HashMap<>();
        for (Poker poker : player.getPokers()) {
            Integer count = map.get(poker.getNumber());
            map.put(poker.getNumber(), (count == null) ? 1 : count + 1);
        }
        return map;
    }

    private Poker selectMaxPokerByLevel1(Player player) {
        Poker maxPoker = player.getPokers().get(0);
        for (int i = 0; i < player.getPokers().size(); i++) {
            if (Integer.valueOf(maxPoker.getNumber()) < Integer.valueOf(player.getPokers().get(i).getNumber())) {
                maxPoker = player.getPokers().get(i);
            }
        }
        return maxPoker;
    }

    private Poker selectMaxPokerByLevel2(PlayerDo playerDo) {
        String max = "0";
        Object key = new Object();
        for (Map.Entry entry : playerDo.getPlayerPokerStatistics().entrySet()) {
            if (Integer.valueOf(entry.getValue().toString()) > Integer.valueOf(max)) {
                max = entry.getValue().toString();
                key = entry.getKey();
            }
        }
        return new Poker(key.toString());
    }

    private Poker selectMaxPokerByLevel3(PlayerDo playerDo) {
        Object key = new Object();
        for (Map.Entry entry : playerDo.getPlayerPokerStatistics().entrySet()) {
            if (Integer.valueOf(entry.getValue()
                                        .toString()) == 2 && Integer.valueOf(key.toString()) < Integer.valueOf(entry.getKey()
                                                                                                                       .toString())) {
                key = entry.getKey();
            }
        }
        return new Poker(key.toString());
    }
}
