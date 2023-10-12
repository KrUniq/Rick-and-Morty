import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    @JsonProperty("info")
    private Info info;
    @JsonProperty("results")
    private List<Episode> episodes;

    public Info getInfo() {
        return info;
    }
    public List<Episode> getEpisodes() {
        return episodes;
    }
}