package com.designmodel.stragy.xml.factory;

import com.designmodel.stragy.xml.itf.Strategy;

import java.util.HashMap;
import java.util.Map;

public class ContextSpringFactory {
    private Map<String, Strategy> stgMap = new HashMap<String, Strategy>();

    /**
     * Getter method for property <tt>stgMap</tt>.
     *
     * @return property value of stgMap
     */
    public Map<String, Strategy> getStgMap() {
        return stgMap;
    }

    /**
     * Setter method for property <tt>stgMap</tt>.
     *
     * @param stgMap value to be assigned to property stgMap
     */
    public void setStgMap(Map<String, Strategy> stgMap) {
        this.stgMap = stgMap;
    }

    public void doAction(String strType) {
        this.stgMap.get(strType).testStrategy();
    }
}
