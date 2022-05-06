package 测试;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.xml.internal.ws.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ceshi4 {
    public static void main(String[] args) {
       /*File file=new File("d:/ceshi/");
       if(file.exists()){
           System.out.println("存在");
       }else {
           file.mkdirs();
           System.out.println("不存在");
       }*/
//        System.out.println(34544/1048576L);

//        String s="d:/upload/*/gim-yc-ceshi04.zip";
//        System.out.println(s.replaceAll("\\*","/"));

//        String s= "[{\"1\":\"a\",\"3\":\"c\"},{\"1\":\"b\"}]";
        String s= "[{\"NominalValue\":\"19827\",\"Name\":\"ElementID\"},{\"NominalValue\":\"D3_HJ_3D\",\"Name\":\"LevelName\"}]";
//        String s= "[{\"custId\":\"4164275\",\"partyNumber\":\"LN2018122110041351\",\"ChannelMemberId\":\"\",\"controlType\":\"13013001\",\"commonRegionName\":\"集团\",\"industryCd\":\"DD0302\",\"commonRegionId\":\"100000\",\"extCustId\":\"\",\"statusCd\":\"\",\"custNumber\":\"1000001994420000\",\"custName\":\"华夏银行股份有限公司鞍山分行\",\"createDate\":\"\",\"controlLevel\":\"13013001\"}]";
//        HashMap<String,Object> map = JSON.parseObject(s, HashMap.class);
        List<Map> lists = JSON.parseArray(s, Map.class);
        Map<String,String> result=new HashMap<>();
        for(Map<String,String> map1:lists){
                result.put(map1.get("Name"),map1.get("NominalValue"));

            }
        for(Map.Entry<String,String> entry:result.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        String a=null;
        String b=null;
        if(!(a==null)||!(b==null)){
            System.out.println(123);
        }
        /*for(Map.Entry<String,Object> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }*/
//        String s="{\"propset\":[{\"id\":\"0EmumM_Zr33emQMBs0OTKr\",\"Name\":\"CableTray Elbow\",\"sValue\":[{\"NominalValue\":\"False\",\"Name\":\"Active Item\"},{\"NominalValue\":\"\",\"Name\":\"Additional Code\"},{\"NominalValue\":\"150.000000\",\"Name\":\"附加长度\"},{\"NominalValue\":\"\",\"Name\":\"Alias\"},{\"NominalValue\":\"90.000000\",\"Name\":\"弯曲角度\"},{\"NominalValue\":\"\",\"Name\":\"Branch ID\"},{\"NominalValue\":\"\",\"Name\":\"编码\"},{\"NominalValue\":\"\",\"Name\":\"Component Classification\"},{\"NominalValue\":\"\",\"Name\":\"Component Name\"},{\"NominalValue\":\"\",\"Name\":\"Component Number\"},{\"NominalValue\":\"False\",\"Name\":\"连接片\"},{\"NominalValue\":\"2021-10-13T15:00:23.947\",\"Name\":\"Created Timestamp\"},{\"NominalValue\":\"2021-10-13T15:00:34.131\",\"Name\":\"Create Time\"},{\"NominalValue\":\"zhu_cb601\",\"Name\":\"Created By\"},{\"NominalValue\":\"100.000000\",\"Name\":\"高度\"},{\"NominalValue\":\"BLINE HORIZONTAL 90 DEGREE BEND LADDER TYPE SERIES 2\",\"Name\":\"Description\"},{\"NominalValue\":\"\",\"Name\":\"Designer\"},{\"NominalValue\":\"\",\"Name\":\"Design State\"},{\"NominalValue\":\"\",\"Name\":\"Detail_Sketch\"},{\"NominalValue\":\"\",\"Name\":\"Device Type Code\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Dry Weight\"},{\"NominalValue\":\"\",\"Name\":\"Design State\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Elevation\"},{\"NominalValue\":\"\",\"Name\":\"Related Equipment Plant\"},{\"NominalValue\":\"\",\"Name\":\"Related Equipment System\"},{\"NominalValue\":\"\",\"Name\":\"Equipment Unit Classification\"},{\"NominalValue\":\"\",\"Name\":\"Equipment Unit Code\"},{\"NominalValue\":\"1295.400000\",\"Name\":\"Face to center main\"},{\"NominalValue\":\"1295.400000\",\"Name\":\"Face to center run\"},{\"NominalValue\":\"\",\"Name\":\"Functional InstanceId\"},{\"NominalValue\":\"f4ed513c-cfd2-4cb3-b2ff-a118f32e652a\",\"Name\":\"Guid\"},{\"NominalValue\":\"\",\"Name\":\"Element Geometry\"},{\"NominalValue\":\"False\",\"Name\":\"Is Tag Reserved\"},{\"NominalValue\":\"800.000000\",\"Name\":\"长度L1\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Length Effective\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Lower Limit Design Temperature\"},{\"NominalValue\":\"BLINE\",\"Name\":\"Manufacturer\"},{\"NominalValue\":\"AL\",\"Name\":\"Material\"},{\"NominalValue\":\"\",\"Name\":\"Model\"},{\"NominalValue\":\"\",\"Name\":\"Modified By\"},{\"NominalValue\":\"\",\"Name\":\"Modification Time\"},{\"NominalValue\":\"\",\"Name\":\"Name\"},{\"NominalValue\":\"500.000000\",\"Name\":\"宽度\"},{\"NominalValue\":\"\",\"Name\":\"Nominal Size\"},{\"NominalValue\":\"\",\"Name\":\"Number\"},{\"NominalValue\":\"\",\"Name\":\"Order Number\"},{\"NominalValue\":\"\",\"Name\":\"Paint Code\"},{\"NominalValue\":\"\",\"Name\":\"PDx State\"},{\"NominalValue\":\"\",\"Name\":\"Pipe Tag Number\"},{\"NominalValue\":\"\",\"Name\":\"Related Piping Plant\"},{\"NominalValue\":\"\",\"Name\":\"Related Piping System\"},{\"NominalValue\":\"\",\"Name\":\"Plant\"},{\"NominalValue\":\"\",\"Name\":\"Plant Area\"},{\"NominalValue\":\"1.000000\",\"Name\":\"板厚\"},{\"NominalValue\":\"\",\"Name\":\"Psds State\"},{\"NominalValue\":\"914.400000\",\"Name\":\"Radius\"},{\"NominalValue\":\"25.400000\",\"Name\":\"Rung height\"},{\"NominalValue\":\"228.600000\",\"Name\":\"Rung spacing\"},{\"NominalValue\":\"25.400000\",\"Name\":\"Rung width\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Run width\"},{\"NominalValue\":\"\",\"Name\":\"Service\"},{\"NominalValue\":\"\",\"Name\":\"Service level\"},{\"NominalValue\":\"0\",\"Name\":\"是否显示编码\"},{\"NominalValue\":\"\",\"Name\":\"Size\"},{\"NominalValue\":\"托盘式桥架\",\"Name\":\"Specification\"},{\"NominalValue\":\"\",\"Name\":\"分隔板/截面\"},{\"NominalValue\":\"NUM_0\",\"Name\":\"分隔板数量\"},{\"NominalValue\":\"\",\"Name\":\"Component State\"},{\"NominalValue\":\"\",\"Name\":\"Stock Number\"},{\"NominalValue\":\"SERIES 2\",\"Name\":\"Style\"},{\"NominalValue\":\"\",\"Name\":\"Suffix\"},{\"NominalValue\":\"\",\"Name\":\"System\"},{\"NominalValue\":\"\",\"Name\":\"Tag Number\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Total Weight\"},{\"NominalValue\":\"\",\"Name\":\"Transformation Matrix - Geometry\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Transformation Matrix - M00\"},{\"NominalValue\":\"-1.000000\",\"Name\":\"Transformation Matrix - M01\"},{\"NominalValue\":\"-0.000000\",\"Name\":\"Transformation Matrix - M02\"},{\"NominalValue\":\"81312401.963192\",\"Name\":\"Transformation Matrix - M03\"},{\"NominalValue\":\"-1.000000\",\"Name\":\"Transformation Matrix - M04\"},{\"NominalValue\":\"-0.000000\",\"Name\":\"Transformation Matrix - M05\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Transformation Matrix - M06\"},{\"NominalValue\":\"11257242.586082\",\"Name\":\"Transformation Matrix - M07\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Transformation Matrix - M08\"},{\"NominalValue\":\"-0.000000\",\"Name\":\"Transformation Matrix - M09\"},{\"NominalValue\":\"1.000000\",\"Name\":\"Transformation Matrix - M10\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Transformation Matrix - M11\"},{\"NominalValue\":\"\",\"Name\":\"Transformation Matrix - M12\"},{\"NominalValue\":\"\",\"Name\":\"Transformation Matrix - M13\"},{\"NominalValue\":\"\",\"Name\":\"Transformation Matrix - M14\"},{\"NominalValue\":\"\",\"Name\":\"Transformation Matrix - M15\"},{\"NominalValue\":\"ARC\",\"Name\":\"弯曲设置\"},{\"NominalValue\":\"-托盘式桥架\",\"Name\":\"Tray number\"},{\"NominalValue\":\"50\",\"Name\":\"容积率\"},{\"NominalValue\":\"\",\"Name\":\"Type\"},{\"NominalValue\":\"\",\"Name\":\"Unit\"},{\"NominalValue\":\"\",\"Name\":\"Unit Number\"},{\"NominalValue\":\"\",\"Name\":\"Unit of Measure\"},{\"NominalValue\":\"0.000000\",\"Name\":\"Upper Limit Design Temperature\"},{\"NominalValue\":\"TRAY_1_MV_CABLE\",\"Name\":\"电压等级\"},{\"NominalValue\":\"1.700000\",\"Name\":\"Wall thickness\"},{\"NominalValue\":\"2578682\",\"Name\":\"ElementID\"},{\"NominalValue\":\"电一桥架\",\"Name\":\"LevelName\"}]}],\"Name\":\"2578682_4\"}";
//        System.out.println(s.indexOf("propset"));
    }
}
