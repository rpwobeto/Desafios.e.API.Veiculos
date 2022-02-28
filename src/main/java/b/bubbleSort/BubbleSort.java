package b.bubbleSort;

public class BubbleSort {

    public static void bubbleSort(int[] arrayInt) {
        for (int i = 0; i < arrayInt.length-1; i++) {
            for (int j = 0; j < arrayInt.length-i-1; j++) {
                if (arrayInt[j] > arrayInt[j+1]) {
                    int Swap = arrayInt[j];
                    arrayInt[j] = arrayInt[j+1];
                    arrayInt[j+1] = Swap;
                }
            }
        }
    }
}
