package next.com.sampleapp.model.rejection;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RejectionDao {

    @GET("reject_dropdown_mobile")
    Call<RejectionResponse> getRejectionList();
}
