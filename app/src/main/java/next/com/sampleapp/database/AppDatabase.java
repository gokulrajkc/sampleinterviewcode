package next.com.sampleapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import next.com.sampleapp.database.dao.UserDao;
import next.com.sampleapp.database.model.UserTable;

@Database(entities = {UserTable.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
