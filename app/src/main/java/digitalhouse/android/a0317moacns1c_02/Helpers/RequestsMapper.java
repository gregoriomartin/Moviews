package digitalhouse.android.a0317moacns1c_02.Helpers;

import java.util.Map;

import digitalhouse.android.a0317moacns1c_02.Model.Requests.MovieSearchRequest;
import digitalhouse.android.a0317moacns1c_02.Model.Requests.PersonSearchRequest;
import digitalhouse.android.a0317moacns1c_02.Model.Requests.SerieSearchRequest;

/**
 * Created by Gregorio Martin on 27/5/2017.
 */

public class RequestsMapper {

    public static Map<String, String> map(MovieSearchRequest movieSearchRequest, Map<String, String> target){
        if(movieSearchRequest.getLenguage() != null)
        target.put("lenguage", movieSearchRequest.getLenguage());

        target.put("query", movieSearchRequest.getQuery());

        if(movieSearchRequest.getPage() != null)
        target.put("page", movieSearchRequest.getPage().toString());

        if(movieSearchRequest.getInclude_adult() != null)
        target.put("include_adult", movieSearchRequest.getInclude_adult().toString());

        if(movieSearchRequest.getRegion() != null)
        target.put("region", movieSearchRequest.getRegion().toString());

        if( movieSearchRequest.getYear() != null)
        target.put("year", movieSearchRequest.getYear().toString());

        if(movieSearchRequest.getPrimary_release_year() != null)
        target.put("primary_release_year", movieSearchRequest.getPrimary_release_year().toString());

        return target;
    }

    public static Map<String, String> map(SerieSearchRequest serieSearchRequest, Map<String, String> target){
        if(serieSearchRequest.getLenguage() != null)
            target.put("lenguage", serieSearchRequest.getLenguage());

        target.put("query", serieSearchRequest.getQuery());

        if(serieSearchRequest.getPage() != null)
            target.put("page", serieSearchRequest.getPage().toString());

        if(serieSearchRequest.getFirst_air_date_year() != null)
            target.put("first_air_date_year", serieSearchRequest.getFirst_air_date_year().toString());

        return target;
    }

    public static Map<String, String> map(PersonSearchRequest personSearchRequest, Map<String, String> target) {
        target.put("query", personSearchRequest.getQuery());
        //TODO: campos que faltan para la query completa
        return target;
    }

}
