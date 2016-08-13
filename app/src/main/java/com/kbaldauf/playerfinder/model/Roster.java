
package com.kbaldauf.playerfinder.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Roster {

    private String id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("last_game_started_at")
    private Object lastGameStartedAt;
    @SerializedName("player_id")
    private String playerId;
    @SerializedName("team_id")
    private String teamId;
    @SerializedName("season_id")
    private String seasonId;

    /**
     *
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     *     The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     *     The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     *     The lastGameStartedAt
     */
    public Object getLastGameStartedAt() {
        return lastGameStartedAt;
    }

    /**
     *
     * @param lastGameStartedAt
     *     The last_game_started_at
     */
    public void setLastGameStartedAt(Object lastGameStartedAt) {
        this.lastGameStartedAt = lastGameStartedAt;
    }

    /**
     *
     * @return
     *     The playerId
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     *
     * @param playerId
     *     The player_id
     */
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    /**
     *
     * @return
     *     The teamId
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     *     The team_id
     */
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return
     *     The seasonId
     */
    public String getSeasonId() {
        return seasonId;
    }

    /**
     *
     * @param seasonId
     *     The season_id
     */
    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(createdAt).append(updatedAt).append(lastGameStartedAt).append(playerId).append(teamId).append(seasonId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Roster) == false) {
            return false;
        }
        Roster rhs = ((Roster) other);
        return new EqualsBuilder().append(id, rhs.id).append(createdAt, rhs.createdAt).append(updatedAt, rhs.updatedAt).append(lastGameStartedAt, rhs.lastGameStartedAt).append(playerId, rhs.playerId).append(teamId, rhs.teamId).append(seasonId, rhs.seasonId).isEquals();
    }

}
