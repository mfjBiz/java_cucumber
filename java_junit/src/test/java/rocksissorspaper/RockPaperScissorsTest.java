package rocksissorspaper;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import rockscissorspaper.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockPaperScissorsTest {

    @Test
    void game() {
        String actual = new Game("Rock", new CpuHandFactory()).exec();
        assertThat(actual, isOneOf("Win", "Lose", "Draw"));
        assertThat(actual, isOneOf("Win", "Lose", "Draw"));
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class PatternTest {
        List<Pattern> patterns() {
            return Arrays.asList(
                    new Pattern(new Scissors(), "Rock", "Win"),
                    new Pattern(new Scissors(), "Scissors", "Draw"),
                    new Pattern(new Scissors(), "Paper", "Lose"),
                    new Pattern(new Paper(), "Rock", "Lose"),
                    new Pattern(new Paper(), "Scissors", "Win"),
                    new Pattern(new Paper(), "Paper", "Draw"),
                    new Pattern(new Rock(), "Rock", "Draw"),
                    new Pattern(new Rock(), "Scissors", "Lose"),
                    new Pattern(new Rock(), "Paper", "Win")
            );
        }

        @ParameterizedTest
        @MethodSource("patterns")
        void gameWithFake(Pattern pattern) {
            FakeHandFactory cpuHandFactory = new FakeHandFactory(pattern.cpuHand);
            String actual = new Game(pattern.hand, cpuHandFactory).exec();
            assertEquals(pattern.result, actual);
            assertEquals(1, cpuHandFactory.callCountOfCreate());
        }

        class Pattern {
            private final Hand cpuHand;
            private final String hand;
            private final String result;

            public Pattern(Hand cpuHand, String hand, String result) {
                this.cpuHand = cpuHand;
                this.hand = hand;
                this.result = result;
            }

            public String toString(){
                return "hand: " + hand + " cpuHand: " + cpuHand.value();
            }
        }

        class FakeHandFactory implements ICpuHandFactory {
            private Hand cpuHand;
            private int callCountOfCreate;

            public FakeHandFactory(Hand cpuHand) {
                this.cpuHand = cpuHand;
            }

            @Override
            public Hand create() {
                callCountOfCreate++;
                return cpuHand;
            }

            public int callCountOfCreate() {
                return callCountOfCreate;
            }
        }
    }
}
