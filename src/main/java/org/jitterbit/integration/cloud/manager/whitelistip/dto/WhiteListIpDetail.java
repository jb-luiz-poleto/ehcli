/*
 * Copyright (c) 1998-2016 Jitterbit, Inc.
 *
 */
package org.jitterbit.integration.cloud.manager.whitelistip.dto;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.List;
import java.util.Objects;

/**
 * @author Aman Arya
 * @since 8.10.0
 */
public class WhiteListIpDetail implements Serializable {
    private static final long serialVersionUID = -1013696597448221569L;
    private InetAddress userIp;
    private List<WhiteListIpRangeByOrgId> whiteListIpRangeByOrgIds;

    public InetAddress getUserIp() {
        return userIp;
    }

    public void setUserIp(InetAddress userIp) {
        this.userIp = userIp;
    }

    public List<WhiteListIpRangeByOrgId> getWhiteListIpRangeByOrgIds() {
        return whiteListIpRangeByOrgIds;
    }

    public void setWhiteListIpRangeByOrgIds(List<WhiteListIpRangeByOrgId> whiteListIpRangeByOrgIds) {
        this.whiteListIpRangeByOrgIds = whiteListIpRangeByOrgIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhiteListIpDetail that = (WhiteListIpDetail) o;
        return Objects.equals(userIp, that.userIp) && Objects.equals(whiteListIpRangeByOrgIds, that.whiteListIpRangeByOrgIds);
    }

    @Override
    public String toString() {
        return "WhiteListIpDetail [" +
                "userIp = " + userIp +
                ", whiteListIpRangeByOrgIds = " + whiteListIpRangeByOrgIds +
                ']';
    }
}
