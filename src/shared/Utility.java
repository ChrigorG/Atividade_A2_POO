package shared;

import java.util.ArrayList;

public class Utility {
    
    public static <TDomain> int GetNextId(ArrayList<TDomain> table){
        return table.size() + 1;
    }
}
