/*
 * Copyright (c) 1998-2016 Jitterbit, Inc.
 *
 */
package org.jitterbit.integration.cloud.manager.whitelistip.dto;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Objects;

/**
 * @author Aman Arya
 * @since 8.10.0
 */
public class WhiteListIpRange implements Serializable {
    private static final long serialVersionUID = 2112379661029545979L;
    private InetAddress startIp;
    private InetAddress endIp;

    public InetAddress getStartIp() {
        return startIp;
    }

    public void setStartIp(InetAddress startIp) {
        this.startIp = startIp;
    }

    public InetAddress getEndIp() {
        return endIp;
    }

    public void setEndIp(InetAddress endIp) {
        this.endIp = endIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhiteListIpRange that = (WhiteListIpRange) o;
        return Objects.equals(startIp, that.startIp) && Objects.equals(endIp, that.endIp);
    }

    @Override
    public String toString() {
        return "WhiteListIpRange [" +
                "startIp = " + startIp +
                ", endIp = " + endIp +
                ']';
    }
}
