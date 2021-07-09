package model;




    public class Product {
        private int productId;
        private String productName;
        private int productPrice;
        private String productColor;
        private int productQuantity;
        private String productDescription;
        private String productImage;
        private int categoryID;

        public Product() {
        }

        public Product(String productName, int productPrice, String productColor, int productQuantity, String productDescription, String productImage, int categoryID) {
            this.productName = productName;
            this.productPrice = productPrice;
            this.productColor = productColor;
            this.productQuantity = productQuantity;
            this.productDescription = productDescription;
            this.productImage = productImage;
            this.categoryID = categoryID;
        }

        public Product(int productId, String productName, int productPrice, String productColor, int productQuantity, String productDescription, String productImage, int categoryID) {
            this.productId = productId;
            this.productName = productName;
            this.productPrice = productPrice;
            this.productColor = productColor;
            this.productQuantity = productQuantity;
            this.productDescription = productDescription;
            this.productImage = productImage;
            this.categoryID = categoryID;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(int productPrice) {
            this.productPrice = productPrice;
        }

        public String getProductColor() {
            return productColor;
        }

        public void setProductColor(String productColor) {
            this.productColor = productColor;
        }

        public int getProductQuantity() {
            return productQuantity;
        }

        public void setProductQuantity(int productQuantity) {
            this.productQuantity = productQuantity;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

        public int getCategoryID() {
            return categoryID;
        }

        public void setCategoryID(int categoryID) {
            this.categoryID = categoryID;
        }
    }


