package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DogadjajRepository {
    private DogadjajDao dogadjajDao;
    private LiveData<List<Dogadjaj>> sviDogadjaji;

    public DogadjajRepository(Application application){
        MyRoomDatabase database = MyRoomDatabase.getDatabase(application);
        dogadjajDao = database.dogadjajDao();
        sviDogadjaji = dogadjajDao.getAll();
    }

    public void insert(Dogadjaj dogadjaj){

        new Thread(new Runnable() {
            @Override
            public void run() {
                long personId = dogadjajDao.insert(dogadjaj);
            }
        }).start();
    }

    public LiveData<List<Dogadjaj>> getSviDogadjaji() {
        return sviDogadjaji;
    }

    public void delete(Dogadjaj dogadjaj){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dogadjajDao.delete(dogadjaj);
            }
        }).start();

    }
}
