public class PokerUtil {

    public String playPokerGame(Player player1, Player player2) {
        Poker maxPoker1 = selectMaxPoker(player1);
        Poker maxPoker2 = selectMaxPoker(player2);

        return maxPoker1.comparePoker(maxPoker2);
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
