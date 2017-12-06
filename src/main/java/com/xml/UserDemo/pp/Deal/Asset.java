package com.xml.UserDemo.pp.Deal;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/23/17
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Asset {
    private String name;
    private String type;
    private String mnemonic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getForeignCcy() {
        return foreignCcy;
    }

    public void setForeignCcy(String foreignCcy) {
        this.foreignCcy = foreignCcy;
    }

    private String ccy;
    private String foreignCcy;
}
