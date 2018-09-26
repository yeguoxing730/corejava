package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

//http://www.cnblogs.com/lovebread/archive/2009/11/23/1609122.html
public class JSONOBJTest {
    private static final HashSet<Integer> userids = new HashSet() {
    };
    private static final HashMap<String, SummaryUser> userMap = new HashMap() {
    };
    private static final Properties properites = new Properties();

    static {
        try {
            properites.load(JSONOBJTest.class.getClassLoader().getResourceAsStream("user.properties"));
            String userJson = properites.getProperty("68293069");
            ObjectMapper mapper = new ObjectMapper();
            SummaryUser obj2 = mapper.readValue(userJson, SummaryUser.class);
            userMap.put("68293069", obj2);
            System.out.println(obj2.getArea());
        } catch (Exception e) {
            e.printStackTrace();
        }
        userids.add(68292069);
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStreamReader fileInputStream = new InputStreamReader(JSONOBJTest.class.getClassLoader().getResourceAsStream("userlist.json"));
        BufferedReader reader = new BufferedReader(fileInputStream);
        String tempString = null;
        int line = 1;
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            // 显示行号
            System.out.println("line " + line + ": " + tempString);
            SummaryUser obj2 = mapper.readValue(tempString, SummaryUser.class);
            userMap.put(obj2.getUserid(), obj2);
            line++;
        }
        reader.close();
        SummaryUser summaryUser = new SummaryUser();
        summaryUser.setArea("beijing");
        summaryUser.setCity("changping");
        summaryUser.setName("ye");
        summaryUser.setPhone("13522791865");
        summaryUser.setUserid("45455");
        summaryUser.setCity("2");
        summaryUser.setCt("443");
        String jsonInString = mapper.writeValueAsString(summaryUser);
        System.out.println(jsonInString);
        SummaryUser obj = mapper.readValue(jsonInString, SummaryUser.class);
        System.out.println(obj.getArea());
        String jsonObj = "{\"area\":\"beijing\",\"city\":\"2\",\"name\":\"ye\",\"phone\":\"13522791865\",\"userid\":\"45455\",\"ct\":\"443\"}";
        SummaryUser obj2 = mapper.readValue(jsonObj, SummaryUser.class);
        System.out.println(obj2.getArea());
    }
}

class SummaryUser implements Serializable {
    private String area;
    private String city;
    private String name;
    private String phone;
    private String userid;
    private String ct;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }
};

