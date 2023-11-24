package AutoTest;

import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        findNumber();
    }
    public static void bubbleSort() {
        int [] arr = {5, 2, 7, 3, 4, 1};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp;
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Mang da sap xep: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static String printTitle(int soThang) {
        if ( 6 <= soThang && soThang <= 24) {
            return "Junior";
        } else if ( 0 < soThang && soThang < 6) {
            return "Fresher";
        } else if ( 24 < soThang && soThang <=48 ) {
            return "Senior";
        } else if (soThang > 48) {
            return "Special list";
        } else return "Undefined title";
    }

    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so phan tu mang: ");
        int n = scanner.nextInt();
        int[] mang = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phan tu thu " + (i+1));
            int phanTu = scanner.nextInt();
            mang[i] = phanTu;
        }
        return mang;
    }
    public static void findNumber() {
        int[] array = inputArray();
        for(int i = 0; i < array.length; i++) {
            if (array[i] % 2== 0 && array[i] % 3== 0) {
                System.out.println("Dieu kien thoat xay ra");
                return;
            }
        }
    }

}