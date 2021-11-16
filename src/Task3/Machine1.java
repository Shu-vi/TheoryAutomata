package Task3;

public class Machine1 {

    public static void main(String[] args) {
        String currentState="1";
        String input="ADC";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            switch (currentState){
                case "1":
                    if (currentChar=='A'){
                        currentState="3";
                    }
                    else{
                        currentState = "2";
                    }
                    break;
                case "3":
                    if (currentChar=='A'||currentChar=='B'||currentChar=='D'){
                        currentState="4";
                    }
                    else{
                        currentState = "5";
                    }
                    break;
                case "4":
                    if (currentChar=='A'||currentChar=='C'){
                        currentState="6";
                    }
                    else{
                        currentState = "7";
                    }
                    break;
                case "6":
                    if (currentChar=='E'){
                        currentState="8";
                    }
                    else{
                        currentState = "9";
                    }
                    break;
                case "8":
                    currentState="9";
                    break;
            }
        }
        if (currentState.equals("8")){
            System.out.println("yes");
        }
        else
            System.out.println("no");
    }
}
