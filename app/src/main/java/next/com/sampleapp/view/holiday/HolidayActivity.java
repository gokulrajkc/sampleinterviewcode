package next.com.sampleapp.view.holiday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

import next.com.sampleapp.R;
import next.com.sampleapp.model.holiday.HolidayDao;
import next.com.sampleapp.model.holiday.HolidayListRequest;
import next.com.sampleapp.model.holiday.HolidayListResponse;
import next.com.sampleapp.model.rejection.RejectionDao;
import next.com.sampleapp.model.rejection.RejectionResponse;
import next.com.sampleapp.util.NetworkInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayActivity extends AppCompatActivity {

    RecyclerView holidayRecyclerView;

    HolidayDao holidayDao;
    RejectionDao rejectionDao;

    ArrayList<HolidayListResponse.Datum> holidayList;
    HolidayAdapter holidayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);

        getViewCasting();
    }

    public void getViewCasting(){
        holidayRecyclerView = findViewById(R.id.holiday_recyclerview);

        holidayDao = NetworkInstance.getClient().create(HolidayDao.class);
        rejectionDao = NetworkInstance.getClient().create(RejectionDao.class);
        holidayListApi();
        getRejectionList();
    }

    public void holidayListApi(){

        /**
         POST
         **/
        HolidayListRequest holidayListRequest = new HolidayListRequest();
        holidayListRequest.setYear("2019");
        holidayListRequest.setOrganization(2);
        holidayListRequest.setOrganizationUnit(7);

        Call<HolidayListResponse> call3 = holidayDao.getHolidayList(holidayListRequest);
        call3.enqueue(new Callback<HolidayListResponse>() {
            @Override
            public void onResponse(Call<HolidayListResponse> call, Response<HolidayListResponse> response) {
                Log.d("kajlwwww ",new Gson().toJson(response.body().getData()));
                holidayList = new ArrayList<HolidayListResponse.Datum>();
                holidayList.addAll(response.body().getData());
                holidayAdapter = new HolidayAdapter(holidayList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                holidayRecyclerView.setLayoutManager(mLayoutManager);
                holidayRecyclerView.setItemAnimator(new DefaultItemAnimator());
                holidayRecyclerView.addItemDecoration(new DividerItemDecoration(holidayRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
                holidayRecyclerView.setAdapter(holidayAdapter);

            }

            @Override
            public void onFailure(Call<HolidayListResponse> call, Throwable t) {
                call.cancel();
            }
        });

    }

    public void getRejectionList(){

        /**
         GET
         **/
        Call<RejectionResponse> call2 = rejectionDao.getRejectionList();
        call2.enqueue(new Callback<RejectionResponse>() {
            @Override
            public void onResponse(Call<RejectionResponse> call, Response<RejectionResponse> response) {

                Log.d("kjuyutvgb ---------- ",new Gson().toJson(response.body().getData()));

            }

            @Override
            public void onFailure(Call<RejectionResponse> call, Throwable t) {
                call.cancel();
            }
        });

    }


}
