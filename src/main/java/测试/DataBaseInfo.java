package 测试;

import java.util.EnumMap;

public class DataBaseInfo {
    // 定义数据库类型枚举
    public enum DataBaseType {
        MYSQL,ORACLE,DB2,SQLSERVER
    }
    // 某类中定义的获取数据库URL的方法以及EnumMap的声明
    private EnumMap<DataBaseType,String> urls = new EnumMap<DataBaseType,String>(DataBaseType.class);
    public DataBaseInfo() {
        urls.put(DataBaseType.DB2,"jdbc:db2://localhost:5000/sample");
        urls.put(DataBaseType.MYSQL,"jdbc:mysql://localhost/mydb");
        urls.put(DataBaseType.ORACLE,"jdbc:oracle:thin:@localhost:1521:sample");
        urls.put(DataBaseType.SQLSERVER,"jdbc:microsoft:sqlserver://sql:1433;Database=mydb");
    }
    //根据不同的数据库类型，返回对应的URL
// @param type DataBaseType 枚举类新实例
// @return
    public String getURL(DataBaseType type) {
        return this.urls.get(type);
    }
}
