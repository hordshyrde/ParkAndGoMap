package textSearch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("text")
    @Expose
    private String address;
    @SerializedName("line")
    @Expose
    private Integer line;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("end")
    @Expose
    private Integer end;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("api_output")
    @Expose
    private List<ApiOutput> apiOutput = null;

    /**
     *
     * @param apiOutput
     * @param text
     * @param start
     * @param verified
     * @param line
     * @param end
     */
    public Address(String text, Integer line, Integer start, Integer end, Boolean verified, List<ApiOutput> apiOutput) {
        super();
        this.address = text;
        this.line = line;
        this.start = start;
        this.end = end;
        this.verified = verified;
        this.apiOutput = apiOutput;
    }

    public String getAddress() {
        return address;
    }

    public void getAddress(String address) {
        this.address = address;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public List<ApiOutput> getApiOutput() {
        return apiOutput;
    }

    public void setApiOutput(List<ApiOutput> apiOutput) {
        this.apiOutput = apiOutput;
    }

}
