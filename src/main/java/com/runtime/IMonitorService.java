package com.runtime;

/**
 * corejava
 * 2020/1/16 9:50
 *
 * @author gxye
 * @since
 **/
public interface IMonitorService {
    /** */ /**
     * 获得当前的监控对象.
     * @return 返回构造好的监控对象
     * @throws Exception
     * @author amgkaka
     * Creation date: 2008-4-25 - 上午10:45:08
     */
    MonitorInfoBean getMonitorInfoBean() throws Exception;
}
