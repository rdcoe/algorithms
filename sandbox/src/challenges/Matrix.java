package challenges;

import java.util.Arrays;

/*
 * Given an NxN matrix that is populated with random letters from the alphabet, write a function
 * that determines whether a provided word is contained within the matrix. The word can be found
 * horizontally, vertically, diagonally and it can also be reversed.
 */

public class Matrix
{
    static char[] alphabet = new char[26];
    static {
        for ( int i = 0; i < alphabet.length; i++ ) {
            alphabet[i] = (char)( 'a' + i );
        }
    }

    public static String[][] generateRandomSquareMatrix( final int n )
    {
        String[][] matrix = new String[n][n];

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                matrix[i][j] = String.valueOf( (char)( alphabet[(int)Math.round( Math.random() * ( alphabet.length - 1 ) )] ) );
            }
        }

        return matrix;
    }

    public static boolean findWord( final String[][] matrix, String word )
    {
        boolean found = findWordInRows( matrix, word );

        if( !found ) {
            found = findWordInColumns( matrix, word );
        }

        if( !found ) {
            found = findWordDiagonals( matrix, word );
        }

        return found;
    }

    public static void print( final String[][] matrix )
    {
        for ( int i = 0; i < matrix.length; i++ ) {
            System.out.println( Arrays.toString( matrix[i] ) );
        }

        System.out.println();
    }

    private static boolean findWordInRows( String[][] matrix, String word )
    {
        final int rows = matrix.length;
        final int cols = matrix[0].length;

        for ( int i = 0; i < rows; i++ ) {
            StringBuilder sb = new StringBuilder();
            for ( int j = 0; j < cols; j++ ) {
                sb.append( matrix[i][j] );
            }
            if( containsWord( word, sb ) ) {
                return true;
            }
        }

        return false;
    }

    private static boolean findWordInColumns( String[][] matrix, String word )
    {
        final int rows = matrix.length;
        final int cols = matrix[0].length;

        for ( int j = 0; j < cols; j++ ) {
            StringBuilder sb = new StringBuilder();
            for ( int i = 0; i < rows; i++ ) {
                sb.append( matrix[i][j] );
            }
            if( containsWord( word, sb ) ) {
                return true;
            }
        }

        return false;
    }

    public static String[][] transpose( final String[][] matrix )
        throws Exception
    {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        if( !isSquare( matrix, rows ) ) {
            throw new Exception( "matrix rotation requires a square matrix." );
        }

        String[][] transposed = new String[matrix[0].length][matrix.length];

        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < cols; j++ ) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    public static String[][] rotate( final String[][] matrix )
        throws Exception
    {
        final int rows = matrix.length - 1;
        final int cols = matrix[0].length - 1;
        if( !isSquare( matrix, rows ) ) {
            throw new Exception( "matrix rotation requires a square matrix." );
        }

        String[][] rotated = new String[matrix.length][cols + 1];
        for ( int i = 0; i <= rows; i++ ) {
            for ( int j = 0; j <= cols; j++ ) {
                rotated[cols - j][cols - i] = matrix[i][j];
            }
        }

        return rotated;
    }

    private static boolean isSquare( final String[][] matrix, final int rows )
        throws Exception
    {
        for ( int i = 0; i < rows; i++ ) {
            if( rows != matrix[i].length ) {
                return false;
            }
        }

        return true;
    }

    private static boolean containsWord( String word, StringBuilder sb )
    {
        String wordReversed = new StringBuilder( word ).reverse().toString();

        if( sb.indexOf( word ) != -1 || sb.indexOf( wordReversed ) != -1 ) {
            return true;
        }

        return false;
    }

    private static boolean findWordDiagonals( String[][] matrix, String word )
    {
        // build diag that walks right, from top left corner
        for ( int i = 0; i < matrix.length; i++ ) {
            StringBuilder sb = new StringBuilder();
            for ( int j = 0; j < matrix[i].length; j++ ) {
                if( ( i - j ) < 0 ) {
                    break;
                }
                sb.append( matrix[i - j][j] );
            }
            if( sb.length() >= word.length() && containsWord( word, sb ) ) {
                return true;
            }
        }

        // build diag that walks left, from bottom right corner
        for ( int i = matrix.length - 1; i >= 0; i-- ) {
            StringBuilder sb = new StringBuilder();
            for ( int j = 0; j < matrix[i].length - i; j++ ) {
                if( ( i + j ) == matrix.length ) {
                    break;
                }
                sb.append( matrix[i + j][j] );
            }
            if( sb.length() >= word.length() && containsWord( word, sb ) ) {
                return true;
            }
        }

        return false;
    }
}
