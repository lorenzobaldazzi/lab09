package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;
    private final List<String> historyStrings = new ArrayList<>();

    @Override
    public void setNextString(final String upComingString) {
        this.nextString = Objects.requireNonNull(upComingString);
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistoryStrings() {
        return new ArrayList<>(historyStrings);
    }

    @Override
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("No string set");
        }
        System.out.println(nextString); //NOPMD
        historyStrings.add(nextString);

    }
}
