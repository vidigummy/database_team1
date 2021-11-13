package database;

import java.util.ArrayList;
import java.util.HashMap;

public class D_Select extends Select{
    String filter_condition;
    D_Select(String s){
        result = new ArrayList<HashMap<String,Object>>();
        filter_condition = s;
        conn = new Connector();
    }
    public ArrayList<HashMap<String,Object>> Select_All(){
        if(isDname(filter_condition)){
            conn.connect();
            String query = "SELECT e.Name, e.Ssn,e.Bdate, e.Address, e.Sex, e.Supervisor, e.Salary, d.Dname" +
                    " FROM DEPARTMENT AS d LEFT JOIN (SELECT concat(e.Fname,\" \", e.Minit,\" \" ,e.Lname) AS Name," +
                    " e.Ssn,e.Bdate, e.Address, e.Sex,concat(s.Fname, \" \", s.Minit, \" \", s.Lname) AS Supervisor" +
                    ", e.Salary, e.Dno FROM EMPLOYEE AS e LEFT OUTER JOIN EMPLOYEE AS s ON e.Super_ssn = s.Ssn) AS e ON e.Dno = d.Dnumber"
                    +" WHERE d.Dname LIKE '"+ filter_condition+"'";
            System.out.println(query);
            try {
                result = conn.search(query);
                return result;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                conn.close();
            }
        }
        return null;
    }
    private static boolean isdigit(char a){
        int tmp = Character.getNumericValue(a);
        if(tmp<10 && tmp>=0){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isDname(String input){
        for(int i = 0; i < input.length(); i ++){
            char c = input.charAt(i);
            if(isdigit(c)){
                System.out.println("Invalid InputType");
                return false;
            }
        }
        return true;
    }
}
