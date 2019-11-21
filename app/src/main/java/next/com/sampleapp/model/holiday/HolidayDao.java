package next.com.sampleapp.model.holiday;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HolidayDao {

    @POST("HolidayList_mobile/")
    Call<HolidayListResponse> getHolidayList(@Body HolidayListRequest holidayListRequest);

}
