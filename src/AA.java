/**
 * @Derscription TODO
 * @auther David
 * @date 2018/7/25 11:11
 * @Version 1.o
 */
public class AA {

    public static void main(String[] args) {


        // System.out.println(JDBC.getConnection());
        //    System.out.println(JDBC.getCount("0180"));
       // System.out.println("result:"+ test());
//        String r_name3= "20pac10hira00";
//        //String r_name3 = "张三 13599998888 000000";
//        Pattern pattern = Pattern.compile("[\\d]");
//        Matcher matcher = pattern.matcher(r_name3);
//        System.out.println(matcher.replaceAll("").trim());

//        JSONObject aa= new JSONObject();
//        System.out.println(aa);
//        System.out.println(!aa.isEmpty());
//        aa.put("a","a");
//        System.out.println(aa.get("a"));
//        System.out.println(aa.isEmpty());



//        new Thread(()->{
//            System.out.println("aaa");
//        }).start();
    }




    static int test(){
        int i=0;
        //写一段代码，要求输入一字符串(例如:20pac10hira00)，过滤掉里面的数字(结果：pachira)
        try {
            System.out.println("try里面的："+i);
            return i;
        }finally {
            System.out.println("进入finally");
            i++;
            System.out.println("finally里的;"+i);
        }
    }

}
