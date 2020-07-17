import java.util.ArrayList;
import java.util.Scanner;



public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<puzzle> Q = new ArrayList();
		ArrayList<puzzle> Q1 = new ArrayList();
		int number =0;
		int pc=1;
		int count = 0;
		puzzle ob = new puzzle();
		int goal_matrix[][] = new int[3][3];
		goal_matrix[0][0] = 1;
		goal_matrix[0][1] = 2;
		goal_matrix[0][2] = 3;
		goal_matrix[1][0] = 4;
		goal_matrix[1][1] = 5;
		goal_matrix[1][2] = 6;
		goal_matrix[2][0] = 7;
		goal_matrix[2][1] = 8;
		goal_matrix[2][2] = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ob.matrix[i][j] = input.nextInt();
			}
		}
		ob.matrix_no = number++;
		ob.parent_no=0;
		Q.add(ob);
		Q1.add(ob);
		while (true) {
			puzzle front = new puzzle();

			front = Q.get(0);
			
			boolean mat_cheack = true;
			// check equal
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (front.matrix[i][j] != goal_matrix[i][j]) {
						mat_cheack = false;
						break;
					}

				}

			}
			
			
			if (mat_cheack == true) {
				
				
				System.out.println("Result matrix:");
				// print 1st queue
				puzzle ob1 = new puzzle();
				ob1 = Q.get(0);

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						System.out.print(ob1.matrix[i][j] + " ");
					}
					System.out.println();
				}System.out.println("Matrix_no: "+ob1.matrix_no+"\nParent No: "+ob1.parent_no);
				System.out.println();
				
				System.out.println("Path:");
				while(true)
				{
					int p=front.parent_no;
					System.out.println(p);
					if (p==0) {
						front=Q1.get(p);
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j < 3; j++) {
								System.out.print(front.matrix[i][j] + " ");
							}
							System.out.println();
						}System.out.println("Matrix_no: "+front.matrix_no+"\nParent No: "+front.parent_no);
						System.out.println();
						break;
					}
					front=Q1.get(p);
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							System.out.print(front.matrix[i][j] + " ");
						}
						System.out.println();
					}System.out.println("Matrix_no: "+front.matrix_no+"\nParent No: "+front.parent_no);
					System.out.println();
					
				}
				
				break;
			}
			
			

			int cnt = 1;
			int f = 1;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (front.matrix[i][j] == 0) {
						f = 2;
						break;
					} else {
						cnt++;

					}
				}
				if (f == 2) {
					break;
				}

			}

			Q.remove(0);
			// 1.1
			if (cnt == 5) {

				puzzle mov1 = new puzzle();
				puzzle mov2 = new puzzle();
				puzzle mov3 = new puzzle();
				puzzle mov4 = new puzzle();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov2.matrix[i][j] = front.matrix[i][j];
						mov3.matrix[i][j] = front.matrix[i][j];
						mov4.matrix[i][j] = front.matrix[i][j];
					}

				}

				int temp = mov1.matrix[1][1];
				mov1.matrix[1][1] = mov1.matrix[0][1];
				mov1.matrix[0][1] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov2.matrix[1][1];
				mov2.matrix[1][1] = mov2.matrix[2][1];
				mov2.matrix[2][1] = temp1;
				mov2.matrix_no = number++;
				mov2.parent_no = front.matrix_no;

				int temp2 = mov3.matrix[1][1];
				mov3.matrix[1][1] = mov3.matrix[1][0];
				mov3.matrix[1][0] = temp2;
				mov3.matrix_no = number++;
				mov3.parent_no = front.matrix_no;

				int temp3 = mov4.matrix[1][1];
				mov4.matrix[1][1] = mov4.matrix[1][2];
				mov4.matrix[1][2] = temp3;
				mov4.matrix_no = number++;
				mov4.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov2);
				Q.add(mov3);
				Q.add(mov4);
				Q1.add(mov1);
				Q1.add(mov2);
				Q1.add(mov3);
				Q1.add(mov4);

			}

			// 0.0
			else if (cnt == 1) {

				puzzle mov1 = new puzzle();
				puzzle mov6 = new puzzle();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov6.matrix[i][j] = front.matrix[i][j];

					}

				}

				int temp = mov1.matrix[0][0];
				mov1.matrix[0][0] = mov1.matrix[0][1];
				mov1.matrix[0][1] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov6.matrix[0][0];
				mov6.matrix[0][0] = mov6.matrix[1][0];
				mov6.matrix[1][0] = temp1;
				mov6.matrix_no = number++;
				mov6.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov6);

				Q1.add(mov1);
				Q1.add(mov6);

			}

			// 0.2
			else if (cnt == 3) {

				puzzle mov1 = new puzzle();
				puzzle mov2 = new puzzle();

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov2.matrix[i][j] = front.matrix[i][j];

					}

				}
				int temp = mov1.matrix[0][2];
				mov1.matrix[0][2] = mov1.matrix[0][1];
				mov1.matrix[0][1] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov2.matrix[0][2];
				mov2.matrix[0][2] = mov2.matrix[1][2];
				mov2.matrix[1][2] = temp1;
				mov2.matrix_no = number++;
				mov2.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov2);

				Q1.add(mov1);
				Q1.add(mov2);

			}

			// 2.0
			else if (cnt == 7) {
				puzzle mov1 = new puzzle();
				puzzle mov2 = new puzzle();

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov2.matrix[i][j] = front.matrix[i][j];

					}

				}
				int temp = mov1.matrix[2][0];
				mov1.matrix[2][0] = mov1.matrix[1][0];
				mov1.matrix[1][0] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov2.matrix[2][0];
				mov2.matrix[2][0] = mov2.matrix[2][1];
				mov2.matrix[2][1] = temp1;
				mov2.matrix_no = number++;
				mov2.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov2);

				Q1.add(mov1);
				Q1.add(mov2);

			}

			// 2.2
			else if (cnt == 9) {
				puzzle mov1 = new puzzle();
				puzzle mov2 = new puzzle();

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov2.matrix[i][j] = front.matrix[i][j];

					}

				}

				int temp = mov1.matrix[2][2];
				mov1.matrix[2][2] = mov1.matrix[1][2];
				mov1.matrix[1][2] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov2.matrix[2][2];
				mov2.matrix[2][2] = mov2.matrix[2][1];
				mov2.matrix[2][1] = temp1;
				mov2.matrix_no = number++;
				mov2.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov2);

				Q1.add(mov1);
				Q1.add(mov2);

			}

			// 0.1
			else if (cnt == 2) {
				puzzle mov1 = new puzzle();
				puzzle mov2 = new puzzle();
				puzzle mov3 = new puzzle();

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov2.matrix[i][j] = front.matrix[i][j];
						mov3.matrix[i][j] = front.matrix[i][j];

					}

				}

				int temp = mov1.matrix[0][1];
				mov1.matrix[0][1] = mov1.matrix[0][0];
				mov1.matrix[0][0] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov2.matrix[0][1];
				mov2.matrix[0][1] = mov2.matrix[0][2];
				mov2.matrix[0][2] = temp1;
				mov2.matrix_no = number++;
				mov2.parent_no = front.matrix_no;

				int temp2 = mov3.matrix[0][1];
				mov3.matrix[0][1] = mov3.matrix[1][1];
				mov3.matrix[1][1] = temp2;
				mov3.matrix_no = number++;
				mov3.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov2);
				Q.add(mov3);

				Q1.add(mov1);
				Q1.add(mov2);
				Q1.add(mov3);

			}

			// 1.0
			else if (cnt == 4) {
				puzzle mov1 = new puzzle();
				puzzle mov2 = new puzzle();
				puzzle mov3 = new puzzle();

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov2.matrix[i][j] = front.matrix[i][j];
						mov3.matrix[i][j] = front.matrix[i][j];

					}

				}
				int temp = mov1.matrix[1][0];
				mov1.matrix[1][0] = mov1.matrix[0][0];
				mov1.matrix[0][0] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov2.matrix[1][0];
				mov2.matrix[1][0] = mov2.matrix[2][0];
				mov2.matrix[2][0] = temp1;
				mov2.matrix_no = number++;
				mov2.parent_no = front.matrix_no;

				int temp2 = mov3.matrix[1][0];
				mov3.matrix[1][0] = mov3.matrix[1][1];
				mov3.matrix[1][1] = temp2;
				mov3.matrix_no = number++;
				mov3.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov2);
				Q.add(mov3);

				Q1.add(mov1);
				Q1.add(mov2);
				Q1.add(mov3);

			}

			// 2.1
			else if (cnt == 8) {
				puzzle mov1 = new puzzle();
				puzzle mov2 = new puzzle();
				puzzle mov3 = new puzzle();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov2.matrix[i][j] = front.matrix[i][j];
						mov3.matrix[i][j] = front.matrix[i][j];

					}

				}
				int temp = mov1.matrix[2][1];
				mov1.matrix[2][1] = mov1.matrix[2][2];
				mov1.matrix[2][2] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov2.matrix[2][1];
				mov2.matrix[2][1] = mov2.matrix[2][0];
				mov2.matrix[2][0] = temp1;
				mov2.matrix_no = number++;
				mov2.parent_no = front.matrix_no;

				int temp2 = mov3.matrix[2][1];
				mov3.matrix[2][1] = mov3.matrix[1][1];
				mov3.matrix[1][1] = temp2;
				mov3.matrix_no = number++;
				mov3.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov2);
				Q.add(mov3);

				Q1.add(mov1);
				Q1.add(mov2);
				Q1.add(mov3);

			}

			// 1.2
			else if (cnt == 6) {
				puzzle mov1 = new puzzle();
				puzzle mov2 = new puzzle();
				puzzle mov3 = new puzzle();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						mov1.matrix[i][j] = front.matrix[i][j];
						mov2.matrix[i][j] = front.matrix[i][j];
						mov3.matrix[i][j] = front.matrix[i][j];

					}

				}

				int temp = mov1.matrix[1][2];
				mov1.matrix[1][2] = mov1.matrix[0][2];
				mov1.matrix[0][2] = temp;
				mov1.matrix_no = number++;
				mov1.parent_no = front.matrix_no;

				int temp1 = mov2.matrix[1][2];
				mov2.matrix[1][2] = mov2.matrix[2][2];
				mov2.matrix[2][2] = temp1;
				mov2.matrix_no = number++;
				mov2.parent_no = front.matrix_no;

				int temp2 = mov3.matrix[1][2];
				mov3.matrix[1][2] = mov3.matrix[1][1];
				mov3.matrix[1][1] = temp2;
				mov3.matrix_no = number++;
				mov3.parent_no = front.matrix_no;

				Q.add(mov1);
				Q.add(mov2);
				Q.add(mov3);

				Q1.add(mov1);
				Q1.add(mov2);
				Q1.add(mov3);

			}
			
		}

		for (int c = 0; c < Q1.size(); c++) {
			puzzle o = new puzzle();
			o = Q1.get(c);

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(o.matrix[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println("Matrix ID: " + o.matrix_no + "\nParent ID: " + o.parent_no);
			System.out.println();

		}
		
		
	}
}