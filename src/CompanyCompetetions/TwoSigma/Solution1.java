package CompanyCompetetions.TwoSigma;

import java.util.Scanner;

/**
 * Created by Nikhi on 12/4/2016.
 * 7/11 passed. 4 failed
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int commandCount = sc.nextInt();
        if(1<= commandCount && commandCount <=10) {
            String[] commands = new String[commandCount];
            for (int i = 0; i < commandCount; i++) {
                String command = sc.next();
                if (1 <= command.length() && command.length() <= 2500) {
                    commands[i] = command;

                }
            }
            doesCircleExist(commands);
        }
    }
    static String[] doesCircleExist(String[] commands){
        //int threeRightCount = 0, threeLeftCount = 0;
        String[] doestCircleExists = new String[commands.length];
        for (int cmdIndex = 0; cmdIndex < commands.length; cmdIndex++) {
            //Given : Command Only have "G"(move forward), "R"(move right), "L"(move left)
            //Conclusion: if we have 3 consecutive right or left then we can form a circle
            String command = commands[cmdIndex];
            if(command.contains("RRR") || command.contains("LLL")
                    || (command.contains("L") && command.length()==1)
                    || (command.contains("R") && command.length()==1)
                    || command.matches("LL(G*)LL")
                    || command.matches("RR(G*)RR")
                    || command.matches("L(G*)L(G*)L")
                    || command.matches("R(G*)R(G*)R")

                    /*|| command.contains("GRGR") || command.contains("GLGL")*/){
                doestCircleExists[cmdIndex] = "YES";
                //System.out.println("YES");
            }else {
                doestCircleExists[cmdIndex] = "NO";
                //System.out.println("NO");
            }
        }
        return doestCircleExists;
    }
}
