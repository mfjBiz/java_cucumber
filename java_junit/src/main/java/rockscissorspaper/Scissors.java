package rockscissorspaper;

public class Scissors implements Hand {
    private Hand cpuHand;

    public Scissors(Hand cpuHand) {
        this.cpuHand = cpuHand;
    }

    public Scissors() {

    }

    @Override
    public boolean judge() {
        return cpuHand.compareScissors();
    }

    @Override
    public String value() {
        return "Scissors";
    }

    @Override
    public boolean compareRock() {
        return false;
    }

    @Override
    public boolean compareScissors() {
        return false;
    }

    @Override
    public boolean comparePaper() {
        return true;
    }
}
