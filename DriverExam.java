/* This class holds answers to a 20 multiple choice questions driver exam. 
 * This class has four public methods that grade the exam and return if you pass, number of questions correct,
 * incorrect, and what questions you missed. 
 * Written by Joshua Johnston
 * Date: 3/16/2015
 */
public class DriverExam {
	private char[] correct = {'B', 'D', 'A', 'A', 'C',    //correct answers for the exam 
			          'A', 'B', 'A', 'C', 'D', 
			          'B', 'C', 'D', 'A', 'D', 
			          'C', 'C', 'B', 'D', 'A'};
	
	private char[] student = new char[20]; //student answers
	private int[] missed;
	private int numCorrect = 0;
	private int numInCorrect = 0;
	
	public DriverExam(char[] answers){
		student = answers;
		
	}	

	private int[] makeMissedArray(){
		
		return missed = new int [numInCorrect];
		
	}
/* This passed method compares the number of correct student answers to 15.
 * To pass the exam the student must have 15 or more correct answers.
 * If pass return true, else return false.
 */
	public boolean passed(){
		int passed = totalCorrect();

		if(passed >= 15){
			return true;
		}//if
		
		return false;
	}//passed

	
/* This totalCorrect method compares the student answers to the correct answers, 
 * and count how many the student got correct.
 */	
	public int totalCorrect(){
		numCorrect = 0; //resetting numCorrect to 0 before the loop runs

		for(int k = 0; k < correct.length; k++){
			if(student[k] == correct[k]){
				numCorrect++; //count for each correct answer that the student input
			}//if			
		}//for		
		
		return numCorrect;		
	}//totalCorrect
	
/* This totalInCorrect method compares the student answers to the correct answers, 
 * and count how many the student got incorrect.
 */	
	public int totalInCorrect(){
		numInCorrect = 0; //resetting numInCorrect to 0 before the loop runs

		for(int j = 0; j < correct.length; j++){
			if(student[j] != correct[j]){
				numInCorrect++; //count for each incorrect answer that the student input
			}//if			
		}//for
		
		return numInCorrect;		
		
	}//totalInCorrect
	
/* This questionsMissed method stores the questions missed by the student into an integer array
 * 
 */	
	public int[] questionsMissed(){
		
		int[] missed = makeMissedArray();
		int i = 0;

		for(int b = 0; b < student.length; b++){

			if(student[b] != correct[b]){
                              missed[i] = (b+1);
                              i++;
			}//if
		}//for
		return missed;
		
	}//questionsMissed
	
	

}//DriverExam
