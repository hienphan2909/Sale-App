package qlbh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import qlbh.Models.ProductModel;
import qlbh.Services.ProductService;
import qlbh.iServices.iProductService;

public class Application {

	static int option;

	public static void doCountinue(String stringOption) {
		if (stringOption.equals("yes")) {
			option = 100;
		} else if (stringOption.equals("no")) {
			System.out.println("exit program successful");
			System.exit(0);
		}
	}

	public static String inputNuocsx() {
		System.out.println("Nhập tên nước sản xuất");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String nuocsx = input.toLowerCase();
		String words[] = nuocsx.split("\\s");
		String capitalizeWord = "";
		for (String w : words) {
			String first = w.substring(0, 1);
			String afterfirst = w.substring(1);
			capitalizeWord += first.toUpperCase() + afterfirst + " ";
		}
		return capitalizeWord.trim();
	}

	public static ProductModel inputMasp() {
		Scanner sc = new Scanner(System.in);
		ProductModel proModel = new ProductModel();

		System.out.println("Nhập mã sản phẩm");
		String masp = sc.nextLine();
		proModel.setMasp(masp);

		System.out.println("Nhập tên sản phẩm");
		String tensp = sc.nextLine();
		proModel.setTensp(tensp);

		System.out.println("Nhập đơn vị tính sản phẩm");
		String dvt = sc.nextLine();
		proModel.setDvt(dvt);

		System.out.println("Nhập nước sản xuất");
		String nuocsx = sc.nextLine();
		proModel.setNuocsx(nuocsx);

		System.out.println("Nhập giá sản phẩm");
		Long gia = sc.nextLong();
		proModel.setGia(gia);

		return proModel;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Mời bạn chọn hành động...");
			System.out.println("1. Hiện tất cả sản phẩm");
			System.out.println("2. Hiện sản phẩm theo nước sản xuất");
			System.out.println("3. Tạo sản phẩm mới");
			System.out.println("4. delete a news!");
			System.out.println("0. enter 0 to stop");
			option = sc.nextInt();
			String stringOption;
			iProductService proService = new ProductService();
			switch (option) {
			case 0:
				System.out.println("exiting program....");
				System.exit(0);
				break;
			case 1:
				try {
					System.out.println("Loading.......");
					List<ProductModel> dataPro = new ArrayList<ProductModel>();
					dataPro = proService.findAll();
					for (ProductModel data : dataPro) {
						System.out.println("Mã sản phẩm: " + data.getMasp());
						System.out.println("Tên sản phẩm: " + data.getTensp());
						System.out.println("Đơn vị tính: " + data.getDvt());
						System.out.println("Nước sản xuất: " + data.getNuocsx());
						System.out.println("Giá sản phẩm: " + data.getGia());

						System.out.println("------------------");
					}
					System.out.println("**********");

					Thread.sleep(500);

					System.err.println("do you wanna countinue?");
					System.out.println("yes or no");
					stringOption = sc.next();
					doCountinue(stringOption);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:

				try {

					String nuocsx = inputNuocsx();
					System.out.println("Loading.......");
					List<ProductModel> dataProByCountry = new ArrayList<ProductModel>();
					dataProByCountry = proService.findByCountry(nuocsx);
					for (ProductModel data : dataProByCountry) {
						System.out.println("Mã sản phẩm: " + data.getMasp());
						System.out.println("Tên sản phẩm: " + data.getTensp());
						System.out.println("Đơn vị tính: " + data.getDvt());
						System.out.println("Nước sản xuất: " + data.getNuocsx());
						System.out.println("Giá sản phẩm: " + data.getGia());

						System.out.println("------------------");
					}
					System.out.println("**********");

					Thread.sleep(500);

					System.err.println("do you wanna countinue?");
					System.out.println("yes or no");
					stringOption = sc.next();
					doCountinue(stringOption);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;
			case 3:
				try {
					System.out.println("Tạo sản phẩm...");

					System.out.println("-------------------");

					proService.createOne(inputMasp());

					Thread.sleep(1000);

					System.err.println("do you wanna countinue?");
					System.out.println("yes or no");
					stringOption = sc.next();
					doCountinue(stringOption);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println("input id you want to delete");
					int idDelete = sc.nextInt();
					Thread.sleep(500);
//					newsSer.deleteNews(idDelete);

					System.out.println("delete successful");
					Thread.sleep(500);
					System.err.println("do you wanna countinue?");
					System.out.println("yes or no");
					stringOption = sc.next();
					doCountinue(stringOption);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			default:
				System.out.println("retype your option");
				break;

			}
		}

	}

}
