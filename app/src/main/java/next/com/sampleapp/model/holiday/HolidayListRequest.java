package next.com.sampleapp.model.holiday;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HolidayListRequest {

    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("organization_unit")
    @Expose
    private Integer organizationUnit;
    @SerializedName("organization")
    @Expose
    private Integer organization;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(Integer organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public Integer getOrganization() {
        return organization;
    }

    public void setOrganization(Integer organization) {
        this.organization = organization;
    }

}
