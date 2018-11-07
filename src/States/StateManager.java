package States;

/**
 * Created by William on 2016-04-27.
 */
public class StateManager {

    private static EntityState currentState = null;

    public static void setCurrentState(EntityState state) {
        currentState = state;

    }

    public static EntityState getCurrentState() {
        return currentState;
    }

}
