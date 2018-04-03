/**
 * 
 */
package tlw.wordCorrection.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author ibrahim
 *
 */
public class AdModel {

	@SerializedName("uid")
	String aduid;
	@SerializedName("data")
	AdInfo info;


	public String getAduid() {
		return aduid;
	}
	public void setAduid(String aduid) {
		this.aduid = aduid;
	}
	public AdInfo getInfo() {
		return info;
	}
	public void setInfo(AdInfo info) {
		this.info = info;
	}
}
