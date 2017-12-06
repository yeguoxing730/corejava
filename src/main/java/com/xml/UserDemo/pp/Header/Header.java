package com.xml.UserDemo.pp.Header;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/23/17
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class Header {
    private String AsOfDate;
    private List<Parameter> Output = new ArrayList<Parameter>();

    public String getAsOfDate() {
        return AsOfDate;
    }

    public void setAsOfDate(String asOfDate) {
        AsOfDate = asOfDate;
    }

    public List<Parameter> getOutput() {
        return Output;
    }

    public void setOutput(List<Parameter> output) {
        Output = output;
    }
}
