
package com.kbaldauf.playerfinder.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Roster {

    private List<Player> players = new ArrayList<Player>();
    @SerializedName("playing_positions")
    private List<PlayingPosition> playingPositions = new ArrayList<PlayingPosition>();
    private List<Season> seasons = new ArrayList<Season>();

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
     * @return
     *     The seasons
     */
    public List<Season> getSeasons() {
        return seasons;
    }

    /**
     *
     * @return
     *     The players
     */
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(seasons).append(players).append(playingPositions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Roster)) {
            return false;
        }
        Roster rhs = ((Roster) other);
        return new EqualsBuilder().append(seasons, rhs.seasons).append(players, rhs.players).append(playingPositions, rhs.playingPositions).isEquals();
    }

}
