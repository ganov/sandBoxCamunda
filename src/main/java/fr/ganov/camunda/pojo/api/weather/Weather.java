package fr.ganov.camunda.pojo.api.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
    @JsonProperty("location")
    public Location getLocation() {
        return this.location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    Location location;
    @JsonProperty("current")
    public Current getCurrent() {
        return this.current;
    }
    public void setCurrent(Current current) {
        this.current = current;
    }
    Current current;

}
