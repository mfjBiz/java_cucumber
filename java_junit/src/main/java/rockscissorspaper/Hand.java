package rockscissorspaper;

public interface Hand {
    String value();

    boolean judge();

    boolean compareRock();

    boolean compareScissors();

    boolean comparePaper();
}
