package 测试;

public class ceshiStudent {
    public static void main(String[] args) {
        Student s=new Student();
        s.setName("小明");
        s.setId("1");
        ceshis(s);
        System.out.println();
    }

    private static void ceshis(Student s) {
        s.setName("小红");
    }
}
