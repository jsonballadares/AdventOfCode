package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Day2 {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<String>(); 
        try {
            String inputFilePath = System.getProperty("user.dir") + "/2020/Day2/input.txt";
            Scanner in = new Scanner(new File(inputFilePath));
            while(in.hasNextLine()){
                arr.add(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Answer is: " + solution(arr));
    }

    //how many passwords are valid
    public static int solution(List<String> arr){
        int validCount = 0;
        String lowerBound = "";
        String upperBound = "";
        String policyCharacter = "";
        String password = "";
        String[] splitArray = new String[3];
        int policyCharacterCount = 0;
        for(String str : arr){
            splitArray = str.split(" ");
            lowerBound = splitArray[0].split("-")[0];
            upperBound = splitArray[0].split("-")[1];
            policyCharacter = splitArray[1].replaceAll(":", "");
            password = splitArray[2];
            policyCharacterCount = characterCount(str, policyCharacter.charAt(0));
            if(policyCharacterCount >= Integer.parseInt(lowerBound) && policyCharacterCount <= Integer.parseInt(upperBound)){
                validCount++;
            }
            System.out.println(String.format("-------------\noriginal: %s\nlowerBound: %s\nupperbound: %s\npolicyCharacter: %s\npassword: %s\n-------------\n", str, lowerBound, upperBound, policyCharacter, password));
        }
        return validCount;
    }

    public static int characterCount(String str,char policyCharacter){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == policyCharacter){
                count++;
            }
        }
        return count;
    }
}
