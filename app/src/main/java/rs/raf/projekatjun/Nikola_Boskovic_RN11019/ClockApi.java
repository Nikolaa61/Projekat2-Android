package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClockApi {

    @GET("/api/timezone/Europe/Budapest")
    Call<TimeModel> getEasternStandardTimeForBudapest();

    @GET("/api/timezone/Europe/{city}")
    Call<TimeModel> getEasternStandardTimeForRegionAndCity(@Path(value = "city") String myCity);

    @GET("/api/timezone/Europe")
    Call<ArrayList<String>> getCities();

}
