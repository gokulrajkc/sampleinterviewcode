package next.com.sampleapp.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import next.com.sampleapp.database.model.UserTable;

@Dao
public interface UserDao {
    @Query("SELECT * FROM usertable")
    List<UserTable> getAll();

    @Insert
    void insertAll(UserTable userTable);

    /*@Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);*/
}


