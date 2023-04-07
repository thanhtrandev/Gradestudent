import java.util.Scanner;

public class GradeStudent {
	// Khai báo các biến toàn cục 
	static int scoreTerm;
	static int realScore;
	static int max = 100;
	static int weight = 100;
	static int shiftAmount = 0;
	static int totalPoints = 0;
	static int answer;
	static double calWeight;
	static double sumWeight = 0;
	static double grade;
	static double gpa;
	
	// Hàm điều khiển các luồn chính của chương trình
	public static void main(String[] args) {
		begin();
		midTerm();
		finalTerm();
		homework();
		report();
	}
	
	//Hàm hiển thị thông điệp chào mừng
	public static void begin() {
		System.out.println("This program reads exam/homework scores and reports your overall course grade");
		System.out.println("");
	}
	
	// Hàm để nhập và tính toán điểm thi giữa kỳ
	public static void midTerm() {
		
		// Khai báo Scanner để nhập giá trị từ bàn phím
		Scanner sc = new Scanner(System.in);

		System.out.println("Mid term: ");
		int weightMiddle;
		// Nhập và xử lý trọng số
		System.out.println("Weight (0-100) ? ");
		weightMiddle = sc.nextInt();

		while (weight - weightMiddle < 0) {
			System.out.println("Trọng số không lớn hơn 100, hay nhập lại: ");
			weightMiddle = sc.nextInt();
		}

		// Gán lại biến cho weight
		weight = weight - weightMiddle;

		// Nhập và xử lý điểm thi giữ kỳ
		System.out.println("Score earned ? ");
		realScore = sc.nextInt();

		while (realScore > max) {
			System.out.println("Trọng số không lớn hơn 100, hay nhập lại: ");
			realScore = sc.nextInt();
		}
		
		// Nhập và xử lý xét điều kiện cộng điểm
		System.out.print("Were scores shifted (1 = yes, 2=no):");
		answer = sc.nextInt();

		if (answer == 2) {
			System.out.print("Total points: " + realScore + " / " + max);
			System.out.println("");
		}

		// Điều kiện được cộng điểm
		if (answer == 1) {

			System.out.println("Shift Amount: ");
			shiftAmount = sc.nextInt();

			totalPoints = realScore + shiftAmount;

			if (totalPoints > max) {
				totalPoints = max;
			}
			System.out.print("Total points: " + totalPoints + " / " + max);
			System.out.println("");
			
		}

		// Điểm số đã tính dựa trên trọng số.
		calWeight = ((double) realScore) / 100 * (double) weightMiddle;
		System.out.print("Weight score:" + (double) Math.round(calWeight * 10) / 10  + " / " + weightMiddle);
		sumWeight = sumWeight + calWeight;
		System.out.println("");
		System.out.println("");

		
	}
	
	// Hàm để nhập và tính toán điểm thi cuối kỳ. 
	public static void finalTerm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Final: ");
		int weightFinal;
		
		// Nhập và xử lý trọng số thi cuối kỳ
		System.out.println("Weight (0-100) ? ");
		weightFinal = sc.nextInt();

		while (weight - weightFinal < 0) {
			System.out.println("Trọng số không lớn hơn 100, hay nhập lại: ");
			scoreTerm = sc.nextInt();
		}
		
		// Gán lại giá trị trọng số
		weight = weight - weightFinal;

		// Nhập và xử lý điểm thi cuối kỳ
		System.out.println("Score earned ? ");
		realScore = sc.nextInt();

		while (realScore > max) {
			System.out.println("Trọng số không lớn hơn 100, hay nhập lại: ");
			realScore = sc.nextInt();
		}

		// Nhập và xử lý xét điều kiện cộng điểm
		System.out.print("Were scores shifted (1 = yes, 2=no):");
		answer = sc.nextInt();

		// Điều kiện không được cộng điểm
		if (answer == 2) {
			System.out.print("Total points: " + realScore + " / " + max);
			System.out.println("");
		}

