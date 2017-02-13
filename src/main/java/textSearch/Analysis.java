package textSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Analysis {

    @SerializedName("dpv_match_code")
    @Expose
    private String dpvMatchCode;
    @SerializedName("dpv_footnotes")
    @Expose
    private String dpvFootnotes;
    @SerializedName("dpv_cmra")
    @Expose
    private String dpvCmra;
    @SerializedName("dpv_vacant")
    @Expose
    private String dpvVacant;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("footnotes")
    @Expose
    private String footnotes;

    /**
     * No args constructor for use in serialization
     *     
*/
    public Analysis() {
    }

    /**
     *
     * @param active
     * @param dpvFootnotes
     * @param dpvMatchCode
     * @param dpvCmra
     * @param footnotes
     * @param dpvVacant
     */
    public Analysis(String dpvMatchCode, String dpvFootnotes, String dpvCmra, String dpvVacant, String active, String footnotes) {
        super();
        this.dpvMatchCode = dpvMatchCode;
        this.dpvFootnotes = dpvFootnotes;
        this.dpvCmra = dpvCmra;
        this.dpvVacant = dpvVacant;
        this.active = active;
        this.footnotes = footnotes;
    }

    public String getDpvMatchCode() {
        return dpvMatchCode;
    }

    public void setDpvMatchCode(String dpvMatchCode) {
        this.dpvMatchCode = dpvMatchCode;
    }

    public String getDpvFootnotes() {
        return dpvFootnotes;
    }

    public void setDpvFootnotes(String dpvFootnotes) {
        this.dpvFootnotes = dpvFootnotes;
    }

    public String getDpvCmra() {
        return dpvCmra;
    }

    public void setDpvCmra(String dpvCmra) {
        this.dpvCmra = dpvCmra;
    }

    public String getDpvVacant() {
        return dpvVacant;
    }

    public void setDpvVacant(String dpvVacant) {
        this.dpvVacant = dpvVacant;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getFootnotes() {
        return footnotes;
    }

    public void setFootnotes(String footnotes) {
        this.footnotes = footnotes;
    }

}
