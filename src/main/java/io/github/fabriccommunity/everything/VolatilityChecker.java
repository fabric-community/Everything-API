package io.github.fabriccommunity.everything;

public class VolatilityChecker {
    public static Volatility getVolatility(Object object) {
        return Volatility.NOT_ENOUGH;
    }

    public enum Volatility {
        VERY, NOT_ENOUGH
    }
}
