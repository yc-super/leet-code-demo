package 测试;

public enum SeasonEnum {
    SPRING(2),SUMMER(3),AUTUMN(4),WINTER(5);

    private int seq;

    SeasonEnum(int seq){
        this.seq=seq;
    }

    int getSeason(){
        return this.seq;
    }
}
class SeasonEnumTest{
    public static void main(String[] args) {
//        SeasonEnum seasonEnum= SeasonEnum.AUTUMN;
//        SeasonEnum seasonEnum2=SeasonEnum.AUTUMN;
//        System.out.println(seasonEnum.getSeason());
//        System.out.println(seasonEnum==seasonEnum2);
//        System.out.println(seasonEnum.ordinal());
//        System.out.println(seasonEnum.compareTo(SeasonEnum.values()[3]));
//        System.out.println(SeasonEnum.values()[1]);
        String a="a,b,c,,,";
        String[] split = a.split(",");
        System.out.println(split.length);
    }
}