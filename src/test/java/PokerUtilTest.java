import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PokerUtilTest {

    // give two poker at base rule
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

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_kc_vs_ad() {
        Poker poker1 = new Poker("k", "c");
        Player player1 = playerBuilder(poker1);

        Poker poker2 = new Poker("a", "d");
        Player player2 = playerBuilder(poker2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    //give five poker at the first level
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_2h_3c_5s_9c_6d_vs_3h_5d_6c_7c_2d() {
        String[] number1 = {"2", "3", "5", "9", "6"};
        String[] type1 = {"h", "c", "s", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"3", "5", "6", "7", "2"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER1_WIN, result);
    }

    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_2h_3c_5s_9c_kd_vs_3h_5d_6c_7c_ad() {
        String[] number1 = {"2", "3", "5", "9", "k"};
        String[] type1 = {"h", "c", "s", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"3", "5", "6", "7", "a"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    //give five player at the second level@Test
    public void should_return_player2_win_when_player1_vs_player2_given_2h_3c_5s_9c_6d_vs_3h_3d_6c_7c_2d() {
        String[] number1 = {"2", "3", "5", "9", "6"};
        String[] type1 = {"h", "c", "s", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"3", "3", "6", "7", "2"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3h_3d_6c_7c_2d_vs_5h_5d_6c_7c_2d() {
        String[] number1 = {"3", "3", "6", "7", "2"};
        String[] type1 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"5", "5", "6", "7", "2"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    //give five player at the third level
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_3h_3d_6c_6c_2d_vs_5h_5d_6c_7c_2d() {
        String[] number1 = {"3", "3", "6", "6", "2"};
        String[] type1 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"5", "5", "6", "7", "2"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER1_WIN, result);
    }

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3h_3d_6c_6c_2d_vs_5h_5d_7c_7c_2d() {
        String[] number1 = {"3", "3", "6", "6", "2"};
        String[] type1 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"5", "5", "6", "7", "7"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    //give five player at the fourth level
    @Test
    public void should_return_player1_win_when_player1_vs_player2_given_3h_3d_3c_7c_2d_vs_5h_5d_7c_7c_2d() {
        String[] number1 = {"3", "3", "3", "7", "2"};
        String[] type1 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"5", "5", "7", "7", "2"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER1_WIN, result);
    }

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3h_3d_3c_7c_2d_vs_5h_5d_5c_7c_2d() {
        String[] number1 = {"3", "3", "3", "7", "2"};
        String[] type1 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"5", "5", "5", "7", "2"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    //give five player at the fifth level
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3h_3d_3c_7c_2d_vs_3h_4d_5c_6c_7d() {
        String[] number1 = {"3", "3", "3", "7", "2"};
        String[] type1 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"3", "4", "5", "6", "7"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3h_4d_5c_6c_7d_vs_4h_5d_6c_7c_8d() {
        String[] number1 = {"3", "4", "5", "6", "7"};
        String[] type1 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"4", "5", "6", "7", "8"};
        String[] type2 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    //give five player at the Level six
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3h_4d_5c_6c_7d_vs_2d_5d_6d_4d_8d() {
        String[] number1 = {"3", "4", "5", "6", "7"};
        String[] type1 = {"h", "d", "c", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"2", "5", "6", "4", "8"};
        String[] type2 = {"d", "d", "d", "d", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    @Test
    public void should_return_a_draw_win_when_player1_vs_player2_given_3c_4c_5c_6c_9c_vs_2d_5d_6d_4d_8d() {
        String[] number1 = {"3", "8", "5", "6", "9"};
        String[] type1 = {"c", "c", "c", "c", "c"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"2", "5", "6", "4", "8"};
        String[] type2 = {"d", "d", "d", "d", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.A_DRAW, result);
    }

    //give five player at the level seven
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_3c_4c_5c_6c_9c_vs_2d_2c_2d_4d_4d() {
        String[] number1 = {"3", "8", "5", "6", "9"};
        String[] type1 = {"c", "c", "c", "c", "c"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"2", "2", "2", "4", "4"};
        String[] type2 = {"d", "c", "d", "d", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_2d_2c_2h_3c_3d_vs_3d_3c_3h_2c_2d() {
        String[] number1 = {"2", "2", "2", "3", "3"};
        String[] type1 = {"d", "c", "h", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"3", "3", "3", "2", "2"};
        String[] type2 = {"d", "c", "h", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    //give five player at the level eight
//    given: [kd kc kh 3c 3d] VS [3d 3c 3h 3c 2d] -> then: [3d 3c 3h 3c 2d] win
//    given: [3d 3c 3h 3c 2d] VS [4d 4c 4h 4c 2d] -> then: [4d 4c 4h 4c 2d] win
    @Test
    public void should_return_player2_win_when_player1_vs_player2_given_kd_kc_kh_3c_3d_vs_3d_3c_3h_3c_2d() {
        String[] number1 = {"k", "k", "k", "3", "3"};
        String[] type1 = {"d", "c", "h", "c", "d"};
        List<Poker> pokers1 = pokersBuilder(number1, type1);
        Player player1 = new Player(pokers1);

        String[] number2 = {"3", "3", "3", "3", "2"};
        String[] type2 = {"d", "c", "h", "c", "d"};
        List<Poker> pokers2 = pokersBuilder(number2, type2);
        Player player2 = new Player(pokers2);

        PokerUtil pokerUtil = new PokerUtil();
        String result = pokerUtil.playPokerGame(player1, player2);

        Assert.assertEquals(Constant.PLAYER2_WIN, result);
    }

    private List<Poker> pokersBuilder(String[] number, String[] type) {
        List<Poker> pokers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pokers.add(new Poker(number[i], type[i]));
        }
        return pokers;
    }

    private Player playerBuilder(Poker... poker) {
        Player player = new Player();
        player.setPokers(Arrays.asList(poker));
        return player;
    }

}
