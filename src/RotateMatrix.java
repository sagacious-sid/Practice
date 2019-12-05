import java.util.Random;

//rotate matrix right 90 degrees
public class RotateMatrix {

	public static void main(String[] args) {
		//create a matrix to input
		int[][] mat = new int[4][4];
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				mat[i][j]=new Random().nextInt(20);
			}
		}
		printMatrix(mat);
		System.out.print("Rotated Matrix: \n");
		rotateMatrix(mat);
	}
	
	

	private static void rotateMatrix(int[][] mat) {
		int rowLength = mat.length;
		int colLength = mat[0].length;
		
		int[][] rotatedMat = new int[colLength][rowLength];
		
		for(int i=0;i<rowLength;i++) {
			for(int j=0;j<colLength;j++) {
				rotatedMat[j][rowLength-i-1] = mat[i][j];
			}
		}
		printMatrix(rotatedMat);
	}



	private static void printMatrix(int[][] mat) {
		int rowLength = mat.length;
		int colLength = mat[0].length;
		for(int i=0;i<rowLength;i++) {
			for(int j=0;j<colLength;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.print("\n");
		}
	}

}
