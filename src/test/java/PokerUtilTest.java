import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PokerUtilTest {

    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_3c_vs_2d() {
        Poker poker1 = new Poker("3", "c");
        Player player1 = playerBuilder(poker1);

        Poker poker2 = new Poker("2", "d");
        Player player2 = playerBuilder(poker2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER1_WIN, result);
    }

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_2c_vs_3d() {
        Poker poker1 = new Poker("2", "c");
        Player player1 = playerBuilder(poker1);

        Poker poker2 = new Poker("3", "d");
        Player player2 = playerBuilder(poker2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    @Test
    public void should_return_a_draw_when_player1_vs_player2_given_3c_vs_3d() {
        Poker poker1 = new Poker("3", "c");
        Player player1 = playerBuilder(poker1);

        Poker poker2 = new Poker("3", "d");
        Player player2 = playerBuilder(poker2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.A_DRAW, result);
    }

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_jc_vs_qd() {
        Poker poker1 = new Poker("j", "c");
        Player player1 = playerBuilder(poker1);

        Poker poker2 = new Poker("q", "d");
        Player player2 = playerBuilder(poker2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_qc_vs_kd() {
        Poker poker1 = new Poker("q", "c");
        Player player1 = playerBuilder(poker1);

        Poker poker2 = new Poker("k", "d");
        Player player2 = playerBuilder(poker2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    private Player playerBuilder(Poker... poker) {
        Player player = new Player();
        player.setPokers(Arrays.asList(poker));
        return player;
    }

}
