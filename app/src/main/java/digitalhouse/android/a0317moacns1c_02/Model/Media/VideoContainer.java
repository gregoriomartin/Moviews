package digitalhouse.android.a0317moacns1c_02.Model.Media;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by forev on 17-Jun-17.
 */

public class VideoContainer implements Serializable {

    private Integer id;
    @SerializedName("results")
    private List<Video> videos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public String getIDVideo(Integer position){
        return videos.get(position).getKey();
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public ArrayList<String> getYouTubeURLs(){
        ArrayList<String> rtnList = new ArrayList<>();
        for(Video video : videos){
            rtnList.add(video.getYoutubeVideoURL());
        }
        return rtnList;
    }

    public ArrayList<String> getYouTubeThumbnailURLs(){
        ArrayList<String> ThumbnailURLList = new ArrayList<>();
        for(Video video : videos){
            ThumbnailURLList.add(video.getYouTubeThumbnailURL());
        }
        return ThumbnailURLList;
    }
}
