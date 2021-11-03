package database;

import java.util.ArrayList;
import java.util.HashMap;

public class A_Select extends Select{
    //1번에 대한 메써드
    //수정 필요함
    ArrayList<HashMap<String,Object>> Select_All(){
        result = null;
        String query = "SELECT * FROM EMPLOYEE";
        try {
            ArrayList<HashMap<String,Object>> result = conn.search(query);
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
