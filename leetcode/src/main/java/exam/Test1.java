package exam;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-03-01
 **/
public class Test1 {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 2, 2, 1, 3};
        System.out.println("下标：" + removeElement(arr, 2));

    }

    //   3 2 2 1 3    val = 3
//   3 2 2 1 3    val = 2
    public static int removeElement(int arr[], int val) {
        int end = arr.length - 1;
        // 如果当前的值等于指定值 则与数组中最后一个元素替换
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == end) {
                break;
            }
            if (arr[i] == val) {
                int temp = arr[end];
                // 如果最后一个元素也是指定值  则依次下推 并且记录下标
                while (temp == val && end != i) {
                    end--;
                    temp = arr[end];
                }
                arr[end] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
        // 返回下标
        return end;
    }
}
