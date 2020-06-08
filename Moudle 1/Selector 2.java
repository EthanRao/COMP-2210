import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Xi Rao (YOU@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  01.24.2019
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int min = a[0];
     
      for (int i = 1; i < a.length; i++) {
         if (a[i] < min) {
            min = a[i];
         }
      }
      return min;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int max = a[0];
     
      for (int i = 1; i < a.length; i++) {
         if (a[i] > max) {
            max = a[i];
         }
      }
      return max;     
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      else {
         k--;
         int[] b = Arrays.copyOf(a, a.length);
         Arrays.sort(b);
         
         int rx = 0;
         for (int i = 1; i <= k; i++) {
            if (k >= b.length) {
               throw new IllegalArgumentException();
            }
            if (b[rx] == b[i]) {
               k++;
            }
            rx++;
         }
         if (k >= b.length) {
            throw new IllegalArgumentException();
         }
         return b[k];
      
      }
   }



   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      else {
         int[] b = Arrays.copyOf(a, a.length);
         Arrays.sort(b);
         k--;
         
         int[] c = new int[b.length];
         int r = c.length - 1;
         for (int i:b) {
            if (r >= 0) {
               c[r] = i;
               r--;
            }
         }
         
         int rx = 0;
         for (int i = 1; i <= k; i++) {
            if (k >= b.length) {
               throw new IllegalArgumentException();
            }
            if (c[rx] == c[i]) {
               k++;
            }
            rx++;
         }
         
         if (k >= b.length) {
            throw new IllegalArgumentException();
         }
         return c[k];
      
      }
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      else {
         int rx = 0;
         for (int i:a) {
            if (i >= low && i <= high) {
               rx++;
            }
         }
         int[] b = new int[rx];
         int j = 0;
         for (int i:a) {
            if (i >= low && i <= high) {
               b[j] = i;
               j++;
            }
         }
         return b;
      }
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0 || key > max(a)) {
         throw new IllegalArgumentException();
      }
      else {
         int[] b = new int[a.length];
         int rx1 = 0;
         int rx2 = 0;
         for (int i:a) {
            b[rx1] = key - i;
            rx1++;
         }
         for (int i:b) {
            if (i <= 0) {
               rx2++;
            }
         }
         int[] c = new int[rx2];
         int r = 0;
         for (int i:b) {
            if (i <= 0) {
               c[r] = i;
               r++;
            }
         }
         int max = c[0];
         for (int i:c) {
            if (i > max) {
               max = i;
            }
         }
         return key - max;
      }
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0 || key < min(a)) {
         throw new IllegalArgumentException();
      }
      else {
         int[] b = new int[a.length];
         int rx1 = 0;
         int rx2 = 0;
         for (int i:a) {
            b[rx1] = key - i;
            rx1++;
         }
         for (int i:b) {
            if (i >= 0) {
               rx2++;
            }
         }
         int[] c = new int[rx2];
         int r = 0;
         for (int i:b) {
            if (i >= 0) {
               c[r] = i;
               r++;
            }
         }
         int min = c[0];
         for (int i:c) {
            if (i < min) {
               min = i;
            }
         }
         return key - min;
      }
   }

}

