package Task4;

import java.util.ArrayList;

public class TestDrive {
    public static void main(String[] args) {
        String[][] t = {
                {" ","a","b"},
                {"1","2","3"},
                {"2","2","3"},
                {"3","4","1"},
                {"4","2","5"},
                {"5","6","7"},
                {"6","6","6"},
                {"7","6","8"},
                {"8","6","8"}
        };
        ArrayList<String> newEq = new ArrayList<>();
        newEq.add("356");
        newEq.add("12478");
        DFA dfa = new DFA(t, newEq);
        dfa.minimize();
    }
}
