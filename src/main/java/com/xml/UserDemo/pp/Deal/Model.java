package com.xml.UserDemo.pp.Deal;

import com.xml.UserDemo.pp.Header.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/23/17
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Model {
    private String  assetType;
    private String name;
    private List<Parameter> parameterList = new ArrayList<Parameter>();

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }
}
