package database;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String args[]){
//모든 EMPLOYEE의 정보를 가져오는 법
//        Sellect_filter all = new Sellect_filter("","");
//        // 성별 SELECT
//        Sellect_filter Sex = new Sellect_filter("성별","M");
////        연봉 SELECT
        Sellect_filter Salary = new Sellect_filter("월급",90000);
//        //생일
//        Sellect_filter Birthday = new Sellect_filter("생일","1965-01-09");
//        //부하직원
//        Sellect_filter Supvervising = new Sellect_filter("부하직원","Franklin T Wong")
//        Insert 테스트 코드 돈을 많이 버는 vidigummy를 만드는 방법 다른 방법 있으려나?
//        E_Insert insert_test = new E_Insert("Vidi", "R", "Gummy", "17125021", "1996-07-22", "SEOUL-GangDong", 'M', "100000.00", "NULL", 1);

//  Delete Employee의 경우, 삭제를 하려면 객체를 가지고 있어야 한다.(당연쓰) So, Test Code를 Sellect_filter의 연봉 Select에 넣어놨으니 참고 바란다.
        // 원시적인 방법
//        conn.connect();
//        conn.modify("INSERT INTO `EMPLOYEE` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('vidi', 'B', 'gummy', '', '1996-07-22', 'SEOUL', 'M', '30000.00', '666884444', '4')");
//        conn.close();


    }
}
