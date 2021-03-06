
package com.kbaldauf.playerfinder.model;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class League {

    private String id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private String abbreviation;
    private Object color;
    @SerializedName("minutes_per_period")
    private Object minutesPerPeriod;
    private String name;
    private Object periods;
    private String slug;
    private String sport;

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
     *     The color
     */
    public Object getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(Object color) {
        this.color = color;
    }

    /**
     * 
     * @return
     *     The minutesPerPeriod
     */
    public Object getMinutesPerPeriod() {
        return minutesPerPeriod;
    }

    /**
     * 
     * @param minutesPerPeriod
     *     The minutes_per_period
     */
    public void setMinutesPerPeriod(Object minutesPerPeriod) {
        this.minutesPerPeriod = minutesPerPeriod;
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
     *     The periods
     */
    public Object getPeriods() {
        return periods;
    }

    /**
     * 
     * @param periods
     *     The periods
     */
    public void setPeriods(Object periods) {
        this.periods = periods;
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
     *     The sport
     */
    public String getSport() {
        return sport;
    }

    /**
     * 
     * @param sport
     *     The sport
     */
    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(createdAt).append(updatedAt).append(abbreviation).append(color).append(minutesPerPeriod).append(name).append(periods).append(slug).append(sport).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof League)) {
            return false;
        }
        League rhs = ((League) other);
        return new EqualsBuilder().append(id, rhs.id).append(createdAt, rhs.createdAt).append(updatedAt, rhs.updatedAt).append(abbreviation, rhs.abbreviation).append(color, rhs.color).append(minutesPerPeriod, rhs.minutesPerPeriod).append(name, rhs.name).append(periods, rhs.periods).append(slug, rhs.slug).append(sport, rhs.sport).isEquals();
    }

}
