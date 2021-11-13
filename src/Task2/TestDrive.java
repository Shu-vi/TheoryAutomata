package Task2;

import java.util.Arrays;

public class TestDrive {
    public static void main(String[] args) {
        String[][] table = {
                {"", "A", "B", "Y"},
                {"1","37","24","11"},
                {"2","34","34","11"},
                {"3","37","31","11"},
        };
        String input="ABYAYBBAYBYAYABYBA";
        //711714471417171144
        /*Задание 1. 8
        задание 2. 2
        Задание 3. 0
        хажание 4. false
        адание 5. 2
         */
        Machine machine = new Machine(table, '1', '4');
        machine.startMachine(input,"1");
        System.out.println(machine.getAnswer());
        System.out.println(machine.getTask1());
        System.out.println(machine.getTask2());
        System.out.println(machine.getTask3());
        System.out.println(machine.getTask4());
        System.out.println(machine.getTask5());
        System.out.println(machine.getTask6());
        System.out.println(machine.getTask7());
        Arrays.stream(machine.getTask8()).forEachOrdered(x -> System.out.print(x+" "));
    }
}
