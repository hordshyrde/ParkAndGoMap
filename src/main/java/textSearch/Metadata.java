package textSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("record_type")
    @Expose
    private String recordType;
    @SerializedName("zip_type")
    @Expose
    private String zipType;
    @SerializedName("county_fips")
    @Expose
    private String countyFips;
    @SerializedName("county_name")
    @Expose
    private String countyName;
    @SerializedName("carrier_route")
    @Expose
    private String carrierRoute;
    @SerializedName("congressional_district")
    @Expose
    private String congressionalDistrict;
    @SerializedName("building_default_indicator")
    @Expose
    private String buildingDefaultIndicator;
    @SerializedName("rdi")
    @Expose
    private String rdi;
    @SerializedName("elot_sequence")
    @Expose
    private String elotSequence;
    @SerializedName("elot_sort")
    @Expose
    private String elotSort;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("precision")
    @Expose
    private String precision;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("utc_offset")
    @Expose
    private Integer utcOffset;
    @SerializedName("dst")
    @Expose
    private Boolean dst;

    /**
     * No args constructor for use in serialization
     *     
*/
    public Metadata() {
    }

    /**
     *
     * @param countyFips
     * @param zipType
     * @param precision
     * @param timeZone
     * @param carrierRoute
     * @param dst
     * @param congressionalDistrict
     * @param buildingDefaultIndicator
     * @param countyName
     * @param elotSort
     * @param utcOffset
     * @param elotSequence
     * @param rdi
     * @param longitude
     * @param latitude
     * @param recordType
     */
    public Metadata(String recordType, String zipType, String countyFips, String countyName, String carrierRoute, String congressionalDistrict, String buildingDefaultIndicator, String rdi, String elotSequence, String elotSort, Double latitude, Double longitude, String precision, String timeZone, Integer utcOffset, Boolean dst) {
        super();
        this.recordType = recordType;
        this.zipType = zipType;
        this.countyFips = countyFips;
        this.countyName = countyName;
        this.carrierRoute = carrierRoute;
        this.congressionalDistrict = congressionalDistrict;
        this.buildingDefaultIndicator = buildingDefaultIndicator;
        this.rdi = rdi;
        this.elotSequence = elotSequence;
        this.elotSort = elotSort;
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
        this.timeZone = timeZone;
        this.utcOffset = utcOffset;
        this.dst = dst;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getZipType() {
        return zipType;
    }

    public void setZipType(String zipType) {
        this.zipType = zipType;
    }

    public String getCountyFips() {
        return countyFips;
    }

    public void setCountyFips(String countyFips) {
        this.countyFips = countyFips;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCarrierRoute() {
        return carrierRoute;
    }

    public void setCarrierRoute(String carrierRoute) {
        this.carrierRoute = carrierRoute;
    }

    public String getCongressionalDistrict() {
        return congressionalDistrict;
    }

    public void setCongressionalDistrict(String congressionalDistrict) {
        this.congressionalDistrict = congressionalDistrict;
    }

    public String getBuildingDefaultIndicator() {
        return buildingDefaultIndicator;
    }

    public void setBuildingDefaultIndicator(String buildingDefaultIndicator) {
        this.buildingDefaultIndicator = buildingDefaultIndicator;
    }

    public String getRdi() {
        return rdi;
    }

    public void setRdi(String rdi) {
        this.rdi = rdi;
    }

    public String getElotSequence() {
        return elotSequence;
    }

    public void setElotSequence(String elotSequence) {
        this.elotSequence = elotSequence;
    }

    public String getElotSort() {
        return elotSort;
    }

    public void setElotSort(String elotSort) {
        this.elotSort = elotSort;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Boolean getDst() {
        return dst;
    }

    public void setDst(Boolean dst) {
        this.dst = dst;
    }

}
