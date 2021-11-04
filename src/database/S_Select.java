package database;

import java.util.ArrayList;
import java.util.HashMap;

public class S_Select extends Select{
    String filter_condition;

    S_Select(String a){
        filter_condition = a;
        result = null;
    }
    public ArrayList<HashMap<String,Object>> Select_All(){
        conn.connect();
        ArrayList<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>>();
        String query = "SELECT e.Name, e.Ssn, e.Address, e.Sex, e.Supervisor, e.Salary, d.Dname" +
                " FROM DEPARTMENT AS d LEFT JOIN (SELECT concat(e.Fname,\" \", e.Minit,\" \" ,e.Lname) AS Name," +
                " e.Ssn, e.Address, e.Sex,concat(s.Fname, \" \", s.Minit, \" \", s.Lname) AS Supervisor" +
                ", e.Salary, e.Dno FROM EMPLOYEE AS e LEFT OUTER JOIN EMPLOYEE AS s ON e.Super_ssn = s.Ssn) AS e ON e.Dno = d.Dnumber"
                +"WHERE e.Salary > "+filter_condition;
        try {
            result = conn.search(query);
            conn.close();
            return result;
        }catch (Exception e){
            conn.close();
            e.printStackTrace();
        }
        conn.close();
        return null;
    }
}
