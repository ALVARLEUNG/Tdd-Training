public class Poker {

    private String number;
    private String type;

    public Poker() {
    }

    public Poker(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean comparePoker(Poker poker) {
        if(Integer.parseInt(this.number) > Integer.parseInt(poker.getNumber())) return true;
        return false;
    }
}
