package challenges;

import java.util.Arrays;

public class BinarySearch
{
    public static boolean find( int x, int[] array )
    {
        if( array.length == 0 ) {
            return false;
        }
        Arrays.sort( array );

        final boolean found = binarySearch( x, array, 0, array.length );

        return found;
    }

    private static boolean binarySearch( int x, int[] array, int l, int r )
    {
        int mid = ( r - l ) / 2;
        if( x == array[mid] ) {
            return true;
        } else if( mid == 0 ) {
            return false;
        } else if( x < array[mid] ) {
            return binarySearch( x, array, l, mid );
        } else {
            return binarySearch( x, array, mid + 1, r );
        }

    }
}
