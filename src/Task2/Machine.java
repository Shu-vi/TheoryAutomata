package Task2;

public class Machine {
    private String[][] table;
    private int count3;
    private char y1;
    private  char y2;
    private String answer;
    private int t;//такт автомата для задачи
    private boolean state;

    public Machine(String[][] table, char y1, char y2) {
        this.table = table;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void startMachine(String input, String startState){
        this.answer="";
        this.count3 = 0;
        this.t = 0;
        boolean s1 = false, s2 = false, s3 = false;
        s1 = s1 || startState.equals("1");
        s2 = s2 || startState.equals("2");
        s3 = s3 || startState.equals("3");
        for (int i = 0; i < input.length(); i++) {
            int index = 1;
            while (index < table[0].length && input.charAt(i)!=table[0][index].charAt(0))
                index++;
            this.answer += table[Integer.parseInt(startState)][index].charAt(1);
            task3(startState, index);
            task6(startState, i+1);
            startState = Character.toString(table[Integer.parseInt(startState)][index].charAt(0));
            s1 = s1 || startState.equals("1");
            s2 = s2 || startState.equals("2");
            s3 = s3 || startState.equals("3");
        }
        state = s1 && s2 && s3;
    }

    public int getTask1(){
        int count = 0;
        for (int i = 0; i < this.answer.length(); i++) {
            if (this.answer.charAt(i)==this.y1)
                count++;
        }
        return count;
    }

    public int getTask2(){
        int count = 0;
        String y="";
        y=y+this.y1+this.y2+this.y2;
        for (int i = 0; i < this.answer.length()-2; i++) {
            if (this.answer.substring(i, i+3).equals(y))
                count++;
        }
        return count;
    }

    private void task3(String startState, int index){
        if (startState.equals("1")&& answer.charAt(answer.length()-1)==y1)
            this.count3++;
    }
    public int getTask3(){
        return this.count3;
    }

    public boolean getTask4(){
        if (answer.length()>=30){
            return answer.charAt(9) == y1 || answer.charAt(19) == y1 || answer.charAt(29) == y1;
        }
        else{
            if (answer.length()>=20){
                return answer.charAt(9) == y1 || answer.charAt(19) == y1;
            }
            else{
                return answer.length()>=10 && answer.charAt(9) == y1;
            }
        }
    }

    public int getTask5(){
        int max = 0;
        int count = 0;
        boolean check = false;//проверяем, был ли на предыдущем символе нужный нам символ?
        for (int i = 0; i < answer.length(); i++) {
            if (check && answer.charAt(i)==y1){
                count++;
            }
            else{
                if (answer.charAt(i)==y1) {
                    check = true;
                    count++;
                }
                else{
                    if (count > max)
                        max = count;
                    check = false;
                    count = 0;
                }
            }

        }
        if (count > max)
            max = count;
        return max;
    }

    public void task6(String state, int t){
        if (this.t == 0 && state.equals("2")&&answer.charAt(t-1)==y2)
            this.t = t;
    }

    public int getTask6(){
        return t;
    }

    public boolean getTask7(){
        boolean y1 = false, y2 = false, y3 = false;
        for (int i = 0; i < answer.length(); i++) {
            y1 = y1 || answer.charAt(i) == '1';
            y2 = y2 || answer.charAt(i) == '4';
            y3 = y3 || answer.charAt(i) == '7';
        }
        boolean y = y1&&y2&&y3;
        return state && y;
    }

    public int[] getTask8(){
        int[] Y = new int[3];
        int c1 = 0, c2 = 0, c3 = 0;
        for (int i = 0; i < this.answer.length(); i++) {
            if (this.answer.charAt(i)=='1')
                c1++;
            if (this.answer.charAt(i)=='4')
                c2++;
            if (this.answer.charAt(i)=='7')
                c3++;
        }
        Y[0] = c1;
        Y[1] = c2;
        Y[2] = c3;
        return Y;
    }

    public String getAnswer() {
        return answer;
    }
}
