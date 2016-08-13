
package com.kbaldauf.playerfinder.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Team {

    private String id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private String color;
    private List<String> colors = new ArrayList<String>();
    private String hashtag;
    private List<String> hashtags = new ArrayList<String>();
    private String location;
    private String name;
    private String nickname;
    private double latitude;
    private double longitude;
    private String slug;
    @SerializedName("division_id")
    private String divisionId;
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
     *     The color
     */
    public String getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 
     * @return
     *     The colors
     */
    public List<String> getColors() {
        return colors;
    }

    /**
     * 
     * @param colors
     *     The colors
     */
    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    /**
     * 
     * @return
     *     The hashtag
     */
    public String getHashtag() {
        return hashtag;
    }

    /**
     * 
     * @param hashtag
     *     The hashtag
     */
    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    /**
     * 
     * @return
     *     The hashtags
     */
    public List<String> getHashtags() {
        return hashtags;
    }

    /**
     * 
     * @param hashtags
     *     The hashtags
     */
    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * 
     * @return
     *     The location
     */
    public String getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(String location) {
        this.location = location;
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
     *     The nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 
     * @param nickname
     *     The nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
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
     *     The divisionId
     */
    public String getDivisionId() {
        return divisionId;
    }

    /**
     * 
     * @param divisionId
     *     The division_id
     */
    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
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
        return new HashCodeBuilder().append(id).append(createdAt).append(updatedAt).append(color).append(colors).append(hashtag).append(hashtags).append(location).append(name).append(nickname).append(latitude).append(longitude).append(slug).append(divisionId).append(leagueId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Team)) {
            return false;
        }
        Team rhs = ((Team) other);
        return new EqualsBuilder().append(id, rhs.id).append(createdAt, rhs.createdAt).append(updatedAt, rhs.updatedAt).append(color, rhs.color).append(colors, rhs.colors).append(hashtag, rhs.hashtag).append(hashtags, rhs.hashtags).append(location, rhs.location).append(name, rhs.name).append(nickname, rhs.nickname).append(latitude, rhs.latitude).append(longitude, rhs.longitude).append(slug, rhs.slug).append(divisionId, rhs.divisionId).append(leagueId, rhs.leagueId).isEquals();
    }

}
