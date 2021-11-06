package database;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String args[]){
        Connector conn = new Connector();
        System.out.println("hh...");
//모든 EMPLOYEE의 정보를 가져오는 법
        Sellect_filter all = new Sellect_filter("","");
        // 성별 SELECT
        Sellect_filter Sex = new Sellect_filter("성별","M");
//        연봉 SELECT
        Sellect_filter Salary = new Sellect_filter("연봉",10000);
        //생일
        Sellect_filter Birthday = new Sellect_filter("생일","1965-01-09");
        //부하직원
        Sellect_filter Supvervising = new Sellect_filter("부하직원","Franklin T Wong");
//        conn.connect();
//        conn.modify("INSERT INTO `EMPLOYEE` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('vidi', 'B', 'gummy', '', '1996-07-22', 'SEOUL', 'M', '30000.00', '666884444', '4')");
//        conn.close();

//        1번. 모든 사용자 검색
//        A_Select 사용 방법
//        A_Select test_a_select = new A_Select();
//        ArrayList<HashMap<String,Object>> tmp = new ArrayList<HashMap<String,Object>>();
//        tmp = test_a_select.Select_All();
//        for(HashMap<String,Object> row : tmp){
//            System.out.println(row.get("Name")+" "+row.get("Ssn")+row.get("Address")+" "
//                    +row.get("Sex")+" "+row.get("Supervisor")+" "+row.get("Salary")+" "+row.get("Dname"));
//        }
//
    }
}
