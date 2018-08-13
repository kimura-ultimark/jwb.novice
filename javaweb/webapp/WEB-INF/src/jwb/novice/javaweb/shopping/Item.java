package jwb.novice.javaweb.shopping;

import java.math.BigDecimal;

public class Item {
	
	
	private String productCd;
	
	private String productdNm;
	
	private BigDecimal unitPrice;
	
	private String description;
	
	private String productImg;

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public String getProductdNm() {
		return productdNm;
	}

	public void setProductdNm(String productdNm) {
		this.productdNm = productdNm;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
}
