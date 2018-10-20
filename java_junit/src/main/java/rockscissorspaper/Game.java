package rockscissorspaper;

public class Game {
    private Hand cpuHand;
    private final Hand hand;

    public Game(String hand, ICpuHandFactory cpuHandFactory) {
        this.cpuHand = cpuHandFactory.create();
        this.hand = createHand(hand, cpuHand);
    }

    public String exec() {
        if (hand.value().equals(cpuHand.value())) {
            return "Draw";
        }
        if (hand.judge()) {
            return "Lose";
        }
        return "Win";
    }

    private Hand createHand(String hand, Hand cpuHand) {
        if (hand.equals("Rock")) {
            return new Rock(cpuHand);
        }
        if (hand.equals("Paper")) {
            return new Paper(cpuHand);
        }
        return new Scissors(cpuHand);
    }

}
