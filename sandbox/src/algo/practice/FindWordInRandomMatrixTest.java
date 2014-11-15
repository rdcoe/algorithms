package algo.practice;

import org.junit.Assert;
import org.junit.Test;

public class FindWordInRandomMatrixTest
{
    @Test
    public void test3x3MatrixWithOneWordTopRow()
    {
        String[][] matrix = Matrix.generateRandomSquareMatrix( 3 );

        String word = "ten";
        char[] letters = word.toCharArray();
        for ( int i = 0; i < word.length(); i++ ) {
            matrix[0][i] = String.valueOf( letters[i] );
        }

        Matrix.print( matrix );
        Assert.assertTrue( Matrix.findWord( matrix, word ) );
    }

    @Test
    public void test3x3MatrixWithOneWordMiddleRow()
    {
        String[][] matrix = Matrix.generateRandomSquareMatrix( 3 );
        Matrix.print( matrix );

        String word = "ten";
        char[] letters = word.toCharArray();
        for ( int i = 0; i < word.length(); i++ ) {
            matrix[1][i] = String.valueOf( letters[i] );
        }

        Assert.assertTrue( Matrix.findWord( matrix, word ) );
    }

    @Test
    public void test3x3MatrixWithOneWordBottomRow()
    {
        String[][] matrix = Matrix.generateRandomSquareMatrix( 3 );

        String word = "ten";
        char[] letters = word.toCharArray();
        for ( int i = 0; i < word.length(); i++ ) {
            matrix[2][i] = String.valueOf( letters[i] );
        }

        Matrix.print( matrix );
        Assert.assertTrue( Matrix.findWord( matrix, word ) );
    }

    @Test
    public void test3x3MatrixWithDiagonalWordTopLeftToBottomRight()
    {
        String[][] matrix = Matrix.generateRandomSquareMatrix( 3 );

        String word = "ten";
        char[] letters = word.toCharArray();
        for ( int i = 0; i < word.length(); i++ ) {
            matrix[i][i] = String.valueOf( letters[i] );
        }

        Matrix.print( matrix );
        Assert.assertTrue( Matrix.findWord( matrix, word ) );
    }

    @Test
    public void test3x3MatrixWithDiagonalWordBottomLeftToTopRight()
    {
        String[][] matrix = Matrix.generateRandomSquareMatrix( 3 );

        String word = "ten";
        char[] letters = word.toCharArray();
        for ( int i = 0; i < word.length(); i++ ) {
            matrix[matrix.length - 1 -
                   i][i] = String.valueOf( letters[i] );
        }

        Matrix.print( matrix );
        Assert.assertTrue( Matrix.findWord( matrix, word ) );
    }

    @Test
    public void test3x3MatrixWithReveredDiagonalWordTopLeftToBottomRight()
    {
        String[][] matrix = Matrix.generateRandomSquareMatrix( 3 );

        String word = "net";
        char[] letters = word.toCharArray();
        for ( int i = 0; i < word.length(); i++ ) {
            matrix[i][i] = String.valueOf( letters[i] );
        }

        Matrix.print( matrix );
        Assert.assertTrue( Matrix.findWord( matrix, "ten" ) );
    }

    @Test
    public void test3x3MatrixRotation()
        throws Exception
    {
        String[][] matrix = new String[][] { {"1", "1", "1"}, {"2", "2", "2"}, {"3", "3", "3"}};

        String[][] expected = new String[][] { {"3", "2", "1"}, {"3", "2", "1"}, {"3", "2", "1"}};

        String[][] rotated = Matrix.rotate( matrix );
        Matrix.print( matrix );
        Matrix.print( rotated );

        Assert.assertArrayEquals( expected, rotated );
    }
}
