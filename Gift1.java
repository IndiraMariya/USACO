import java.io.File;
import java.lang.String;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;


class Gift1 {
    static HashMap accounts = new HashMap<String, Integer>();
    
    public static void main(String[] arg) throws FileNotFoundException{
        load();
    }

    public static void load() throws FileNotFoundException {
        File input = new File("gift1.txt");
        Scanner s = new Scanner(input);
        String[] nameOrder;

        while (s.hasNextLine()) {
            int line = Integer.parseInt(s.nextLine());
            nameOrder = new String[line];
            for(int i = 0; i < line; i++) {
                String name = s.nextLine();
                accounts.put(name, 0);
                nameOrder[i] = name; 

            }
            

            for (int j = 0; j < line; j++) {
                String name = s.nextLine();
                String bankData = s.nextLine();   // gets account balance and people
                Scanner data = new Scanner(bankData); //seperates line using a new scanner
                data.useDelimiter(" ");
                int balance = data.nextInt();
                int people = data.nextInt();

                int reminder = 0; 
                for (int k = 0; k < people; k++) {
                    int give = balance/people;
                    reminder = balance % people;
                    String person = s.nextLine();
                    int currbal = (int)accounts.get(person);
                    accounts.put(person, currbal+give);
                    
                }

                accounts.put(name,(int)accounts.get(name)+reminder-balance);

                
            }
            
            for (int i = 0; i < nameOrder.length; i++) {
                System.out.println(nameOrder[i] + " "+ accounts.get(nameOrder[i]));
            }
        }

        


    }

}


