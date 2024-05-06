package aiss.restclient.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aiss.restclient.model.Youtube.channel.Channel;
import aiss.restclient.model.Youtube.channel.ChannelSearch;
import aiss.restclient.model.Youtube.channel.ChannelSnippet;
import aiss.restclient.model.Youtube.videoSnippet.VideoSnippet;
import aiss.restclient.service.YoutubeService;
import aiss.restclient.model.VideoM.VideoChannel;

@Controller
@RequestMapping("/api/")
public class YoutubeController {
    
    //@Autowired
    YoutubeService youtubeService = new YoutubeService();

    @PostMapping("/{id}")
    public VideoChannel post(@PathVariable String id) {
        String token = "1a91f47a52a63df97b35f0694c7bf4cb";
        String part = "snippet,contentDetails,statistics";
        ChannelSearch channelSearch = youtubeService.getChannelWithId(token, part, id);
        for (Channel channel: channelSearch.getItems()) {
            ChannelSnippet channelSnippet = channel.getSnippet();
            List<VideoSnippet> videoSnippet = channel.getVideos();
            VideoChannel videoChannel = new VideoChannel(channelSnippet.getTitle(), 
            channelSnippet.getDescription(), channelSnippet.getPublishedAt());
        }
        
    }

}
