package com.kbaldauf.playerfinder.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Sport {

    private List<Division> divisions = new ArrayList<Division>();
    private List<Conference> conferences = new ArrayList<Conference>();
    private List<League> leagues = new ArrayList<League>();
    private List<Team> teams = new ArrayList<Team>();

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
     * @return
     *     The conferences
     */
    public List<Conference> getConferences() {
        return conferences;
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
     * @return
     *     The teams
     */
    public List<Team> getTeams() {
        return teams;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(divisions).append(conferences).append(leagues).append(teams).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Sport)) {
            return false;
        }
        Sport rhs = ((Sport) other);
        return new EqualsBuilder().append(divisions, rhs.divisions).append(conferences, rhs.conferences).append(leagues, rhs.leagues).append(teams, rhs.teams).isEquals();
    }

}
