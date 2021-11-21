package Task4;

import java.util.ArrayList;
import java.util.Collections;

public class DFA {
    private String[][] T;//Таблица переходов
    private ArrayList<String> oldEq;
    private ArrayList<String> newEq;

    public DFA(String[][] t, ArrayList<String> newEq) {
        T = t;
        this.newEq = newEq;
    }

    public void minimize(){
        oldEq = newEq;
        newEq = null;
        boolean flag = false;
        while (! flag){
            divide();
            flag = equals();
            oldEq = newEq;
            newEq = null;
        }
        for (int i = 0; i <oldEq.size(); i++) {
            System.out.print(oldEq.get(i)+ "  ");
        }
        for (int i = 0; i < T.length; i++) {
            System.out.println();
            for (int j = 0; j < T[0].length; j++) {
                System.out.print(T[i][j]+" ");
            }
        }
        System.out.println();
        System.out.println();

    }
    private boolean equals(){
        Collections.sort(oldEq);
        Collections.sort(newEq);
        return oldEq.equals(newEq);
    }
    private void divide(){
        newEq = new ArrayList<>();
        ArrayList<String> a = null;
        for (int i = 0; i < oldEq.size(); i++) {
            a = divideString(oldEq.get(i));
            for (int j = 0; j < a.size(); j++) {
                newEq.add(a.get(j));
            }
        }
    }

    private ArrayList<String> divideString(String s){
        String conc;
        String orig = s;
        ArrayList<String> arrayList = new ArrayList<>();
        if (orig.length()>1){
            for (int i = 0; i < orig.length() - 1; i++) {
                conc = "";
                conc = conc + orig.charAt(i);
                for (int j = i+1; j <orig.length(); j++) {
                    if (inOneGroup(delta(Character.toString(orig.charAt(i)), "a"), delta(Character.toString(orig.charAt(j)), "a")) && inOneGroup(delta(Character.toString(orig.charAt(i)), "b"), delta(Character.toString(orig.charAt(j)), "b"))){
                        conc = conc + orig.charAt(j);
                        orig = orig.substring(0, j) + orig.substring(j+1);
                        --j;
                    }
                }
                arrayList.add(conc);
            }
            boolean flag = false;
            for (String col: arrayList) {
                for (int i = 0; i < col.length(); i++) {
                    if (col.charAt(i) == orig.charAt(orig.length()-1)){
                        flag = flag || true;
                    }
                }
            }
            if (!flag){
                arrayList.add(Character.toString(orig.charAt(orig.length()-1)));
            }
        }
        else {
            arrayList.add(s);
        }
        return arrayList;
    }

    private boolean inOneGroup(String a, String b){
        boolean flag = false;
        boolean flagA = false;
        boolean flagB = false;
        for (String s : oldEq) {
            flag = false;
            flagA = false;
            flagB = false;
            for (int i = 0; i < s.length(); i++) {
                flagA = flagA || Character.toString(s.charAt(i)).equals(a);
                flagB = flagB || Character.toString(s.charAt(i)).equals(b);
            }
            flag = flag || (flagA&&flagB);
            if (flag)
                break;
        }
        return flag;
    }

    private String delta(String state, String symbol){
        int indexX;
        for (indexX = 1; indexX < 3; indexX++) {
            if (T[0][indexX].equals(symbol))
                break;
        }
        return T[Integer.parseInt(state)][indexX];
    }
}
