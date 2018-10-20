package rockscissorspaper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CpuHandFactory implements ICpuHandFactory {

        public Hand create() {
            List<Hand> list = Arrays.asList(new Rock(), new Paper(), new Scissors());
            Collections.shuffle(list);
            return list.get(0);
        }
}
