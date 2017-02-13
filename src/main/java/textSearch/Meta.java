package textSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("lines")
    @Expose
    private Integer lines;
    @SerializedName("unicode")
    @Expose
    private Boolean unicode;
    @SerializedName("address_count")
    @Expose
    private Integer addressCount;
    @SerializedName("verified_count")
    @Expose
    private Integer verifiedCount;
    @SerializedName("bytes")
    @Expose
    private Integer bytes;
    @SerializedName("character_count")
    @Expose
    private Integer characterCount;

    /**
     * No args constructor for use in serialization
     *     
*/
    public Meta() {
    }

    /**
     *
     * @param verifiedCount
     * @param bytes
     * @param unicode
     * @param addressCount
     * @param lines
     * @param characterCount
     */
    public Meta(Integer lines, Boolean unicode, Integer addressCount, Integer verifiedCount, Integer bytes, Integer characterCount) {
        super();
        this.lines = lines;
        this.unicode = unicode;
        this.addressCount = addressCount;
        this.verifiedCount = verifiedCount;
        this.bytes = bytes;
        this.characterCount = characterCount;
    }

    public Integer getLines() {
        return lines;
    }

    public void setLines(Integer lines) {
        this.lines = lines;
    }

    public Boolean getUnicode() {
        return unicode;
    }

    public void setUnicode(Boolean unicode) {
        this.unicode = unicode;
    }

    public Integer getAddressCount() {
        return addressCount;
    }

    public void setAddressCount(Integer addressCount) {
        this.addressCount = addressCount;
    }

    public Integer getVerifiedCount() {
        return verifiedCount;
    }

    public void setVerifiedCount(Integer verifiedCount) {
        this.verifiedCount = verifiedCount;
    }

    public Integer getBytes() {
        return bytes;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    public Integer getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(Integer characterCount) {
        this.characterCount = characterCount;
    }

}
