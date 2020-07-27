package my.parking.test;

import cmcc.iot.onenet.javasdk.api.datapoints.AddDatapointsApi;
import cmcc.iot.onenet.javasdk.model.Data;
import cmcc.iot.onenet.javasdk.model.Datapoints;
import cmcc.iot.onenet.javasdk.response.BasicResponse;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 使用OneNET多协议SDK上报停车场车位数据点
 */
public class ApiTest {
    static Map<String, String> deviceNameToDeviceID = new HashMap<String, String>();
    static {
        deviceNameToDeviceID.put("A0", "606867156");
        deviceNameToDeviceID.put("A1", "606867157");
        deviceNameToDeviceID.put("A2", "606867158");
        deviceNameToDeviceID.put("A3", "606867159");
        deviceNameToDeviceID.put("A4", "606867160");
        deviceNameToDeviceID.put("A5", "606867161");
        deviceNameToDeviceID.put("A6", "606867162");
        deviceNameToDeviceID.put("B0", "606867163");
        deviceNameToDeviceID.put("B1", "606867164");
        deviceNameToDeviceID.put("B2", "606867165");
        deviceNameToDeviceID.put("B3", "606867166");
        deviceNameToDeviceID.put("B4", "606867167");
        deviceNameToDeviceID.put("C0", "606867168");
        deviceNameToDeviceID.put("C1", "606867169");
        deviceNameToDeviceID.put("C2", "606867170");
        deviceNameToDeviceID.put("C3", "606867171");
        deviceNameToDeviceID.put("C4", "606867172");
        deviceNameToDeviceID.put("D0", "606867173");
        deviceNameToDeviceID.put("D1", "606867174");
        deviceNameToDeviceID.put("D2", "606867175");
        deviceNameToDeviceID.put("D3", "606867176");
        deviceNameToDeviceID.put("D4", "606867177");
        deviceNameToDeviceID.put("D5", "606867178");
        deviceNameToDeviceID.put("D6", "606867179");
        deviceNameToDeviceID.put("total", "606877033");

    }
    @Test
    public void testAddDatapointsApi() {
        String devid = deviceNameToDeviceID.get("total");
        String key = "vMQxLPctd5VRZnE1YqYYda3ozig="; // Master-APIkey
        List<Datapoints> list = new ArrayList<Datapoints>();
        List<Data> dl = new ArrayList<Data>();
        dl.add(new Data(getDateTime(), 11));
        list.add(new Datapoints("datastream_idxx", dl));
        list.add(new Datapoints("datastream_idxy", dl));
        Map<String, List<Datapoints>> map = new HashMap<String, List<Datapoints>>();
        map.put("datastreams", list);
        /**
         * 数据点新增
         * @param map :数据点内容,Map<String,List<Datapoints>>
         * @param data:提供简写方式上传数据,String
         * 示例：
         * type=4
         * data="{\"temperature\":{\"2015-03-22T22:31:12\":22.5}}";
         * type=5
         * data=",;temperature,2015-03-22T22:31:12,22.5;pm2.5,89";
         * @param type:上传数据类型（可选，默认为完整JSON型，见HTTP内容示例）
         * @param devId:设备ID,String
         * @param key:masterkey 或者 设备apikey
         */
        AddDatapointsApi api = new AddDatapointsApi(map, null, null, devid, key);
        BasicResponse<Void> response = api.executeApi();
        System.out.println("errno:"+response.errno+" error:"+response.error);
    }

    public String getDateTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(formatter.format(date));
        return formatter.format(date);
    }

    public void changeParkingStatus(String index, int hasCar) {
        String devid = deviceNameToDeviceID.get("total");
        String key = "vMQxLPctd5VRZnE1YqYYda3ozig="; // Master-APIkey
        List<Datapoints> list = new ArrayList<Datapoints>();
        List<Data> dl = new ArrayList<Data>();
        dl.add(new Data(getDateTime(), hasCar));
        list.add(new Datapoints(index, dl));
        Map<String, List<Datapoints>> map = new HashMap<String, List<Datapoints>>();
        map.put("datastreams", list);
        /**
         * 数据点新增
         * @param map :数据点内容,Map<String,List<Datapoints>>
         * @param data:提供简写方式上传数据,String
         * 示例：
         * type=4
         * data="{\"temperature\":{\"2015-03-22T22:31:12\":22.5}}";
         * type=5
         * data=",;temperature,2015-03-22T22:31:12,22.5;pm2.5,89";
         * @param type:上传数据类型（可选，默认为完整JSON型，见HTTP内容示例）
         * @param devId:设备ID,String
         * @param key:masterkey 或者 设备apikey
         */
        AddDatapointsApi api = new AddDatapointsApi(map, null, null, devid, key);
        BasicResponse<Void> response = api.executeApi();
        System.out.println("errno:"+response.errno+" error:"+response.error);
    }

    @Test
    public void testAPI() {
        changeParkingStatus("B3", 1);
    }
}
