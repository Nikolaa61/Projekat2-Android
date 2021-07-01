package rs.raf.projekatjun.Nikola_Boskovic_RN11019;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Dogadjaj.class}, version = 1, exportSchema = false)
public abstract class MyRoomDatabase extends RoomDatabase {
    private static MyRoomDatabase singletonInstance;

    public abstract DogadjajDao dogadjajDao();

    public static MyRoomDatabase getDatabase(final Context context) {
        if (singletonInstance == null){
            synchronized (MyRoomDatabase.class){
                singletonInstance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        MyRoomDatabase.class,
                        "my_database")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return singletonInstance;
    }
}
