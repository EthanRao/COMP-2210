/**
 * HandoutExamples.java
 * Generates the examples in the assignment handout.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2018-01-15
 *
 */
public class HandoutExamples {

   /** Drives execution. */
   public static void main(String[] args) {
      int[] a1 = {2, 8, 7, 3, 4};
      int[] a2 = {5, 9, 1, 7, 3};
      int[] a3 = {8, 7, 6, 5, 4};
      int[] a4 = {2, 8, 8, 7, 3, 3, 4};
   
           System.out.println();
   }

   /**
    * Creates a string representation of an array.
    * @param  a the provided array
    * @return   a string representation of array a
    */
   static String toString(int[] a) {
      StringBuilder s = new StringBuilder();
      s.append("[");
      for (int i : a) {
         s.append(i + ", ");
      }
      s.delete(s.length() - 2, s.length());
      s.append("]");
      return s.toString();
   }
}

/* RUNTIME OUTPUT

[2, 8, 7, 3, 4] min = 2
[5, 9, 1, 7, 3] min = 1
[8, 7, 6, 5, 4] min = 4
[2, 8, 8, 7, 3, 3, 4] min = 2

[2, 8, 7, 3, 4] max = 8
[5, 9, 1, 7, 3] max = 9
[8, 7, 6, 5, 4] max = 8
[2, 8, 8, 7, 3, 3, 4] max = 8

[2, 8, 7, 3, 4] 1 kmin = 2
[5, 9, 1, 7, 3] 3 kmin = 5
[8, 7, 6, 5, 4] 5 kmin = 8
[2, 8, 8, 7, 3, 3, 4] 3 kmin = 4

[2, 8, 7, 3, 4] 1 kmax = 8
[5, 9, 1, 7, 3] 3 kmax = 5
[8, 7, 6, 5, 4] 5 kmax = 4
[2, 8, 8, 7, 3, 3, 4] 3 kmax = 4

[2, 8, 7, 3, 4] 1,5 range = [2, 3, 4]
[5, 9, 1, 7, 3] 3,5 range = [5, 3]
[8, 7, 6, 5, 4] 4,8 range = [8, 7, 6, 5, 4]
[2, 8, 8, 7, 3, 3, 4] 3,7 range = [7, 3, 3, 4]

[2, 8, 7, 3, 4] 1 ceiling = 2
[5, 9, 1, 7, 3] 7 ceiling = 7
[8, 7, 6, 5, 4] 0 ceiling = 4
[2, 8, 8, 7, 3, 3, 4] 5 ceiling = 7

[2, 8, 7, 3, 4] 6 floor = 4
[5, 9, 1, 7, 3] 1 floor = 1
[8, 7, 6, 5, 4] 9 floor = 8
[2, 8, 8, 7, 3, 3, 4] 5 floor = 4

*/

