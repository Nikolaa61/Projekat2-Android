package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DogadjajViewModel extends AndroidViewModel {
    private DogadjajRepository repository;
    private LiveData<List<Dogadjaj>> sviDogadjaji;

    public DogadjajViewModel(@NonNull Application application){
        super(application);
        repository = new DogadjajRepository(application);
        sviDogadjaji = repository.getSviDogadjaji();
    }

    public void insert(Dogadjaj dogadjaj){
        repository.insert(dogadjaj);
    }

    public LiveData<List<Dogadjaj>> getSviDogadjaji(){
        return sviDogadjaji;
    }

    public void removeDogadjaj(Dogadjaj dogadjaj){
        repository.delete(dogadjaj);
    }
}
