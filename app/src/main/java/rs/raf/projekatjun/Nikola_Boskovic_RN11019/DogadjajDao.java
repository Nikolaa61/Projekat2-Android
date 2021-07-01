package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DogadjajDao {
    @Insert
    public long insert(Dogadjaj dogadjaj);

    @Query("SELECT * FROM dogadjaji")
    public LiveData<List<Dogadjaj>> getAll();

    @Delete
    void delete(Dogadjaj... dogadjaj);

}
