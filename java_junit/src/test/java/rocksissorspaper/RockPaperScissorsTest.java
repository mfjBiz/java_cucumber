package rocksissorspaper;

import org.junit.jupiter.api.Test;
import rockscissorspaper.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockPaperScissorsTest {

    @Test
    void game() {
        List<Pattern> patterns = Arrays.asList(
                new Pattern("1", new Scissors(), "Rock", "Win"),
                new Pattern("2", new Scissors(), "Scissors", "Draw"),
                new Pattern("3", new Scissors(), "Paper", "Lose"),
                new Pattern("4", new Paper(), "Rock", "Lose"),
                new Pattern("5", new Paper(), "Scissors", "Win"),
                new Pattern("6", new Paper(), "Paper", "Draw"),
                new Pattern("7", new Rock(), "Rock", "Draw"),
                new Pattern("8", new Rock(), "Scissors", "Lose"),
                new Pattern("9", new Rock(), "Paper", "Win")
        );
        patterns.forEach(pattern -> {
            String actual = new Game(pattern.hand, new FakeHandFactory(pattern.cpuHand)).exec();
            assertEquals(pattern.result, actual, pattern.num);
        });
    }

    private class Pattern {
        private String num;
        private final Hand cpuHand;
        private final String hand;
        private final String result;

        public Pattern(String num, Hand cpuHand, String hand, String result) {
            this.num = num;
            this.cpuHand = cpuHand;
            this.hand = hand;
            this.result = result;
        }
    }

    private class FakeHandFactory implements ICpuHandFactory {
        private Hand cpuHand;

        public FakeHandFactory(Hand cpuHand) {
            this.cpuHand = cpuHand;
        }

        @Override
        public Hand create() {
            return cpuHand;
        }
    }
}
