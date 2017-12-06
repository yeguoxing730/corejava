package com.clone;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 10/17/17
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class User implements Cloneable,Serializable {
    private String username;

    private String password;

    private Date birthdate;

    public User(String username, String password, Date birthdate) {

        this.username = username;

        this.password = password;

        this.birthdate = birthdate;

    }

    @Override

    protected Object clone() throws CloneNotSupportedException {

        return super.clone();

    }



}
