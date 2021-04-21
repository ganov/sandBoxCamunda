package fr.ganov.camunda.pojo.api.weather;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Location {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    String name;
    @JsonProperty("region")
    public String getRegion() {
        return this.region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    String region;
    @JsonProperty("country")
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    String country;
    @JsonProperty("lat")
    public double getLat() {
        return this.lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    double lat;
    @JsonProperty("lon")
    public double getLon() {
        return this.lon;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }
    double lon;
    @JsonProperty("tz_id")
    public String getTz_id() {
        return this.tz_id;
    }
    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }
    String tz_id;
    @JsonProperty("localtime_epoch")
    public int getLocaltime_epoch() {
        return this.localtime_epoch;
    }
    public void setLocaltime_epoch(int localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }
    int localtime_epoch;
    @JsonProperty("localtime")
    public String getLocaltime() {
        return this.localtime;
    }
    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }
    String localtime;
}
