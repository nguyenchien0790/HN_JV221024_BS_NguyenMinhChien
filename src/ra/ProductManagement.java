package ra;

import ra.bussinessIMPL.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    static int index =0;
    static Product[] arrProduct = new Product[1000];

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("     DANH SÁCH SẢN PHẨM     ");
            System.out.println("Chon 1 để nhập số sản phẩm và thông tin sản phẩm");
            System.out.println("Chon 2 hiển thị thông tin sản phẩm");
            System.out.println("Chon 3 để sắp xếp các sản phẩm theo lợi nhuận tăng dần");
            System.out.println("Chon 4 xóa theo mã sản phẩm");
            System.out.println("Chon 5 tìm kiếm theo tên sản phẩm");
            System.out.println("Chon 6 thay đổi trang thái của sản phẩm theo mã sản phẩm");
            System.out.println("Chon 7 Thoát ");
            System.out.print("Mời chọn lựa : ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    inputDataProduct();
                    break;
                case 2:
                    displayDataProduct();
                    break;
                case 3:
                    sortInterstProductASC();
                    break;
                case 4:
                    deleteProductById(scanner);
                    break;
                case 5:
                    searchProductByName(scanner);
                    break;
                case 6:
                    changeStatusProductByID(scanner);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.err.println("Chỉ nhập từ 1 đến 8");

            }
        }while (true);
    }



    public static void changeStatusProductByID(Scanner scanner) {
        System.out.println("Nhap mã sản phẩm cần thay đổi trạng thái : ");
        int checkId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (arrProduct[i].getProductId()==checkId){
                arrProduct[i].setProductStatus(!arrProduct[i].isProductStatus());
            }
        }
        System.out.println("Đã cập nhật trạng thái");
    }

    public static void deleteProductById(Scanner scanner) {
        System.out.println("Nhập mã ID sản phẩm cần xóa");
        int c;
        int checkIdDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (arrProduct[i].getProductId()==checkIdDelete){
                for (int j=c= 0; j < index; i++) {
                    if (arrProduct[j].getProductId() != checkIdDelete) {
                        arrProduct[c] = arrProduct[j];
                        c++;
                    }
                }
                index = c;

                System.out.println("Dánh sách sản phẩm còn lại sau khi xóa sản phẩm có ID : " + checkIdDelete + " là: ");
                System.out.printf("%-10s%-30s%-20s%-30s%-15s%-15s%-15s%-10s\n","Mã SP","Tên Sản Phẩm","Tiêu đề"
                        ,"Mô tả","Giá Nhập","Giá Xuất","Lợi Nhuận","Trạng thái");
                for (int j = 0; j < index; i++) {
                    arrProduct[i].displayData();
                }
            }else {
                System.out.println("Không tìm thấy Id vừa nhập");
            }
        }

    }
    public static void searchProductByName(Scanner scanner) {
        int count =0;
        System.out.print("Nhập tên sản phẩm cần tìm : ");
        String search = scanner.nextLine();
        System.out.printf("%-10s%-30s%-20s%-30s%-15s%-15s%-15s%-10s\n","Mã SP","Tên Sản Phẩm","Tiêu đề"
                ,"Mô tả","Giá Nhập","Giá Xuất","Lợi Nhuận","Trạng thái");
        for (int i = 0; i < index; i++) {
            if(arrProduct[i].getProductName().startsWith(search)){
                arrProduct[i].displayData();
                count++;
            }
        }
        System.out.printf("Đã tìm thấy %d sản phẩm theo tên vừa nhập vào\n",count);
    }

    public static void sortInterstProductASC() {
//          Arrays.sort(arrProduct);
        for (int i = 0; i < index-1; i++) {
            for (int j = 0; j < index; j++) {
                if (arrProduct[i].getInterest()>arrProduct[j].getInterest()){
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] =temp;
                }
            }
        }
        System.out.println("Đã xắp xếp sản phẩm theo lợi nhận tăng dần !");
    }

    public static void displayDataProduct() {
        System.out.printf("%-10s%-30s%-20s%-30s%-15s%-15s%-15s%-10s\n","Mã SP","Tên Sản Phẩm","Tiêu đề"
        ,"Mô tả","Giá Nhập","Giá Xuất","Lợi Nhuận","Trạng thái");
        for (int i = 0; i < index; i++) {
            arrProduct[i].displayData();
        }
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------");
        callInterstProduct();
    }

    public static void callInterstProduct(){
        for (int i = 0; i < index; i++) {
            arrProduct[i].callInterst();
        }
        System.out.println("Đã tính lợi nhuận");
    }

    public static void inputDataProduct() {
        System.out.print("Nhập số lượng sản phẩm cần nhập thông tin: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thôn tin sản phẩm thứ "+(i+1));
            arrProduct[index] =new Product();
            arrProduct[index].inputData();
            index++;
        }
    }



}
