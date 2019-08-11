import java.util.*;
import java.util.stream.Collectors;

public class PokerUtil {

    public String playPokerGame(Player player1, Player player2) {
        PlayerDo playerDo1 = generatePlayerDo(player1);
        PlayerDo playerDo2 = generatePlayerDo(player2);

        if (playerDo1.getLevel() > playerDo2.getLevel()) return Constant.PLAYER1_WIN;
        else if (playerDo2.getLevel() > playerDo1.getLevel()) return Constant.PLAYER2_WIN;
        else return comparePokers(playerDo1, playerDo2);
    }

    private PlayerDo generatePlayerDo(Player player) {
        Map<String, Integer> playerPokerStatistics = PokerStatistics(player);
        PlayerDo playerDo = new PlayerDo();
        playerDo.setPlayer(player);
        playerDo.setPlayerPokerStatistics(playerPokerStatistics);
        return judgeLevel(player, playerPokerStatistics, playerDo);
    }

    private PlayerDo judgeLevel(Player player, Map<String, Integer> playerPokerStatistics, PlayerDo playerDo) {
        if (isArrayInSorted(player.getPokers()
                                    .stream()
                                    .map(item -> Integer.parseInt(item.getNumber()))
                                    .collect(Collectors.toList()), player.getPokers().size()) == 1 && isLevel6(player.getPokers())) {
            playerDo.setLevel(9);
            return playerDo;
        }
        if (isLevel7(playerPokerStatistics)) {
            playerDo.setLevel(7);
            return playerDo;
        }
        if (player.getPokers().size() > 1 && isLevel6(player.getPokers())) {
            playerDo.setLevel(6);
            return playerDo;
        }
        if (isArrayInSorted(player.getPokers()
                                    .stream()
                                    .map(item -> Integer.parseInt(item.getNumber()))
                                    .collect(Collectors.toList()), player.getPokers().size()) == 1) {
            playerDo.setLevel(5);
            return playerDo;
        } else {
            switch (judgeBeforeFourLevels(playerPokerStatistics)) {
                case 2:
                    playerDo.setLevel(2);
                    break;
                case 3:
                    playerDo.setLevel(3);
                    break;
                case 4:
                    playerDo.setLevel(4);
                    break;
                case 8:
                    playerDo.setLevel(8);
                    break;
            }
        }
        return playerDo;

    }

    private boolean isLevel7(Map<String, Integer> playerPokerStatistics) {
        boolean has2 = false;
        boolean has3 = false;
        for (Map.Entry entry : playerPokerStatistics.entrySet()) {
            if (Integer.valueOf(entry.getValue().toString()) == 3) {
                has3 = true;
            }
            if (Integer.valueOf(entry.getValue().toString()) == 2) {
                has2 = true;
            }
        }
        return has2 && has3;
    }

    private boolean isLevel6(List<Poker> pokers) {
        int count = 0;
        String target = pokers.get(0).getType();
        for (Poker poker : pokers) {
            if (poker.getType().equals(target)) {
                count++;
            }
        }
        return count == pokers.size() ? true : false;
    }

    private int judgeBeforeFourLevels(Map<String, Integer> playerPokerStatistics) {
        int number = 1;
        for (Map.Entry entry : playerPokerStatistics.entrySet()) {
            if (Integer.valueOf(entry.getValue().toString()) == 2) {
                number++;
            } else if (Integer.valueOf(entry.getValue().toString()) == 3) {
                return 4;
            } else if (Integer.valueOf(entry.getValue().toString()) == 4) {
                return 8;
            }
        }
        return number;
    }

    private String comparePokers(PlayerDo playerDo1, PlayerDo playerDo2) {
        if (playerDo1.getLevel() == 6 && playerDo2.getLevel() == 6) {
            return Constant.A_DRAW;
        }
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
            case 4:
                return selectMaxPokerByLevel2(playerDo);
            case 7:
                return selectMaxPokerByLevel2(playerDo);
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
        List<Object> keys = new ArrayList<>();
        for (Map.Entry entry : playerDo.getPlayerPokerStatistics().entrySet()) {
            if (Integer.valueOf(entry.getValue().toString()) == 2) {
                keys.add(entry.getKey());
            }
        }
        return new Poker(String.valueOf(keys.stream()
                                                .mapToInt(item -> Integer.valueOf(String.valueOf(item)))
                                                .max()
                                                .getAsInt()));
    }

    private static int isArrayInSorted(List<Integer> arr, int index) {
        if (index == 1) return 1;
        return (arr.get(index - 1) <= arr.get(index - 2) ? 0 : isArrayInSorted(arr, index - 1));
    }
}
