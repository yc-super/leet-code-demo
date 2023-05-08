package 测试;


import java.util.concurrent.FutureTask;

public class RealData  {
    protected final String result;


    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        result = sb.toString();
    }

    {
        result="";
    }
//    FutureTask
//    public void methodA(){
//        result="22";
//    }
}
