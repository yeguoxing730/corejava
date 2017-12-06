package com.xml.UserDemo.pp.Deal;

import com.xml.UserDemo.pp.Header.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/23/17
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deal {
    private String ccy;
    private String  PricingDirection;
    private String  AssetCode;
    private String  NbAssets;
    private String  Version;
    private String  Id;
    private String  DealDate;
    private String  MarketDataGroup;
    private List<Parameter> ParameterList = new ArrayList<Parameter>();
    private Description description = new Description();
    private List<AssetModel> assetModelList = new ArrayList<AssetModel>();

}
