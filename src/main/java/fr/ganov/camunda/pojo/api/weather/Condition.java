package fr.ganov.camunda.pojo.api.weather;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Condition {
    @JsonProperty("text")
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    String text;
    @JsonProperty("icon")
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    String icon;
    @JsonProperty("code")
    public int getCode() {
        return this.code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    int code;
}
