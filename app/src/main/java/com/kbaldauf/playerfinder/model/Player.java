
package com.kbaldauf.playerfinder.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Player {

    private String id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private Boolean active;
    @SerializedName("birth_date")
    private String birthDate;
    private String city;
    private String country;
    @SerializedName("draft_season")
    private String draftSeason;
    @SerializedName("draft_round")
    private Integer draftRound;
    @SerializedName("draft_overall_pick")
    private Integer draftOverallPick;
    @SerializedName("draft_team_name")
    private String draftTeamName;
    @SerializedName("first_name")
    private String firstName;
    private String handedness;
    private String bats;
    private Integer height;
    @SerializedName("high_school")
    private Object highSchool;
    @SerializedName("unit_of_height")
    private String unitOfHeight;
    @SerializedName("last_name")
    private String lastName;
    private String name;
    private Object nickname;
    @SerializedName("position_abbreviation")
    private String positionAbbreviation;
    @SerializedName("position_name")
    private String positionName;
    private Integer salary;
    @SerializedName("humanized_salary")
    private String humanizedSalary;
    @SerializedName("salary_currency")
    private String salaryCurrency;
    private Object school;
    private String slug;
    private String sport;
    private Object state;
    private Integer weight;
    @SerializedName("uniform_number")
    private String uniformNumber;
    @SerializedName("unit_of_weight")
    private String unitOfWeight;
    @SerializedName("years_of_experience")
    private Integer yearsOfExperience;
    @SerializedName("pro_debut")
    private Object proDebut;
    @SerializedName("league_id")
    private String leagueId;
    @SerializedName("playing_position_id")
    private String playingPositionId;
    @SerializedName("team_id")
    private String teamId;

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
     *     The active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     *
     * @param active
     *     The active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     *
     * @return
     *     The birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     *     The birth_date
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     *     The draftSeason
     */
    public String getDraftSeason() {
        return draftSeason;
    }

    /**
     *
     * @param draftSeason
     *     The draft_season
     */
    public void setDraftSeason(String draftSeason) {
        this.draftSeason = draftSeason;
    }

    /**
     *
     * @return
     *     The draftRound
     */
    public Integer getDraftRound() {
        return draftRound;
    }

    /**
     *
     * @param draftRound
     *     The draft_round
     */
    public void setDraftRound(Integer draftRound) {
        this.draftRound = draftRound;
    }

    /**
     *
     * @return
     *     The draftOverallPick
     */
    public Integer getDraftOverallPick() {
        return draftOverallPick;
    }

    /**
     *
     * @param draftOverallPick
     *     The draft_overall_pick
     */
    public void setDraftOverallPick(Integer draftOverallPick) {
        this.draftOverallPick = draftOverallPick;
    }

    /**
     *
     * @return
     *     The draftTeamName
     */
    public String getDraftTeamName() {
        return draftTeamName;
    }

    /**
     *
     * @param draftTeamName
     *     The draft_team_name
     */
    public void setDraftTeamName(String draftTeamName) {
        this.draftTeamName = draftTeamName;
    }

    /**
     *
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     *     The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     *     The handedness
     */
    public String getHandedness() {
        return handedness;
    }

    /**
     *
     * @param handedness
     *     The handedness
     */
    public void setHandedness(String handedness) {
        this.handedness = handedness;
    }

    /**
     *
     * @return
     *     The bats
     */
    public String getBats() {
        return bats;
    }

    /**
     *
     * @param bats
     *     The bats
     */
    public void setBats(String bats) {
        this.bats = bats;
    }

    /**
     *
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     *     The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     *     The highSchool
     */
    public Object getHighSchool() {
        return highSchool;
    }

    /**
     *
     * @param highSchool
     *     The high_school
     */
    public void setHighSchool(Object highSchool) {
        this.highSchool = highSchool;
    }

    /**
     *
     * @return
     *     The unitOfHeight
     */
    public String getUnitOfHeight() {
        return unitOfHeight;
    }

    /**
     *
     * @param unitOfHeight
     *     The unit_of_height
     */
    public void setUnitOfHeight(String unitOfHeight) {
        this.unitOfHeight = unitOfHeight;
    }

    /**
     *
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     *     The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public Object getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     *     The nickname
     */
    public void setNickname(Object nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return
     *     The positionAbbreviation
     */
    public String getPositionAbbreviation() {
        return positionAbbreviation;
    }

    /**
     *
     * @param positionAbbreviation
     *     The position_abbreviation
     */
    public void setPositionAbbreviation(String positionAbbreviation) {
        this.positionAbbreviation = positionAbbreviation;
    }

    /**
     *
     * @return
     *     The positionName
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     *
     * @param positionName
     *     The position_name
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     *
     * @return
     *     The salary
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     *     The salary
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     *
     * @return
     *     The humanizedSalary
     */
    public String getHumanizedSalary() {
        return humanizedSalary;
    }

    /**
     *
     * @param humanizedSalary
     *     The humanized_salary
     */
    public void setHumanizedSalary(String humanizedSalary) {
        this.humanizedSalary = humanizedSalary;
    }

    /**
     *
     * @return
     *     The salaryCurrency
     */
    public String getSalaryCurrency() {
        return salaryCurrency;
    }

    /**
     *
     * @param salaryCurrency
     *     The salary_currency
     */
    public void setSalaryCurrency(String salaryCurrency) {
        this.salaryCurrency = salaryCurrency;
    }

    /**
     *
     * @return
     *     The school
     */
    public Object getSchool() {
        return school;
    }

    /**
     *
     * @param school
     *     The school
     */
    public void setSchool(Object school) {
        this.school = school;
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

    /**
     *
     * @return
     *     The state
     */
    public Object getState() {
        return state;
    }

    /**
     *
     * @param state
     *     The state
     */
    public void setState(Object state) {
        this.state = state;
    }

    /**
     *
     * @return
     *     The weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     *     The weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     *     The uniformNumber
     */
    public String getUniformNumber() {
        return uniformNumber;
    }

    /**
     *
     * @param uniformNumber
     *     The uniform_number
     */
    public void setUniformNumber(String uniformNumber) {
        this.uniformNumber = uniformNumber;
    }

    /**
     *
     * @return
     *     The unitOfWeight
     */
    public String getUnitOfWeight() {
        return unitOfWeight;
    }

    /**
     *
     * @param unitOfWeight
     *     The unit_of_weight
     */
    public void setUnitOfWeight(String unitOfWeight) {
        this.unitOfWeight = unitOfWeight;
    }

    /**
     *
     * @return
     *     The yearsOfExperience
     */
    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     *
     * @param yearsOfExperience
     *     The years_of_experience
     */
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     *
     * @return
     *     The proDebut
     */
    public Object getProDebut() {
        return proDebut;
    }

    /**
     *
     * @param proDebut
     *     The pro_debut
     */
    public void setProDebut(Object proDebut) {
        this.proDebut = proDebut;
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

    /**
     *
     * @return
     *     The playingPositionId
     */
    public String getPlayingPositionId() {
        return playingPositionId;
    }

    /**
     *
     * @param playingPositionId
     *     The playing_position_id
     */
    public void setPlayingPositionId(String playingPositionId) {
        this.playingPositionId = playingPositionId;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(createdAt).append(updatedAt).append(active).append(birthDate).append(city).append(country).append(draftSeason).append(draftRound).append(draftOverallPick).append(draftTeamName).append(firstName).append(handedness).append(bats).append(height).append(highSchool).append(unitOfHeight).append(lastName).append(name).append(nickname).append(positionAbbreviation).append(positionName).append(salary).append(humanizedSalary).append(salaryCurrency).append(school).append(slug).append(sport).append(state).append(weight).append(uniformNumber).append(unitOfWeight).append(yearsOfExperience).append(proDebut).append(leagueId).append(playingPositionId).append(teamId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Player) == false) {
            return false;
        }
        Player rhs = ((Player) other);
        return new EqualsBuilder().append(id, rhs.id).append(createdAt, rhs.createdAt).append(updatedAt, rhs.updatedAt).append(active, rhs.active).append(birthDate, rhs.birthDate).append(city, rhs.city).append(country, rhs.country).append(draftSeason, rhs.draftSeason).append(draftRound, rhs.draftRound).append(draftOverallPick, rhs.draftOverallPick).append(draftTeamName, rhs.draftTeamName).append(firstName, rhs.firstName).append(handedness, rhs.handedness).append(bats, rhs.bats).append(height, rhs.height).append(highSchool, rhs.highSchool).append(unitOfHeight, rhs.unitOfHeight).append(lastName, rhs.lastName).append(name, rhs.name).append(nickname, rhs.nickname).append(positionAbbreviation, rhs.positionAbbreviation).append(positionName, rhs.positionName).append(salary, rhs.salary).append(humanizedSalary, rhs.humanizedSalary).append(salaryCurrency, rhs.salaryCurrency).append(school, rhs.school).append(slug, rhs.slug).append(sport, rhs.sport).append(state, rhs.state).append(weight, rhs.weight).append(uniformNumber, rhs.uniformNumber).append(unitOfWeight, rhs.unitOfWeight).append(yearsOfExperience, rhs.yearsOfExperience).append(proDebut, rhs.proDebut).append(leagueId, rhs.leagueId).append(playingPositionId, rhs.playingPositionId).append(teamId, rhs.teamId).isEquals();
    }

}
