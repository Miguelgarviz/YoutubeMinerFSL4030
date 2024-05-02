package aiss.restclient.service;

import aiss.restclient.model.caption.CaptionSearch;
import aiss.restclient.model.channel.ChannelSearch;
import aiss.restclient.model.comment.CommentSearch;
import aiss.restclient.model.videoSnippet.VideoSnippetSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class YoutubeServiceTest {
    @Autowired
    YoutubeService service;

    @Test
    @DisplayName("Get channels with id")
    void getChannelsWithId() {
        String token = "AIzaSyC0ypA5q3CD-YKibZHLxWK3PhVPgggvlqA";
        String part = "snippet,contentDetails,statistics";
        String id = "UCnQC_XGCCI__qrxwgZS27-A";
        ChannelSearch channel = service.getChannelWithId(token,part,id);
        assertNotNull(channel,"The channel is null");
        System.out.println(channel);
    }

    @Test
    @DisplayName("Get videos")
    void getVideos() {
        String token = "AIzaSyC0ypA5q3CD-YKibZHLxWK3PhVPgggvlqA";
        String part = "snippet%2CcontentDetails";
        String playListId = "UUnQC_XGCCI__qrxwgZS27-A";
        String maxResults = "25";
        VideoSnippetSearch video = service.getVideos(token,part,playListId,maxResults);
        assertNotNull(video,"The video is null");
        System.out.println(video);
    }

    @Test
    @DisplayName("Get captions")
    void getCaptions() {
        String token = "AIzaSyC0ypA5q3CD-YKibZHLxWK3PhVPgggvlqA";
        String part = "snippet";
        String playListId = "UgzDE2tasfmrYLyNkGt4AaABAg";
        CaptionSearch caption = service.getCaptions(token,part,playListId);
        assertNotNull(caption,"The caption is null");
        System.out.println(caption);
    }

    @Test
    @DisplayName("Get comments")
    void getComments() {
        String token = "AIzaSyC0ypA5q3CD-YKibZHLxWK3PhVPgggvlqA";
        String part = "snippet";
        String playListId = "UgzDE2tasfmrYLyNkGt4AaABAg";
        CommentSearch comment = service.getComments(token,part,playListId);
        assertNotNull(comment,"The comment is null");
        System.out.println(comment);
    }
}