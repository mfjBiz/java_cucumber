package rockscissorspaper;

public class Rock implements Hand {

    private Hand otherHand;

    public Rock(Hand otherHand) {
        this.otherHand = otherHand;
    }

    public Rock() {

    }

    public boolean judge() {
        return otherHand.compareRock();
    }

    @Override
    public String value() {
        return "Rock";
    }

    @Override
    public boolean compareRock() {
        return false;
    }

    @Override
    public boolean compareScissors() {
        return true;
    }

    @Override
    public boolean comparePaper() {
        return false;
    }
}
