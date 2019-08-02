package models;

public class ProductSub_{
	private Integer productId;
	private String product;

	public ProductSub_(Integer productId,String product){
		this.productId = productId;
		this.product = product;
	}

	public void setProductId(Integer productId){
		this.productId = productId;
	}

	public Integer getProductId(){
		return productId;
	}

	public void setProduct(String product){
		this.product = product;
	}

	public String getProduct(){
		return product;
	}
}