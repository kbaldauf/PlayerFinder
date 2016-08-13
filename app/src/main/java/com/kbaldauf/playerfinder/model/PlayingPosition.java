
package com.kbaldauf.playerfinder.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PlayingPosition {


    private String id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private String abbreviation;
    private Object description;
    private String formation;
    private String name;
    @SerializedName("league_id")
    private String leagueId;

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
     *     The abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     *
     * @param abbreviation
     *     The abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     *
     * @return
     *     The description
     */
    public Object getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *     The description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     *
     * @return
     *     The formation
     */
    public String getFormation() {
        return formation;
    }

    /**
     *
     * @param formation
     *     The formation
     */
    public void setFormation(String formation) {
        this.formation = formation;
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The leagueId
     */
    public String getLeagueId() {
        return leagueId;
    }

    /**
     *
     * @param leagueId
     *     The league_id
     */
    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(createdAt).append(updatedAt).append(abbreviation).append(description).append(formation).append(name).append(leagueId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlayingPosition) == false) {
            return false;
        }
        PlayingPosition rhs = ((PlayingPosition) other);
        return new EqualsBuilder().append(id, rhs.id).append(createdAt, rhs.createdAt).append(updatedAt, rhs.updatedAt).append(abbreviation, rhs.abbreviation).append(description, rhs.description).append(formation, rhs.formation).append(name, rhs.name).append(leagueId, rhs.leagueId).isEquals();
    }

}
