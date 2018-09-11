import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List list=new ArrayList();
        JSONObject map = new JSONObject();

        map.put("name", "aaa");
        map.put("y", "1");
        list.add(map);
        list.add(map);
        list.add(map);
        list.add(map);
        System.out.println(list);
    }
}
