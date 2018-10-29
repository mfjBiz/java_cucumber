package rockscissorspaper;

public class Game {
    private Hand cpuHand;
    private Hand hand;

    public Game(Hand hand, Hand cpuHand) {
        this.cpuHand = cpuHand;
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

    private Hand createHand(Hand hand, Hand cpuHand) {
        if (hand.value().equals("Rock")) {
            return new Rock(cpuHand);
        }
        if (hand.value().equals("Paper")) {
            return new Paper(cpuHand);
        }
        return new Scissors(cpuHand);
    }

}
