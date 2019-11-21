package next.com.sampleapp.view.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import next.com.sampleapp.R;
import next.com.sampleapp.databinding.ActivityUserBinding;
import next.com.sampleapp.model.User;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding activityUserBinding;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);

        user = new User();
        activityUserBinding.setUser(user);

        //user.setName("ashgdhsh");
        //user.setEmail("aoieopw@ksjdk.kos");




    }

    public void initBinding(User user){

        System.out.println("kjsssssssss ----------- "+" ------------ "+user.getName()+"----------iuw--------------- "+user.getEmail());

    }

}
