public class BinarySearchRecursive {
    // Metode binary search rekursif
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        // Kasus dasar: elemen tidak ditemukan
        if (low > high) {
            return -1;
        }

        // Cari indeks tengah
        int mid = low + (high - low) / 2;

        // Jika elemen tengah adalah target
        if (arr[mid] == target) {
            return mid;
        }

        // Jika target lebih kecil, cari di setengah kiri
        if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        }

        // Jika target lebih besar, cari di setengah kanan
        return binarySearchRecursive(arr, target, mid + 1, high);
    }

    // Metode wrapper untuk memanggil metode rekursif
    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 23;

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Elemen " + target + " tidak ditemukan dalam array");
        } else {
            System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
        }
    }
}
