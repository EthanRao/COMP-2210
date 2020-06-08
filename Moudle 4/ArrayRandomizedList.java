import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;
/**
 * ArrayRandomizedList.java. 
 * Uses arrays to create a list with order defined as "random
 * order." The order described by a radomized list is "random" in the sense
 * that the element accessed by either the sample or remove method is selected
 * uniformly at random from the current elements in the list. In addition, an
 * iterator on a randomized list will sequentially access each element in some
 * uniformly random sequence. Simultaneous iterators on the same randomized
 * list are independent of each other. That is, they will with high probability
 * have different iteration sequences.
 * 
 * @author   Xi Rao (xzr0005@auburn.edu)
 * @version  Mar.4.2019
 */
public class ArrayRandomizedList<T> implements RandomizedList<T>{
   private T[] elements;
   private int size;
   private static final int DEFAULT_CAPACITY = 5;
   /**
   * Default constructor
   */
   public ArrayRandomizedList() {
      this(DEFAULT_CAPACITY);
   }
   
   /**
   * Constructor
   */
   @SuppressWarnings("unchecked") 
   public ArrayRandomizedList(int capacity) { 
      elements = (T[]) new Object[capacity];
      size = 0;
   }
   
    /**
    * Return
    */
   public int size() {
      return size;
   }
 
   /**
    * Return
    */
   public boolean isEmpty() {
      return size == 0;
   }
    
   /**
    * Adds the specified element to this list. If the element is null, this
    * method throws an IllegalArgumentException.
    */
   public void add(T element){ 
      if (element == null)
      {
         throw new IllegalArgumentException();
      }
      if (size == elements.length)
      {
         resize(elements.length*2);
      }
      elements[size] = element;
      size++;
   }
  
   /**
    * Selects and removes an element selected uniformly at random from the
    * elements currently in the list. If the list is empty this method returns
    * null.
    */
   public T remove() {
      if (this.isEmpty()) {
         return null;
      }
      Random rand = new Random();
      int value = rand.nextInt(size); 
      T removed = elements[value]; 
      elements[value] = null; 
      if (value != (size-1)) { 
         elements[value] = elements[size-1];
         elements[size-1] = null;
      }
      size --; 
      if (size > 0 && size < elements.length / 4) {
         resize(elements.length/2);
      }
      return removed;
   }
   
   /**
    * Selects but does not remove an element selected uniformly at random from
    * the elements currently in the list. If the list is empty this method
    * return null.
    */
   public T sample() {
      if (this.isEmpty()) {
         return null;
      }
      Random rand = new Random();
      int value = rand.nextInt(size); 
      return elements[value];
   }
   
   /**
    * Creates and returns
    */
   public Iterator<T> iterator() {
      return new ArrayIterator(elements, size);
   }
   
   /**
   * Resizes an array
   */   
   private void resize(int capacity) {
      T[] a = (T[]) new Object[capacity];
      for (int i = 0; i < size(); i ++) {
         a[i] = elements[i];
      }
      elements = a;
   }
   
  /** 
   * Make an iterator.
   */
   public class ArrayIterator<T> implements Iterator<T> {
      private T[] items; 
      private int length; 
      /**
      * Constructor
      */
      public ArrayIterator(T[] elements, int sizeIn) {
         items = elements;
         length = sizeIn;
      }
      
      /**
      * Next element
      */
      public boolean hasNext() {
         return (length > 0);
      }
      
      /**
      * Remove
      */
      public void remove() {
         throw new UnsupportedOperationException();
      }
      
      /**
      * Return 
      */
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         Random rand = new Random();
         int value = rand.nextInt(length); 
         T next = items[value]; 
         if (value != (length-1)) { 
            items[value] = items[length-1];
            items[length-1] = next;
         }
         length--;
         return next;
      }
   }
}
