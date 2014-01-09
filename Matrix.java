// BENEIDICT BOLTON
// HW#49
// PD08
// 2014-1-9

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below, categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	_matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	_matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return _matrix.length;
    }
    //runtime classification == O(1)

    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return _matrix[r-1][c-1];
    }
    //runtime classification == O(1)

    //return true if this location is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return (get(r,c) == null);
    }
    //runtime classification == O(1)


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object oldVal = get(r,c);
	_matrix[r-1][c-1] = newVal;
	return oldVal;
    }
    //runtime classification == O(1)


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String ans = "";
	for (int r = 0; r < _matrix.length; r++) {
	    ans += "| ";
	    for (int c = 0; c < _matrix[r].length; c++) {
		ans += get(r,c);
		if (c < _matrix[r].length - 1) {
		    ans += ", ";
		}
		else {
		    ans += " |";
		}
	    }
	}
	return ans;
    }
    //runtime classification == O(n)

    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	boolean fooBar = true;
	if (this != rightSide) {
	    fooBar = false;
	}
	if (rightSide instanceof Matrix) {
	    if ( this.size() == ( (Matrix) rightSide).size() ) {
		for (int r = 0; r < _matrix.length; r++) {
		    for (int c = 0; c < _matrix[r].length; c++) {
			if ( !( this.get(r,c).equals( ( (Matrix) rightSide).get(r,c)) ) ) {
			    fooBar = false;
			}
		    }
		}
	    }
	    else { fooBar = false; }
	}
	else {fooBar = false;}
    }
    //runtime classification == O(n)


    //return true if target is in this matrix; false otherwise
    public boolean isFound( Object target ) {
	boolean retBoo = false;
	for (int r = 0; r < _matrix.length; r++) {
	    for (int c = 0; c < _matrix[r].length; c++) {
		if ( get(r,c).equals(target) ) {
		    retBoo = true;
		    return retBoo;
		}
	    }
	}
	return retBoo;
    }
	


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	for (int row = 0; row < size(); row++ ) {
	    set(row, c1-1, set(row, c2-1 , get(row,c1)));
	}
    }
    //O(n)


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	for (int col = 0; col < size(); col++ ) {
	    set(r1-1, col, set(r2-1, col , get(r1,col)));
	}
    }
    //O(n)


    //main method for testing
    public static void main( String[] args ) {
	Matrix Neo = new Matrix();
	Matrix MrAnderson = new Matrix();
	
	for (int x = 1; x <= Neo.size(); x++ ) {
	    for (int y = 1; y <= Neo.size(); y++) {
		Neo.set(x, y, x + y);
		MrAnderson.set(x, y, x + y);
	    }
	}
	
	System.our.println(Neo);
	System.our.println(MrAnderson);
	System.our.println(Neo.equals(MrAnderson));	
	System.our.println(Neo.swapRows( 1, 2));
	System.our.println(MrAnderson.swapColumns( 1, 2));
	System.our.println(Neo);
	System.our.println(MrAnderson);
	System.our.println(Neo.equals(MrAnderson));
	
	Matrix Smith = new Matrix(6);
	for (int x = 1; x < Neo.size(); x++ ) {
	    for (int y = 1; y < Neo.size(); y++) {
		Smith.set(x, y, x + y);
	    }
	}
	System.our.println(Smith);
	System.our.println(Smith.isEmpty(6,6));
	System.our.println(Smith.isFound(2));
	System.our.println(Smith)	
	System.our.println(Smith.swapRows(2, 5));
	System.our.println(Smith);	
	System.our.println(Smith.get(3, 4));	
	  

       
    }//end main

}//end class Matrix
