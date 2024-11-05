package shared;

import java.util.ArrayList;

public class Utility {
    
    public static <TDomain> int GetNextId(ArrayList<TDomain> table){
        return table.size() + 1;
    }

    public static void ClearConsole(){
        System.out.print("\033[H\033[2J");   
        System.out.flush();             
    }
}
