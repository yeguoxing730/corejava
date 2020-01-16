package com.runtime;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * corejava
 * 2020/1/16 9:53
 *
 * @author gxye
 * @since
 **/
public class RuntimeMain {
    static public void main(String[] args) {
        try {
            //通过主机名称得到IP地址
            InetAddress address = InetAddress.getByName("192.168.9.148");
            System.out.println("192.168.9.148"+": "+address.getHostAddress());
//  通过IP得到主机名称
            String ips="192.168.9.",ip;
            InetAddress addip;
            for(int i=148;i<255;i++){
                ip=ips+i;
                addip=InetAddress.getByName(ip);
                System.out.println(ip+": "+addip.getHostName());

            }



        }
        catch(UnknownHostException uhe) {
            System.err.println("Unable to find: "+"192.168.9.148");
        }
    }
}
