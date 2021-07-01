package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimeViewModel extends ViewModel {

    private MutableLiveData<TimeModel> easternStandardTime = new MutableLiveData<>();
    private MutableLiveData<List<String>> cities = new MutableLiveData<>();


    public void invokeCityService(String city) {
        ClockService.getInstance().invokeCityService(city).enqueue(new Callback<TimeModel>() {
            @Override
            public void onResponse(
                    Call<TimeModel> call,
                    Response<TimeModel> response) {

                if (response.isSuccessful()) {
                    easternStandardTime.setValue(response.body());
                }
            }

            @Override
            public void onFailure(
                    Call<TimeModel> call,
                    Throwable t) {

            }
        });
    }

    public LiveData<TimeModel> getEasternStandardTime() {
        return easternStandardTime;
    }
}
