package GameModes;

import java.util.ArrayList;

/**
 * Created by william on 2017-10-22.
 */
public class GameMode {

    // RPG Mode Properties
    private String gameMode;
    private String testFieldOne, testFieldTwo, testFieldThree;
    private int testIntOne;
    private ArrayList<String> arrayTestOne;

    public GameMode(String mode) {
        gameMode = mode;
    }

    public void RPGMode() {
        testFieldOne = "One";
        testFieldTwo = "Two";
        testFieldThree = "Three";
        testIntOne = 3;
        arrayTestOne = new ArrayList<String>();
        arrayTestOne.add("TestArrayElement");
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getTestFieldOne() {
        return testFieldOne;
    }

    public String getTestFieldTwo() {
        return testFieldTwo;
    }

    public String getTestFieldThree() {
        return testFieldThree;
    }

    public int getTestIntOne() {
        return testIntOne;
    }

    public ArrayList<String> getArrayTestOne() {
        return arrayTestOne;
    }
}
