package io.github.fabriccommunity.everything.nothing;

import java.util.ArrayList;

public class NothingBuilder {
    public NothingBuilder withNothing() {
        return this;
    }

    public Nothing build() {
        // alocated alot of objecs so gc run
        ArrayList arrayList = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
	        arrayList.add(new int[1000]);
        }
        arrayList.clear();
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        System.gc(); // just in case
        return new Nothing();
    }
}
