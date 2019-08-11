import java.util.Map;

public class PlayerDo {
    private Player player;
    private Map<String, Integer> playerPokerStatistics;
    private int level;

    public PlayerDo() {
        this.level = 1;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map<String, Integer> getPlayerPokerStatistics() {
        return playerPokerStatistics;
    }

    public void setPlayerPokerStatistics(Map<String, Integer> playerPokerStatistics) {
        this.playerPokerStatistics = playerPokerStatistics;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
