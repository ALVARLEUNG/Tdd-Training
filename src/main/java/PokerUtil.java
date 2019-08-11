public class PokerUtil {

    public String playPokerGame(Player player1, Player player2) {
        boolean result = player1.getPokers().get(0).comparePoker(player2.getPokers().get(0));
        if (result) return Constant.PLAYER1_WIN;
        return null;
    }
}
