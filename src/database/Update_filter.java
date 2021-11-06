package database;

import java.util.ArrayList;
import java.util.HashMap;

public class Update_filter {
    Update_filter(String what, String input, ArrayList<HashMap<String,Object>> input_to_Update){
        if(what.equals("주소")){
            Ad_Update ad_update = new Ad_Update(input, input_to_Update);
            ad_update.Update_Address();
            System.out.println("주소 변경 완료");
        }else if(what.equals("성별")){
            Se_Update se_update = new Se_Update(input, input_to_Update);
            se_update.Update_Sex();
            System.out.println("성별 변경 완료");
        }else if(what.equals("월급")){
            Sa_Update sa_update = new Sa_Update(input, input_to_Update);
            sa_update.Update_Salary();
            System.out.println("월급 변경 완료");
        }else{
            System.out.println("잘못된 조건 입력");
        }
    }
}
