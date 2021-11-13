package Task1;

import java.util.Scanner;

public class TabularMethod {
    public static void main(String[] args) {
        char[][][] table = {
                {{' ',' '}, {'a', ' '}, {'A', ' '}},
                {{'0',' '}, {'4', 'N'}, {'1', 'N'}},
                {{'1',' '}, {'2', 'Y'}, {'5', 'N'}},
                {{'2',' '}, {'3', 'Y'}, {'1', 'N'}},
                {{'3',' '}, {'0', 'Y'}, {'1', 'N'}},
                {{'4',' '}, {'4', 'N'}, {'4', 'N'}},
                {{'5',' '}, {'5', 'N'}, {'5', 'N'}},
        };
        char state='0', answer='-';
        Scanner scanner = new Scanner(System.in);
        char enter = '-';

        while (enter!='0') {
            enter = scanner.nextLine().charAt(0);
            if (isBigLetter(enter)){
                answer = table[(int)state-(int) '0'+1][2][1];
                state = table[(int)state-(int) '0'+1][2][0];
            }
            else{
                if (enter!='0') {
                    answer = table[(int) state - (int) '0' + 1][1][1];
                    state = table[(int) state - (int) '0' + 1][1][0];
                }
            }
        }
        System.out.println(answer);
    }
    public static boolean isBigLetter(char c){
        return (c>='A') && (c<='Z');
    }
}
