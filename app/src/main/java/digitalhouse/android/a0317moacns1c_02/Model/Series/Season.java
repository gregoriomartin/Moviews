package digitalhouse.android.a0317moacns1c_02.Model.Series;

import java.io.Serializable;

import digitalhouse.android.a0317moacns1c_02.Helpers.ImageHelper;
import digitalhouse.android.a0317moacns1c_02.Model.Credits.Credits;
import digitalhouse.android.a0317moacns1c_02.Model.General.ExternalIDs;
import digitalhouse.android.a0317moacns1c_02.Model.Media.ImagesContainer;
import digitalhouse.android.a0317moacns1c_02.Model.Media.VideoContainer;

/**
 * Created by forev on 19-Jun-17.
 */

public class Season implements Serializable {
    private SeasonDetails seasonDetails;
    private ImagesContainer imagesContainer;
    private VideoContainer videoContainer;
    private Credits credits;
    private ExternalIDs externalIDs;

    public void setSeasonDetails(SeasonDetails seasonDetails) {
        this.seasonDetails = seasonDetails;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    public ExternalIDs getExternalIDs() {
        return externalIDs;
    }

    public void setExternalIDs(ExternalIDs externalIDs) {
        this.externalIDs = externalIDs;
    }

    public ImagesContainer getImagesContainer() {
        return imagesContainer;
    }

    public void setImagesContainer(ImagesContainer imagesContainer) {
        this.imagesContainer = imagesContainer;
    }

    public VideoContainer getVideoContainer() {
        return videoContainer;
    }

    public void setVideoContainer(VideoContainer videoContainer) {
        this.videoContainer = videoContainer;
    }

    public String getPosterUrl(Integer size){
        return ImageHelper.getPosterURL(seasonDetails.posterPath, size);
    }

    public String getOverview(){
        return seasonDetails.getOverview();
    }

    public String getName(){
        return seasonDetails.getName();
    }

    public String getSeasonNumber(){
        return seasonDetails.getSeasonNumber().toString();
    }

    public String getAirDate(){
        return seasonDetails.getAirDate();
    }
}
