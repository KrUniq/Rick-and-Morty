import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {
    private int id;
    private String name;
    @JsonProperty("air_date")
    private String airDate;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAirDate() {
        return airDate;
    }
    public String getEpisode() {
        return episode;
    }
    public List<String> getCharacters() {
        return characters;
    }
    public List<String> getCharacterUrls() {
        return characters;
    }
    public String getUrl() {
        return url;
    }
    public String getCreated() {
        return created;
    }
}