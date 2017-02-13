package textSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Components {

    @SerializedName("primary_number")
    @Expose
    private String primaryNumber;
    @SerializedName("street_predirection")
    @Expose
    private String streetPredirection;
    @SerializedName("street_name")
    @Expose
    private String streetName;
    @SerializedName("street_suffix")
    @Expose
    private String streetSuffix;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("state_abbreviation")
    @Expose
    private String stateAbbreviation;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("plus4_code")
    @Expose
    private String plus4Code;
    @SerializedName("delivery_point")
    @Expose
    private String deliveryPoint;
    @SerializedName("delivery_point_check_digit")
    @Expose
    private String deliveryPointCheckDigit;

    /**
     * No args constructor for use in serialization
     *     
*/
    public Components() {
    }

    /**
     *
     * @param stateAbbreviation
     * @param primaryNumber
     * @param deliveryPoint
     * @param zipcode
     * @param cityName
     * @param deliveryPointCheckDigit
     * @param plus4Code
     * @param streetPredirection
     * @param streetName
     * @param streetSuffix
     */
    public Components(String primaryNumber, String streetPredirection, String streetName, String streetSuffix, String cityName, String stateAbbreviation, String zipcode, String plus4Code, String deliveryPoint, String deliveryPointCheckDigit) {
        super();
        this.primaryNumber = primaryNumber;
        this.streetPredirection = streetPredirection;
        this.streetName = streetName;
        this.streetSuffix = streetSuffix;
        this.cityName = cityName;
        this.stateAbbreviation = stateAbbreviation;
        this.zipcode = zipcode;
        this.plus4Code = plus4Code;
        this.deliveryPoint = deliveryPoint;
        this.deliveryPointCheckDigit = deliveryPointCheckDigit;
    }

    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public void setPrimaryNumber(String primaryNumber) {
        this.primaryNumber = primaryNumber;
    }

    public String getStreetPredirection() {
        return streetPredirection;
    }

    public void setStreetPredirection(String streetPredirection) {
        this.streetPredirection = streetPredirection;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPlus4Code() {
        return plus4Code;
    }

    public void setPlus4Code(String plus4Code) {
        this.plus4Code = plus4Code;
    }

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public String getDeliveryPointCheckDigit() {
        return deliveryPointCheckDigit;
    }

    public void setDeliveryPointCheckDigit(String deliveryPointCheckDigit) {
        this.deliveryPointCheckDigit = deliveryPointCheckDigit;
    }

}
