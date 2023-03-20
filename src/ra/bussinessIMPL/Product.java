package ra.bussinessIMPL;

import ra.bussiness.IProduct;

import java.util.Scanner;

public class Product implements IProduct,Comparable<Product> {
    Scanner scanner = new Scanner(System.in);
    private int productId;
    private String productName;
    private String tile;
    private String description;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private Boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String tile, String description, float importPrice, float exportPrice, float interest, Boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.tile = tile;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
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

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }



    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        System.out.print("Nhập ID sản phẩm : ");
        this.productId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm : ");
        this.productName = scanner.nextLine();
        System.out.print("Nhập tiêu đề sản phẩm : ");
        this.tile = scanner.nextLine();
        System.out.print("Nhập mô tả sản phẩm : ");
        this.description = scanner.nextLine();
        System.out.print("Nhập giá nhập sản phẩm : ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá xuất sản phẩm : ");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập trạng thái sản phẩm : ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());

        callInterst();
    }
    public void callInterst(){
        this.interest = this.exportPrice - this.importPrice;
    }

    @Override
    public void displayData() {
        System.out.printf("%-10d%-30s%-20s%-30s%-15f%-15f%-15f%-10b\n",this.productId,this.productName,
                this.tile,this.description,this.importPrice,this.exportPrice,this.interest,this.productStatus);
    }

    @Override
    public int compareTo(Product product) {
        return this.productId - product.getProductId();
    }
}
