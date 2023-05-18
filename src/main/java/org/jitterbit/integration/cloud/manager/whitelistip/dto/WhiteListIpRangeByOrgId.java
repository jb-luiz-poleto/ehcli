/*
 * Copyright (c) 1998-2016 Jitterbit, Inc.
 */
package org.jitterbit.integration.cloud.manager.whitelistip.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Aman Arya
 * @since 8.10.0
 */
public class WhiteListIpRangeByOrgId implements Serializable {
    private static final long serialVersionUID = -8801443728459093810L;
    private Long orgId;
    private List<WhiteListIpRange> whiteListIpRangeList;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public List<WhiteListIpRange> getWhiteListIpRangeList() {
        return whiteListIpRangeList;
    }

    public void setWhiteListIpRangeList(List<WhiteListIpRange> whiteListIpRangeList) {
        this.whiteListIpRangeList = whiteListIpRangeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhiteListIpRangeByOrgId that = (WhiteListIpRangeByOrgId) o;
        return Objects.equals(orgId, that.orgId) && Objects.equals(whiteListIpRangeList, that.whiteListIpRangeList);
    }

    @Override
    public String toString() {
        return "WhiteListIpRangeByOrgId [" +
                "orgId = " + orgId +
                ", whiteListIpRangeList = " + whiteListIpRangeList +
                ']';
    }
}
