package database;

import java.util.ArrayList;
import java.util.HashMap;

public class Se_Update extends Update{
    Se_Update(String input, ArrayList<HashMap<String,Object>> input_to_change){
        to_select_list = input_to_change;
        input_source = input;
        conn = new Connector();
    }
    public void Update_Sex(){
        conn.connect();
        for(HashMap<String,Object> employee : to_select_list){
            String Ssn = employee.get("Ssn").toString();
            String update_query = "UPDATE EMPLOYEE SET Sex = '"+input_source+"' WHERE Ssn = "+ Ssn;
            System.out.println(update_query);
            try {
                conn.modify(update_query);
            }catch (Exception e){
                System.out.println(e);
                e.printStackTrace();
            }finally {
                conn.close();
            }
        }
    }
}
