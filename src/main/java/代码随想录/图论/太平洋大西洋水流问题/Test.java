package 代码随想录.图论.太平洋大西洋水流问题;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String path = "D:\\ttt.txt";
        long time1 = System.currentTimeMillis();

        for (int i = 0; i < 1; i++) {
            List<String> list = new ArrayList<>();
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fileInputStream, "GBK");
            BufferedReader bufferedReader = new BufferedReader(isr);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
            isr.close();
            fileInputStream.close();
//            return list;
        }

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Future<List<String>> future1=executorService.submit(()->{
//                List<String> list = new ArrayList<>();
//                FileInputStream fileInputStream = new FileInputStream(path);
//                InputStreamReader isr = new InputStreamReader(fileInputStream, "GBK");
//                BufferedReader bufferedReader = new BufferedReader(isr);
//                String line = "";
//                while ((line = bufferedReader.readLine()) != null) {
//                    list.add(line);
//                }
//                bufferedReader.close();
//                isr.close();
//                fileInputStream.close();
//                return list;
//        });
//        Future<List<String>> future2=executorService.submit(()->{
//                List<String> list = new ArrayList<>();
//                FileInputStream fileInputStream = new FileInputStream(path);
//                InputStreamReader isr = new InputStreamReader(fileInputStream, "GBK");
//                BufferedReader bufferedReader = new BufferedReader(isr);
//                String line = "";
//                while ((line = bufferedReader.readLine()) != null) {
//                    list.add(line);
//                }
//                bufferedReader.close();
//                isr.close();
//                fileInputStream.close();
//                return list;
//        });
//
//        Future<List<String>> future3=executorService.submit(()->{
//                List<String> list = new ArrayList<>();
//                FileInputStream fileInputStream = new FileInputStream(path);
//                InputStreamReader isr = new InputStreamReader(fileInputStream, "GBK");
//                BufferedReader bufferedReader = new BufferedReader(isr);
//                String line = "";
//                while ((line = bufferedReader.readLine()) != null) {
//                    list.add(line);
//                }
//                bufferedReader.close();
//                isr.close();
//                fileInputStream.close();
//                return list;
//        });
//
//        List<String> strings = future1.get();
//        List<String> strings1 = future2.get();
//        List<String> strings2 = future3.get();

        long time2 = System.currentTimeMillis();
        System.out.println((time2 - time1) );
        System.out.println();
    }


}
