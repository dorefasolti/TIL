package model.vo;



public class Product {
	//필드부
		private String productId;
		private String productName;
		private int price;
		private String description;
		private int stock;
		
		//생성자부
		public Product() {
			super();
		}
		// 상품 정보 수정용
		public Product(String productId, int price, String description, int stock) {
				super();
				this.productId = productId;
				this.price = price;
				this.description = description;
				this.stock = stock;
			}
		
		public Product(String productId, String productName, int price, String description, int stock) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.price = price;
			this.description = description;
			this.stock = stock;
		}
		//메소드부
		public String getProductId() {
			return productId;
		}
		public void setProductId(String proeuctId) {
			this.productId = proeuctId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		
		//toString
		@Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
					+ ", description=" + description + ", stock=" + stock + "]";
		}
}
