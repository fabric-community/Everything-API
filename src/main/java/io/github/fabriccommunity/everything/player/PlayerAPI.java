package io.github.fabriccommunity.everything.player;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class PlayerAPI {
    public static final List<String> players = new HashMap<String, String>().keySet().stream().collect(Collectors.toList());
    public static void registerDisallowedPlayer(String name) {
        players.add(name);
    }
}
