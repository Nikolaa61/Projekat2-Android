package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClockService {
    private static ClockService sInstance;
    private static final Object sInstanceLock = new Object();

    ClockApi clockApi;

    private static final String BASE_URL = "https://worldtimeapi.org";

    public static ClockService getInstance(){
        synchronized (sInstanceLock){
            if (sInstance == null){
                sInstance = new ClockService();
            }

            return sInstance;
        }
    }

    private ClockService(){
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(logging);

        OkHttpClient okHttpClient = clientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        clockApi = retrofit.create(ClockApi.class);
    }

    public Call<TimeModel> invokeCityService(String city) {

        Call<TimeModel> call = clockApi.getEasternStandardTimeForRegionAndCity(city);

        return call;
    }
}
