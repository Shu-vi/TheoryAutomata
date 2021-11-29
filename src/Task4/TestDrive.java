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
        //String[][] t = {
//                {" ","a","b"},
//                {"1","3","2"},
//                {"2","3","1"},
//                {"3","4","4"},
//                {"4","8","5"},
//                {"5","5","5"},
//                {"6","6","6"},
//                {"7","8","5"},
//                {"8","5","6"}
//        };
        ArrayList<String> newEq = new ArrayList<>();
        newEq.add("356");
        newEq.add("12478");
        //newEq.add("56");
//        newEq.add("123478");
        DFA dfa = new DFA(t, newEq);
        dfa.minimize();
    }
}
