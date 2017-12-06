package com.clone;

import org.junit.Test;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 10/17/17
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCase {
    @Test
    public void testCloneTo() {

        Administrator src = new Administrator(new User("Kent", "123456", new Date()), true);

        Administrator dist = (Administrator)BeanUtil.cloneTo(src);

        System.out.println(src == dist);			// false

        System.out.println(src.equals(dist));		// true

        System.out.println(src.getUser() == dist.getUser());		//false ! Well done!

        System.out.println(src.getUser().equals(dist.getUser()));	//true

    }
}
