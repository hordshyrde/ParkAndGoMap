package textSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiOutput {

    @SerializedName("input_index")
    @Expose
    private Integer inputIndex;
    @SerializedName("candidate_index")
    @Expose
    private Integer candidateIndex;
    @SerializedName("delivery_line_1")
    @Expose
    private String deliveryLine1;
    @SerializedName("last_line")
    @Expose
    private String lastLine;
    @SerializedName("delivery_point_barcode")
    @Expose
    private String deliveryPointBarcode;
    @SerializedName("components")
    @Expose
    private Components components;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("analysis")
    @Expose
    private Analysis analysis;

    /**
     * No args constructor for use in serialization
     *     
*/
    public ApiOutput() {
    }

    /**
     *
     * @param lastLine
     * @param candidateIndex
     * @param deliveryPointBarcode
     * @param inputIndex
     * @param components
     * @param analysis
     * @param deliveryLine1
     * @param metadata
     */
    public ApiOutput(Integer inputIndex, Integer candidateIndex, String deliveryLine1, String lastLine, String deliveryPointBarcode, Components components, Metadata metadata, Analysis analysis) {
        super();
        this.inputIndex = inputIndex;
        this.candidateIndex = candidateIndex;
        this.deliveryLine1 = deliveryLine1;
        this.lastLine = lastLine;
        this.deliveryPointBarcode = deliveryPointBarcode;
        this.components = components;
        this.metadata = metadata;
        this.analysis = analysis;
    }

    public Integer getInputIndex() {
        return inputIndex;
    }

    public void setInputIndex(Integer inputIndex) {
        this.inputIndex = inputIndex;
    }

    public Integer getCandidateIndex() {
        return candidateIndex;
    }

    public void setCandidateIndex(Integer candidateIndex) {
        this.candidateIndex = candidateIndex;
    }

    public String getDeliveryLine1() {
        return deliveryLine1;
    }

    public void setDeliveryLine1(String deliveryLine1) {
        this.deliveryLine1 = deliveryLine1;
    }

    public String getLastLine() {
        return lastLine;
    }

    public void setLastLine(String lastLine) {
        this.lastLine = lastLine;
    }

    public String getDeliveryPointBarcode() {
        return deliveryPointBarcode;
    }

    public void setDeliveryPointBarcode(String deliveryPointBarcode) {
        this.deliveryPointBarcode = deliveryPointBarcode;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

}
