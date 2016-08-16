
package com.kbaldauf.playerfinder.model;

import java.util.HashMap;
import java.util.Map;

public class DataManager {

    private Sport sport;
    private Map<String, Roster> rosters = new HashMap<>();

    public boolean hasSportsData() {
        return sport != null;
    }

    public Sport getSportsData() {
        return sport;
    }

    public void setSportsData(Sport sport) {
        this.sport = sport;
    }

    public boolean hasRoster(String slug) {
        return rosters.containsKey(slug);
    }

    public Roster getRoster(String slug) {
        return rosters.get(slug);
    }

    public void addRoster(String slug, Roster roster) {
        rosters.put(slug, roster);
    }

}
