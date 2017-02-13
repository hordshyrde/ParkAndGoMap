package textSearch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtractResponse {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;

    /**
     * No args constructor for use in serialization
     *     
*/
    public ExtractResponse() {
    }

    /**
     *
     * @param addresses
     * @param meta
     */
    public ExtractResponse(Meta meta, List<Address> addresses) {
        super();
        this.meta = meta;
        this.addresses = addresses;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
