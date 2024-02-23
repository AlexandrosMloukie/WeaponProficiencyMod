package net.amloukie.wpmod.client;

public class ClientBowData {
    private static float bowPull;

    public static void set(float f) {
        ClientBowData.bowPull = f;
    }

    public static float getBowPull() {
        return bowPull;
    }
}
