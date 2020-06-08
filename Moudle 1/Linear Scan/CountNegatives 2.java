/**
 * Applies the linear scan strategy to counting the number of negative
 * values in an array.
 *
 * @author Xi Rao
 * @version 2019-01-15
 */
public class CountNegatives {

   /**
    * Returns the number of negative values in the given array.
    */
   public static int countNegatives(int[]a) {
      int countNegative = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] < 0) {
            countNegative++;
         }
      }
      return countNegative;
   }
}
