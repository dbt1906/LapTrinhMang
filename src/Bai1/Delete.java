package Bai1;

import java.io.File;
import java.util.Arrays;

public class Delete {
//	1.	Bài 1: (1)Hiện thực hàm boolean delete(String path) 
//	xóa tất cả những gì có thể trong thư mục được chỉ định bởi path; trả về true nếu xóa thành công, 
//	false nếu xóa không thành công

	public static boolean delete(String path) {
		File file = new File(path);
		boolean re = false;
		File[] files = file.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					re = delete(f.getPath());
				} else {
					re = f.delete();
				}
			}
		}
		re = file.delete();
		return re;
	}

//	Mở rộng: Chỉ xóa files giữa nguyên cấu trúc thư mục
	public static boolean deleteKeepTreeStructure(String path) {
		File file = new File(path);
		boolean re = false;
		File[] files = file.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					re = deleteKeepTreeStructure(f.getPath());
				} else {
					re = f.delete();
				}
			}
		}
		return re;
	}

	public static void main(String[] args) {
		String path = "D:\\ltm\\Test\\Chapter 1_Bài 1\\testB1";
		System.out.println(deleteKeepTreeStructure(path));
	}
}
