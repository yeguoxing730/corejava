package com.clone;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 10/17/17
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Administrator implements Cloneable, Serializable {
    private User user;

    private Boolean editable;

    public Administrator(User user, Boolean editable) {

        this.user = user;

        this.editable = editable;

    }


    @Override

    protected Object clone() throws CloneNotSupportedException {

        return super.clone();

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrator)) return false;

        Administrator that = (Administrator) o;

        if (!editable.equals(that.editable)) return false;
        if (!user.equals(that.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + editable.hashCode();
        return result;
    }

    public static void main(String[] args) throws Exception {

        Administrator a1 = new Administrator(new User("Kent", "123456", new Date()), true);

        Administrator a2 = a1;

        Administrator a3 = (Administrator) a1.clone();


        System.out.println(a1 == a2);            // true

        System.out.println(a1.equals(a2));        // true


        System.out.println(a1 == a3);            // false

        System.out.println(a1.equals(a3));        // true


        System.out.println(a1.getUser() == a3.getUser());        //true ! It's not our expected!!!!!

        System.out.println(a1.getUser().equals(a3.getUser()));    //true
    }
}
