package Task3;

public class Machine2 {
    public static void main(String[] args) {
        String currentState="1";
        String input="ACACACCBAA";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            switch (currentState){
                case "1":
                    if (currentChar=='B'){
                        currentState="2";
                    }
                    else{
                        currentState = "3";
                    }
                    break;
                case "3":
                    if (currentChar=='A'||currentChar=='C'){
                        currentState="1";
                    }
                    else{
                        currentState = "4";
                    }
                    break;
                case "4":
                    if (currentChar=='A'||currentChar=='C'){
                        currentState="5";
                    }
                    else{
                        currentState = "6";
                    }
                    break;
                case "5":
                    currentState="6";
                    break;
            }
        }
        if (currentState.equals("5")){
            System.out.println("yes");
        }
        else
            System.out.println("no");
    }
}
