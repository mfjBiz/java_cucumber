package rocksissorspaper;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import rockscissorspaper.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockPaperScissorsTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class PatternTest {
        List<Pattern> patterns() {
            return Arrays.asList(
                    new Pattern(new Scissors(), new Rock(), "Win"),
                    new Pattern(new Scissors(), new Scissors(), "Draw"),
                    new Pattern(new Scissors(), new Paper(), "Lose"),
                    new Pattern(new Paper(), new Rock(), "Lose"),
                    new Pattern(new Paper(), new Scissors(), "Win"),
                    new Pattern(new Paper(), new Paper(), "Draw"),
                    new Pattern(new Rock(), new Rock(), "Draw"),
                    new Pattern(new Rock(), new Scissors(), "Lose"),
                    new Pattern(new Rock(), new Paper(), "Win")
            );
        }

        @ParameterizedTest
        @MethodSource("patterns")
        void game(Pattern pattern) {
            String actual = new Game(pattern.hand, pattern.cpuHand).exec();
            assertEquals(pattern.result, actual);
        }

        class Pattern {
            private final Hand cpuHand;
            private final Hand hand;
            private final String result;

            public Pattern(Hand cpuHand, Hand hand, String result) {
                this.cpuHand = cpuHand;
                this.hand = hand;
                this.result = result;
            }
            public String toString(){
                return "hand: " + hand.value() + " cpuHand: " + cpuHand.value();
            }
        }

    }
}
