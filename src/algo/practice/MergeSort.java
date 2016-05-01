package algo.practice;

import java.util.Arrays;

public class MergeSort
{
    public static void main( String... args )
    {
        int[] numbers = new int[100];
        for( int i = 0; i < numbers.length; i++ ) {
            numbers[i] = (int)(Math.random() * 100 );
        }
        
        MergeSort ms = new MergeSort();
        int[] sorted = ms.mergeSort(numbers);
        
        System.out.println( Arrays.toString( numbers ) );
        System.out.println( Arrays.toString( sorted ) );
    }
    
    public int[] mergeSort(int[] in ) {
        if( in.length == 1 ) {
            return in;
        }
                
        int[] out = new int[in.length];
        int splitIndex = in.length / 2;
        int[] lhs = mergeSort( Arrays.copyOfRange( in, 0, splitIndex ) );
        int[] rhs = mergeSort( Arrays.copyOfRange( in, splitIndex, in.length ) );
        
        int i = 0;
        int j = 0;
        int k = 0;
        while( k < out.length ) {
            if( i == lhs.length ) {
                while( j < rhs.length ) {
                    out[k++] = rhs[j++];
                }
            } else if( j == rhs.length ) {
                while( i < lhs.length ) {
                    out[k++] = lhs[i++];
                }
            } else {
                if( lhs[i] <= rhs[j] ) {
                    out[k++] = lhs[i++];
                } else {
                    out[k++] = rhs[j++];
                }
            }
        }
        
        return out;
    }
}
