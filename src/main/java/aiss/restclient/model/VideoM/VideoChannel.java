package aiss.restclient.model.VideoM;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "channel")
public class VideoChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Please provide a name")
    private String name;


    @NotEmpty(message = "Please provide a description")
    @Column(columnDefinition="TEXT")
    private String description;

    @JsonProperty("createdTime")
    @NotEmpty(message = "Please provide a created time")
    private String createdTime;

    @JsonProperty("videos")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "channelId")
    @NotNull(message = "Channel videos cannot be null")
    private List<Video> videos;

    public VideoChannel(){

    }

    public VideoChannel(String name, String description, String createdTime){
        this.name = name;
        this.description = description;
        this.createdTime = createdTime;
        this.videos = new ArrayList<>();
    }

    public VideoChannel(String name, String description, String createdTime, List<Video> videos){
        this.name = name;
        this.description = description;
        this.createdTime = createdTime;
        this.videos = videos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public List<Video> getVideoList() {
        return videos;
    }

    public void setVideoList(List<Video> videoList) {
        this.videos = videoList;
    }
}
