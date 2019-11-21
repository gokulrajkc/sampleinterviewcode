package next.com.sampleapp.model.rejection;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RejectionResponse {


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

        @SerializedName("reject_reason_name")
        @Expose
        private String rejectReasonName;
        @SerializedName("reject_id")
        @Expose
        private Integer rejectId;

        public String getRejectReasonName() {
            return rejectReasonName;
        }

        public void setRejectReasonName(String rejectReasonName) {
            this.rejectReasonName = rejectReasonName;
        }

        public Integer getRejectId() {
            return rejectId;
        }

        public void setRejectId(Integer rejectId) {
            this.rejectId = rejectId;
        }

    }

}
