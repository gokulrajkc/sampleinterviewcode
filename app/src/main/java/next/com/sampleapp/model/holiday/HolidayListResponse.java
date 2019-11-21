package next.com.sampleapp.model.holiday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HolidayListResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("holiday_information")
        @Expose
        private String holidayInformation;
        @SerializedName("holiday_name")
        @Expose
        private String holidayName;
        @SerializedName("holiday_date")
        @Expose
        private String holidayDate;

        public String getHolidayInformation() {
            return holidayInformation;
        }

        public void setHolidayInformation(String holidayInformation) {
            this.holidayInformation = holidayInformation;
        }

        public String getHolidayName() {
            return holidayName;
        }

        public void setHolidayName(String holidayName) {
            this.holidayName = holidayName;
        }

        public String getHolidayDate() {
            return holidayDate;
        }

        public void setHolidayDate(String holidayDate) {
            this.holidayDate = holidayDate;
        }

    }

}
