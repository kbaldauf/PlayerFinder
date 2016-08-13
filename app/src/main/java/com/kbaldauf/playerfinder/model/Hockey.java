
package com.kbaldauf.playerfinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Hockey {

    // teams
    private List<Division> divisions = new ArrayList<Division>();
    private List<Conference> conferences = new ArrayList<Conference>();
    private List<League> leagues = new ArrayList<League>();
    private List<Team> teams = new ArrayList<Team>();

    // roster
    private List<Player> players = new ArrayList<Player>();
    @SerializedName("playing_positions")
    private List<PlayingPosition> playingPositions = new ArrayList<PlayingPosition>();
    private List<Season> seasons = new ArrayList<Season>();
    private List<Roster> rosters = new ArrayList<Roster>();

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

    /**
     *
     * @return
     *     The playingPositions
     */
    public List<PlayingPosition> getPlayingPositions() {
        return playingPositions;
    }

    /**
     *
     * @param playingPositions
     *     The playing_positions
     */
    public void setPlayingPositions(List<PlayingPosition> playingPositions) {
        this.playingPositions = playingPositions;
    }

    /**
     *
     * @return
     *     The seasons
     */
    public List<Season> getSeasons() {
        return seasons;
    }

    /**
     *
     * @param seasons
     *     The seasons
     */
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    /**
     *
     * @return
     *     The rosters
     */
    public List<Roster> getRosters() {
        return rosters;
    }

    /**
     *
     * @param rosters
     *     The rosters
     */
    public void setRosters(List<Roster> rosters) {
        this.rosters = rosters;
    }

    /**
     *
     * @return
     *     The players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @param players
     *     The players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(divisions).append(conferences).append(leagues).append(teams).append(players).append(playingPositions).append(rosters).append(seasons).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Hockey)) {
            return false;
        }
        Hockey rhs = ((Hockey) other);
        return new EqualsBuilder().append(divisions, rhs.divisions).append(conferences, rhs.conferences).append(leagues, rhs.leagues).append(teams, rhs.teams).append(players, rhs.players).append(playingPositions, rhs.playingPositions).append(rosters, rhs.rosters).append(seasons, rhs.seasons).isEquals();
    }

}
