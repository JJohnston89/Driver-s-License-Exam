/*This program grades a student's driver exam. The exam has 20 questions. 
 * The student must have 15 or more questions correct to pass the exam.
 * An object is created from the DriverExam class to call methods to grade the exam, and
 * return if the student has pass or not, number of correct questions, and incorrect questions, and what
 * questions the student missed.
 * Written by Josh Johnston
 * Date: 3/16/2015
 */
import java.util.Scanner;
public class mainDriver {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		char[] studentAnswers = new char[20];
		DriverExam student1 = new DriverExam(studentAnswers); //DriverExam object
		
		System.out.println("Enter your answers to the exam questions. (Make sure Caps Lock is ON!)\n");
	    
		int j = 0;	    
		for(int i = 0; i < 20; i++){
			j++;
			System.out.print("Question " + j+": ");
			studentAnswers[i] = input.next().charAt(0); //inputing the student answers into an char array
			studentAnswers[i] = Validation(studentAnswers[i]); //validating the student's input
			
		}//for
		
		int[] missedQuestions = new int[student1.totalInCorrect()];
		missedQuestions = student1.questionsMissed();
		
		
		if(student1.passed()){ //checking to see if the student passed or failed
			System.out.println("Correct answers: " + student1.totalCorrect());
			System.out.println("Incorrect answers: " + student1.totalInCorrect());
			System.out.println("You passed the exam!");
			System.out.println("You missed the following questions:");
			
			for(int i = 0; i < missedQuestions.length; i++){
				System.out.print(missedQuestions[i] + " ");
				
			}//for			
		  }//if
		else
		     System.out.println("Correct answers: " + student1.totalCorrect());
		     System.out.println("Incorrect answers: " + student1.totalInCorrect());
		     System.out.println("You failed the exam!");
		     System.out.println("You missed the following questions:");
		
		    for(int i = 0; i < missedQuestions.length; i++){
			    System.out.print(missedQuestions[i] + " ");			
		}//for		
	}//main
	
/* This validation method checks to see if the student inputed a valid answer or not.
 * If the student does not enter A, B, C, or D then an error message will be printed, and ask for new input.
 * This method will call it self after each new input to check to see if the answer is valid or not, 
 * and continue until the student enters a valid answer.
 */	
	public static char Validation(char answer){
		Scanner input = new Scanner(System.in);		
		char newAnswer = 0;
		
		if (answer != 'A' && answer != 'B' && answer != 'C'  && answer != 'D'){
			System.out.println("\nERROR: Valid answers are A, B, C, or D.");		    
		        System.out.print("Re-enter your answer: ");
		        newAnswer = input.next().charAt(0);
		    
		        newAnswer = Validation(newAnswer); 
		    
		        return newAnswer;
		}//if
		
		return answer;
	}//validation
}//mainDriver