		// Điều kiện được cộng điểm
		if (answer == 1) {

			System.out.println("Shift Amount: ");
			shiftAmount = sc.nextInt();

			totalPoints = realScore + shiftAmount;

			if (totalPoints > max) {
				totalPoints = max;
			}
			System.out.print("Total points: " + totalPoints + " / " + max);
			System.out.println("");
		}

		// Điểm số đã tính dựa trên trọng số.
		calWeight = ((double) totalPoints) / 100 * (double) weightFinal;
		System.out.print("Weight score:" + (double) Math.round(calWeight * 10) / 10 + " / " + weightFinal);
		sumWeight = sumWeight + calWeight;
		System.out.println("");
		System.out.println("");
		
	

	}
	
	//Hàm nhập và tính toán điểm bài tập về nhà
	public static void homework() {
		int weightHomeWork = weight;
		int asmNumer;
		int rollCall;
		int pointList;
		int maxPointList = 30;
		int maxAsm;
		Scanner sc = new Scanner(System.in);

		// Trọng số được tính tự động
		System.out.println("Homework: ");
		System.out.println("Weight (0-100) ? " + weightHomeWork);

		// Nhập số lượng bài tập
		System.out.println("Number of assignments ? ");
		asmNumer = sc.nextInt();
		
		
		int realSum = 0;
		int maxSum = 0;
		for (int i = 0; i < asmNumer; i++) {
			
			System.out.println("Assignment " + (i + 1) + " score and max: ");
			// Khai báo mỗi bài tập là 1 mảng trong loop for để nhập giá trị điểm
			int[] asmScore = new int[2];
			asmScore[0] = sc.nextInt();
			asmScore[1] = sc.nextInt();
			realSum += asmScore[0];
			maxSum += asmScore[1];
			
		}

	
		// Tính số buổi điểm danh
		System.out.println("How many sections did you attend: ");
		rollCall = sc.nextInt();
		
		// Tính điểm chuyên cần
		pointList = rollCall * 5;
		if (pointList <= maxPointList) {
			System.out.println("Section points: " + pointList);
		} else {
			pointList = 30;
			System.out.println("Section points: " + pointList);
		}
		
		//Tính Total points: 
		totalPoints = realSum + pointList;
		
		if ( totalPoints > 150 ) {
			totalPoints = 150;
		}
		
		// Tính điểm tối đa
		maxAsm = maxSum + maxPointList;
		
		System.out.println("Total points: " + totalPoints + "/" + maxAsm );
		
		// Điểm số đã tính dựa trên trọng số.
		calWeight = (double) totalPoints / (double) maxAsm * (double) weightHomeWork;
		System.out.printf("Weight score: " + (double) Math.round(calWeight * 10) / 10 + " / " + weightHomeWork);
		sumWeight = sumWeight + calWeight;
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("Overall percentage: " + (double) Math.round(sumWeight * 10) / 10 );
		grade = (double) Math.round(sumWeight * 10) / 10;
	}
	
	// Hàm nhận giá trị grade hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng. 
	public static double report() {
		
		if ( grade == 100 ) {
			gpa = 4.0;
			System.out.println("Your grade will be at least: " + gpa);
			System.out.println("Very good !");
		} else if ( grade >= 85 ) {
			gpa = 3.0;
			System.out.println("Your grade will be at least: " + gpa);
			System.out.println("Good !");
		} else if ( grade >= 75 ) {
			gpa = 2.0; 
			System.out.println("Your grade will be at least: " + gpa);
			System.out.println("Not bad !");
		} else if ( grade >= 60 && grade < 75 ) {
			gpa = 1.0; 
			System.out.println("Your grade will be at least: " + gpa);
			System.out.println("Need to improve!");
		} else {
			gpa = 0.0; 
			System.out.println("Your grade will be at least: " + gpa);
			System.out.println("Need to improve!");
		}
		
		return grade;
		
	}
 
}
