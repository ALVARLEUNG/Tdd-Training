public class PokerUtil {

    public String playPokerGame(Player player1, Player player2) {
        return player1.getPokers().get(0).comparePoker(player2.getPokers().get(0));
    }
}
