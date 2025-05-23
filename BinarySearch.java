public class BinarySearch {
    // Metode binary search iteratif
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Cari indeks tengah
            int mid = low + (high - low) / 2;

            // Jika elemen tengah adalah target
            if (arr[mid] == target) {
                return mid;
            }

            // Jika target lebih kecil, abaikan setengah kanan
            if (arr[mid] > target) {
                high = mid - 1;
            }
            // Jika target lebih besar, abaikan setengah kiri
            else {
                low = mid + 1;
            }
        }

        // Jika target tidak ditemukan
        return -1;
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
