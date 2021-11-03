package database;

public class Main {
    public static void main(String args[]){
        Connector conn = new Connector();
        System.out.println("hh...");
        conn.connect();
//        conn.modify("INSERT INTO `EMPLOYEE` (`Fname`, `Minit`, `Lname`, `Ssn`, `Bdate`, `Address`, `Sex`, `Salary`, `Super_ssn`, `Dno`) VALUES ('vidi', 'B', 'gummy', '', '1996-07-22', 'SEOUL', 'M', '30000.00', '666884444', '4')");
        conn.close();
    }
}
