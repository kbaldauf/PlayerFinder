
package com.kbaldauf.playerfinder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Hockey {

    private List<Division> divisions = new ArrayList<Division>();
    private List<Conference> conferences = new ArrayList<Conference>();
    private List<League> leagues = new ArrayList<League>();
    private List<Team> teams = new ArrayList<Team>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The divisions
     */
    public List<Division> getDivisions() {
        return divisions;
    }

    /**
     * 
     * @param divisions
     *     The divisions
     */
    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }

    /**
     * 
     * @return
     *     The conferences
     */
    public List<Conference> getConferences() {
        return conferences;
    }

    /**
     * 
     * @param conferences
     *     The conferences
     */
    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    /**
     * 
     * @return
     *     The leagues
     */
    public List<League> getLeagues() {
        return leagues;
    }

    /**
     * 
     * @param leagues
     *     The leagues
     */
    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    /**
     * 
     * @return
     *     The teams
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     * 
     * @param teams
     *     The teams
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(divisions).append(conferences).append(leagues).append(teams).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hockey) == false) {
            return false;
        }
        Hockey rhs = ((Hockey) other);
        return new EqualsBuilder().append(divisions, rhs.divisions).append(conferences, rhs.conferences).append(leagues, rhs.leagues).append(teams, rhs.teams).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
