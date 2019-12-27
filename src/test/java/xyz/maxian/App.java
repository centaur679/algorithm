package xyz.maxian;

import org.testng.annotations.Test;

public class App {

    /**
     * 问题：找出数组最小的两个数
     */
    public void findSecondSmallest(int arr[]) {

        int first, second, arr_size = arr.length;

        /* There should be atleast two elements */
        if (arr_size < 2) {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (int i = 0; i < arr_size; i++) {
            /* If current element is smaller than first
              then update both first and second */
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and second
               then update second  */
            else if (arr[i] < second && arr[i] != first)
                second = arr[i];
        }
        if (second == Integer.MAX_VALUE)
            System.out.println("There is no second" +
                    "smallest element");
        else
            System.out.println("The smallest element is " +
                    first + " and second Smallest" +
                    " element is " + second);
    }

    @Test
    public void testFindSecondSmallest() {
        int arr[] = {12, 13, 1, 10, 34, 1,-2,0};
        findSecondSmallest(arr);
    }

    /**
     *  Question: Write a C function to find if a given integer x appears more than n/2 times in a sorted array of n integers.
     */
    boolean isMajority(int arr[], int n, int x){
        int i, last_index = 0;

        /* get last index according to n (even or odd) */
        last_index = (n%2==0)? n/2: n/2+1;

        /* search for first occurrence of x in arr[]*/
        for (i = 0; i < last_index; i++)
        {
            /* check if x is present and is present more
               than n/2 times */
            if (arr[i] == x && arr[i+n/2] == x)
                return true;
        }
        return false;
    }

    @Test
    public void testIsMajority(){
        int arr[] = {1,2,2,2,3};
        System.out.println(isMajority(arr,5,2));
    }
}
