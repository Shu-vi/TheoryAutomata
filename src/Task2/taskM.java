package Task2;

public class taskM {
    public static void main(String[] args) {
        String answer = "011110100000011";
        char y1 = '1';
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
                    count = 0;
                    check = false;
                }
            }

        }
        if (count > max)
            max = count;
        System.out.println(max);
    }
}
