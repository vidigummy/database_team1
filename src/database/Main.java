package database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main {

    private static boolean SalaryValdate(String Salary){
        Float a = Float.parseFloat(Salary);
        if(a.toString().length() > 10) return false;
        return true;
    }

    private static boolean BdateValidateion(String Bdate){
        String[] arr = Bdate.split("-");
        if(arr.length != 3) return false;
        for(String row : arr){
            for(int i = 0; i < row.length(); i++){
                char tmp = row.charAt(i);
                if(!Character.isDigit(tmp)) return false;
            }
        }
        return true;
    }
    private static boolean InsertValidation(String Fname, String Minit, String Lname, String Ssn, String Bdate, String Adress, String Sex, String Salary, String Super_Ssn, String Department){
        if(Fname.length()==0 || Fname.length() > 15){
            System.out.println("invalide fname");
            return false;
        }
        if(Minit.length()==0 || Minit.length() > 1){
            System.out.println("invalide mname");
            return false;
        }
        if(Lname.length() ==0 || Lname.length() >15){
            System.out.println("invalide lname");
            return false;
        }
        if(Ssn.length() == 0 || Ssn.length() > 9){
            System.out.println("invalide Ssn");
            return false;
        }
        else{
            //중복 Ssn은 안된다.
            Connector conn = new Connector();
            conn.connect();
            ArrayList<HashMap<String, Object>> rs = new ArrayList<HashMap<String, Object>>();
            rs = conn.search("SELECT COUNT(*) FROM EMPLOYEE WHERE Ssn LIKE '"+Ssn+"'");
            conn.close();
            for(HashMap<String, Object> row : rs){
                if(row.get("COUNT(*)").toString().equals("1")){
                    System.out.println("Duplication Ssn");
                    return false;
                }
            }
        }
        //Bdate Validateion
        if(!BdateValidateion(Bdate)) {
            System.out.println("invalid Bdate");
            return false;
        }
        if(Adress.length()==0 || Adress.length()>30){
            System.out.println("invalide Adress");
            return false;
        }
        if(!Sex.equals("M") && !Sex.equals("F")){
            System.out.println("invalide SEX");
            return false;
        }
        if(Salary.length() <= 0 || SalaryValdate(Salary) == false){
            System.out.println("invalide Salary");
            return false;
        }

        //superSns
        if(Super_Ssn.length()>9) return false;
        else if(Super_Ssn.length()!=0){
            Connector conn = new Connector();
            conn.connect();
            ArrayList<HashMap<String, Object>> rs = new ArrayList<HashMap<String, Object>>();
            rs = conn.search("SELECT COUNT(*) FROM EMPLOYEE WHERE Ssn LIKE '"+Super_Ssn+"'");
            conn.close();
            for(HashMap<String, Object> row : rs){
                if(row.get("COUNT(*)").toString().equals("0")){
                    System.out.println("No Ssn");
                    return false;
                }
            }
        }

        Connector conn = new Connector();
        conn.connect();
        ArrayList<HashMap<String, Object>> rs = new ArrayList<HashMap<String, Object>>();
        rs = conn.search("SELECT COUNT(*) FROM DEPARTMENT WHERE Dnumber = "+Department);
        conn.close();
        for(HashMap<String, Object> row : rs){
            if(row.get("COUNT(*)").toString().equals("0")){
                System.out.println("No Department");
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
//모든 EMPLOYEE의 정보를 가져오는 법
//        ArrayList<String> test_select = new ArrayList<String>();
//        test_select.add("Name");
//        test_select.add("Ssn");
//        test_select.add("Bdate");
//        test_select.add("Address");
//        test_select.add("Sex");
//        test_select.add("Supervisor");
//        test_select.add("Salary");
//        test_select.add("Department");
//        Sellect_filter all = new Sellect_filter("","",test_select);
//        // 성별 SELECT
//        Sellect_filter Sex = new Sellect_filter("성별","F", test_select);
////        연봉 SELECT
//        Sellect_filter Salary = new Sellect_filter("월급",1000, test_select);
//        부서
//        Sellect_filter Depart = new Sellect_filter("부서","Researc0h", test_select);
//        //생일
//        Sellect_filter Birthday = new Sellect_filter("생일","07", test_select);
//        //부하직원
//        Sellect_filter Supvervising = new Sellect_filter("부하직원","987654321", test_select);
//        Insert 테스트 코드 돈을 많이 버는 vidigummy를 만드는 방법 다른 방법 있으려나?
//        Fname, Middle_name, Lname, Ssn, Bdate, Address, Sex, Salary, Super_ssn, Dno 순으로 (모두 다 string이 편하다)
//        E_Insert insert_test = new E_Insert("Vidi", "R", "Gummy", "15125021", "1996-07-22", "SEOUL-GangDong", "M", "100000.00", "NULL", "1");

//  Delete Employee의 경우, 삭제를 하려면 객체를 가지고 있어야 한다.(당연쓰) So, Test Code를 Sellect_filter의 연봉 Select에 넣어놨으니 참고 바란다.
        // 원시적인 방법
//        conn.connect();
//        conn.modify("INSERT INTO `EMPLOYEE` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('vidi', 'B', 'gummy', '', '1996-07-22', 'SEOUL', 'M', '30000.00', '666884444', '4')");
//        conn.close();
//        일은 안 하고 맨날 집에서 배 긁는 vidigummy의 흔적을 없애자.(testcode)
//        ArrayList<String> del_list = new ArrayList<String>();
//        del_list.add("15125021");
//        del_list.add("17125021");
//        E_Delete del_vidi = new E_Delete(del_list);
//        ArrayList test_Ssn = new ArrayList<String>();
//        test_Ssn.add("15125021");
//        Update_filter update_filter = new Update_filter("월급","100000",test_Ssn);
        if(InsertValidation("vidi", "B", "gummy", "1234", "1996-07-21", "SEOUL", "F", "30000.00", "1234555", "1")){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
