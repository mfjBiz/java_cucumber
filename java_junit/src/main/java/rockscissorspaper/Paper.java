package rockscissorspaper;

public class Paper implements Hand {

    private Hand cpuHandObj;

    public Paper(Hand cpuHandObj) {
        this.cpuHandObj = cpuHandObj;
    }

    public Paper() {

    }

    @Override
    public boolean judge() {
        return cpuHandObj.comparePaper();
    }

    @Override
    public String value() {
        return "Paper";
    }

    @Override
    public boolean compareRock() {
        return true;
    }

    @Override
    public boolean compareScissors() {
        return false;
    }

    @Override
    public boolean comparePaper() {
        return false;
    }
}
