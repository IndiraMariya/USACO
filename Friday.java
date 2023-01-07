import java.lang.String;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Friday {
    public static void main(String[] arg) throws FileNotFoundException {
        
        File input = new File("friday.txt");
        Scanner s = new Scanner(input);
        int years = s.nextInt();
        int endyear = 1900 + years-1;
        int[] days = new int[7];
        int day = 5; 
        
        for (int i = 1900; i <= endyear; i++){
            int date = 13;

            for (int m = 1; m <= 12; m++) {
                
                if (leapYear(i) && m == 2) {
                    date+=29;
                    day = day + (29 % 7);

                }

                if (m == 2) {
                    date+=28;
                    day = day + (28 % 7);

                }
                
                if (m == 1 || m == 3 || m == 5|| m ==7|| m ==8|| m ==10|| m ==12) {
                    date += 31;
                    day = day + (31 % 7);
    
                }

                else {
                    date += 30;
                    day = day + (30 % 7);
                }
                day = day%7;
                days[day] += 1;
            }

        }

        System.out.println(Arrays.toString(days));

    }

    public static boolean leapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                return false;
            }
            return true;
        }

        return false;
    }


}
