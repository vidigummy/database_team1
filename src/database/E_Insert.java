package database;
// 5번에 대한 내용이다.
import java.time.*;

public class E_Insert extends Insert{
    E_Insert(String Fname, String Minit, String Lname, String Ssn, String Bdate, String Address, char Sex, String Salary, String Super_ssn, int Dno){
        Connector conn = new Connector();
        conn.connect();
        String query = String.format("INSERT INTO `EMPLOYEE` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`)" +
                                                    " VALUES ('%s','%s','%s','%s','%s', '%s', '%c', '%s', '%s', '%d')",Fname,Minit,Lname,Ssn,Bdate,Address, Sex,Salary,Super_ssn,Dno);
        System.out.println(query);
        boolean rs = conn.modify(query);
        if(rs){
            System.out.println("insert 성공");
        }else{
            System.out.println("insert 실패");
        }
        conn.close();
    }
}
