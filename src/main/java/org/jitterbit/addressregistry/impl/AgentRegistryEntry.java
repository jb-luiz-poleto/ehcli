package org.jitterbit.addressregistry.impl;

import java.io.Serializable;

/**
 * Created by art on 9/25/14.
 */
public class AgentRegistryEntry implements Serializable {
    static final long serialVersionUID = -2463837830281059890L;

    private final String agentId;
    private final String agentGroupId;
    private final String location;
    private final String agentVersion;

    public AgentRegistryEntry(String newAgentId, String newAgentGroupId, String newLocation, String newAgentVersion) {
        agentId = newAgentId;
        agentGroupId = newAgentGroupId;
        location = newLocation;
        agentVersion = newAgentVersion;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getAgentGroupId() {
        return agentGroupId;
    }

    public String getLocation() {
        return location;
    }

    public String getAgentVersion() {
        return agentVersion;
    }

    @Override
    public int hashCode() {
        if (agentId != null) {
            return agentId.hashCode();
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof AgentRegistryEntry) {
            AgentRegistryEntry other = (AgentRegistryEntry) obj;

            if ((stringsMatch(agentId, other.agentId) && stringsMatch(agentGroupId, other.agentGroupId) &&
                    stringsMatch(location, other.location) && stringsMatch(agentVersion, other.agentVersion))) {
                return true;
            }
        }

        return false;
    }

    protected boolean stringsMatch(String str1, String str2) {
        if ((str1 == null) && (str2 == null)) {
            return true;
        } else if (str1 == null) {
            return false;
        }

        return (str1.equals(str2));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ id=");
        stringBuilder.append(this.agentId);
        stringBuilder.append("; group=");
        stringBuilder.append(this.agentGroupId);
        stringBuilder.append("; location=");
        stringBuilder.append(this.location);
        stringBuilder.append("; agentVersion=");
        stringBuilder.append(this.agentVersion);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
