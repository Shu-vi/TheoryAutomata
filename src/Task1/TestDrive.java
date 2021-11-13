package Task1;

import java.util.Scanner;


public class TestDrive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s=s+'A';
        if(!isBigLetter(s, 0)) {
            System.out.println("No");
            System.exit(0);
        }

        int i = 1;
        int count=0;
        while(i<s.length()){
            if(isBigLetter(s, i)){
                if (count>=1 && count <=3)
                    count = 0;
                else {
                    System.out.println("No");
                    System.exit(0);
                }
            }
            else
                ++count;
            ++i;
        }
        System.out.println("Yes");
    }
    public static boolean isBigLetter(String s, int index){
        return (s.charAt(index)>='A') && (s.charAt(index)<='Z');
    }
}