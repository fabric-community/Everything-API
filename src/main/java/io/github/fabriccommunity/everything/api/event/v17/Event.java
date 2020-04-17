package io.github.fabriccommunity.everything.api.event.v17;

import io.github.fabriccommunity.everything.api.annotation.BestInGame;
import io.github.fabriccommunity.everything.api.console.PrintManagerBuilder;

@BestInGame
public class Event {
    public final void cancel() {
        new PrintManagerBuilder().build().accept("C", "a" , "n", "c", "e", "l", "l", "i", "n", "g", " ", "e", "v", "e", "n", "t", "s", " ", "i", "s", " ", "f", "o", "r", " ", "l", "o", "s", "e", "r", "s", "", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "","", "", "", "", "");
    }

    public final boolean isCancellable() { return true; }
}
