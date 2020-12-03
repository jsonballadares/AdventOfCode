package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Before you leave, the Elves in accounting just need you to fix your expense
 * report (your puzzle input); apparently, something isn't quite adding up.
 * Specifically, they need you to find the two entries that sum to 2020 and then
 * multiply those two numbers together. For example, suppose your expense report
 * contained the following:
 * 
 * 1721 979 366 299 675 1456
 * 
 * In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying
 * them together produces 1721 * 299 = 514579, so the correct answer is 514579.
 * Of course, your expense report is much larger. Find the two entries that sum
 * to 2020; what do you get if you multiply them together?
 */

public class Day1 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>(); 
        try {
            String inputFilePath = System.getProperty("user.dir") + "/2020/Day1/input.txt";
            Scanner in = new Scanner(new File(inputFilePath));
            while(in.hasNextInt()){
                arr.add(in.nextInt());
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Answer is: " + solution(arr));

    }
    
    public static int solution(List<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < arr.size(); j++){
                if(arr.get(i) + arr.get(j) == 2020){
                    return arr.get(i).intValue() * arr.get(j).intValue();
                }
            }
        }
        return -1;
    }
}