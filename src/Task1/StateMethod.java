package Task1;

import java.util.Scanner;

public class StateMethod {
    public static void main(String[] args) {
        States state = States.Zero;
        Answer answer = Answer.Yes;
        Scanner scanner = new Scanner(System.in);
        String enter;
        enter = scanner.nextLine();
        int i = 0;
        while (i<enter.length()){
            switch (state){
                case Zero:
                    if (isBigLetter(enter.charAt(i))){
                        state = States.One;
                        answer = Answer.No;
                    }
                    else{
                        state = States.Four;
                        answer = Answer.No;
                    }
                    break;
                case One:
                    if (isBigLetter(enter.charAt(i))){
                        state = States.Five;
                        answer = Answer.No;
                    }
                    else{
                        state = States.Two;
                        answer = Answer.Yes;
                    }
                    break;
                case Two:
                    if (isBigLetter(enter.charAt(i))){
                        state = States.One;
                        answer = Answer.No;
                    }
                    else{
                        state = States.Three;
                        answer = Answer.Yes;
                    }
                    break;
                case Three:
                    if (isBigLetter(enter.charAt(i))){
                        state = States.One;
                        answer = Answer.No;
                    }
                    else{
                        state = States.Zero;
                        answer = Answer.Yes;
                    }
                    break;
                case Four:
                    if (isBigLetter(enter.charAt(i))){
                        state = States.Four;
                        answer = Answer.No;
                    }
                    else{
                        state = States.Four;
                        answer = Answer.No;
                    }
                    break;
                case Five:
                    if (isBigLetter(enter.charAt(i))){
                        state = States.Five;
                        answer = Answer.No;
                    }
                    else{
                        state = States.Five;
                        answer = Answer.No;
                    }
                    break;
            }
            i++;
        }
        System.out.println(answer);
    }
    public static boolean isBigLetter(char c){
        return (c>='A') && (c<='Z');
    }
}
