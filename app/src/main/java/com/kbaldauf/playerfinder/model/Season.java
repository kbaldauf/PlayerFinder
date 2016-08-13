
package com.kbaldauf.playerfinder.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Season {

    private String id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private String name;
    @SerializedName("current_interval_type")
    private Object currentIntervalType;
    @SerializedName("start_on")
    private String startsOn;
    @SerializedName("ends_on")
    private String endsOn;
    private String slug;
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
     *     The currentIntervalType
     */
    public Object getCurrentIntervalType() {
        return currentIntervalType;
    }

    /**
     *
     * @param currentIntervalType
     *     The current_interval_type
     */
    public void setCurrentIntervalType(Object currentIntervalType) {
        this.currentIntervalType = currentIntervalType;
    }

    /**
     *
     * @return
     *     The startsOn
     */
    public String getStartsOn() {
        return startsOn;
    }

    /**
     *
     * @param startsOn
     *     The starts_on
     */
    public void setStartsOn(String startsOn) {
        this.startsOn = startsOn;
    }

    /**
     *
     * @return
     *     The endsOn
     */
    public String getEndsOn() {
        return endsOn;
    }

    /**
     *
     * @param endsOn
     *     The ends_on
     */
    public void setEndsOn(String endsOn) {
        this.endsOn = endsOn;
    }

    /**
     *
     * @return
     *     The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     *
     * @param slug
     *     The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
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
        return new HashCodeBuilder().append(id).append(createdAt).append(updatedAt).append(name).append(currentIntervalType).append(startsOn).append(endsOn).append(slug).append(leagueId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Season) == false) {
            return false;
        }
        Season rhs = ((Season) other);
        return new EqualsBuilder().append(id, rhs.id).append(createdAt, rhs.createdAt).append(updatedAt, rhs.updatedAt).append(name, rhs.name).append(currentIntervalType, rhs.currentIntervalType).append(startsOn, rhs.startsOn).append(endsOn, rhs.endsOn).append(slug, rhs.slug).append(leagueId, rhs.leagueId).isEquals();
    }

}
