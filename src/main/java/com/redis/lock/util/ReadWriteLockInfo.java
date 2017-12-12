package com.redis.lock.util;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/12/17
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReadWriteLockInfo {
    // ------------- read lock fields ------------

    private Set<LockInfo> readInfos = new HashSet<LockInfo>();

    // ------------- write lock fields -----------

    private LockInfo writeInfo;

    public boolean isAnyLocked() {
        return isReadLocked() || isWriteLocked();
    }

    public boolean isReadLocked() {
        return readInfos.size() > 0 && writeInfo == null;
    }

    public boolean isWriteLocked() {
        return readInfos.size() == 0 && writeInfo != null;
    }

    public void addReadInfo(LockInfo readInfo) {
        ObjectUtils.requireNonNull(readInfo, "readInfo");
        readInfos.add(readInfo);
    }

    public boolean removeReadInfo(LockInfo lockInfo) {
        ObjectUtils.requireNonNull(lockInfo, "lockInfo");
        boolean removed = readInfos.remove(lockInfo);
        if (!removed) {
            for (LockInfo info : readInfos) {
                if (lockInfo.isSame(info)) {
                    removed = readInfos.remove(info);
                }
            }
        }
        return removed;
    }

    public void removeAllReadInfo() {
        readInfos.clear();
    }

    public void removeWriteInfo() {
        writeInfo = null;
    }

    public Set<LockInfo> getReadInfos() {
        return readInfos;
    }

    public void setReadInfos(Set<LockInfo> readInfos) {
        ObjectUtils.requireNonNull(readInfos, "readInfos");
        this.readInfos = readInfos;
    }

    public LockInfo getWriteInfo() {
        return writeInfo;
    }

    public void setWriteInfo(LockInfo writeInfo) {
        ObjectUtils.requireNonNull(writeInfo, "writeInfo");
        if (isReadLocked()) {
            throw new IllegalMonitorStateException("cannot set writeInfo, cause readInfos has at least one element");
        }
        this.writeInfo = writeInfo;
    }

    // ---------- util methods -------------

    public boolean isLegal() {
        return !(readInfos.size() > 0 && writeInfo != null);
    }

    private void requireLegal() {
        if (isLegal()) {
            throw new IllegalMonitorStateException(String.format("current WriteLockInfo[%s] is in a abnormal state", toString()));
        }
    }

    public static ReadWriteLockInfo fromString(String json) {
        ObjectUtils.requireNonNull(json, "json");
        try {
            ReadWriteLockInfo info = JSON.parseObject(json, ReadWriteLockInfo.class);
            info.requireLegal();
            return info;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ReadWriteLockInfo newReadForCurrThread(long readExpireTime) {
        ReadWriteLockInfo info = new ReadWriteLockInfo();
        info.addReadInfo(LockInfo.newForCurrThread(readExpireTime));
        return info;
    }

    public static String toString(ReadWriteLockInfo info) {
        ObjectUtils.requireNonNull(info, "info");
        return JSON.toJSONString(info);
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return toString(this);
    }
}
