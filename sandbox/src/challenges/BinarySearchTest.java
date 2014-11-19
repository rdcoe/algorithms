package challenges;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest
{
    @Test
    public void testFindValueReturnsFalseWhenArrayEmpty()
    {
        int[] input = {};

        boolean found = BinarySearch.find( 6, input );
        Assert.assertFalse( "should not have found value in array.", found );
    }

    @Test
    public void testFindValueInUnsortedArrayNoDuplicates()
    {
        int[] input = {4, 3, 6, 9, 2, 10, 7};

        boolean found = BinarySearch.find( 6, input );
        Assert.assertTrue( "should have found value in array.", found );
    }

    @Test
    public void testFindValueInUnsortedArrayWithDuplicates()
    {
        int[] input = {4, 3, 6, 9, 2, 10, 7, 5, 6, 7, 9};

        boolean found = BinarySearch.find( 6, input );
        Assert.assertTrue( "should have found value in array.", found );
    }

    @Test
    public void testFindValueReturnsFalseWhenElementNotInArray()
    {
        int[] input = {2, 4, 6, 8};

        boolean found = BinarySearch.find( 5, input );
        Assert.assertFalse( "should not have found value in array.", found );
    }

    @Test
    public void testFindValueReturnsTrueWhenElementInEvenArray()
    {
        int[] input = {2, 4, 6, 8};

        boolean found = BinarySearch.find( 4, input );
        Assert.assertTrue( "should have found value in array.", found );
    }
}
