import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
		public static void main(String[] args) {

				if(args.length != 1){
					System.out.println("Please input proper arguement!");
					System.exit(1);
				}
		
				//Check arguments
				if(args[0].equals("a")) {
						System.out.println("Loading data ...");		
						try {
								BufferedReader bufferedReader = new BufferedReader(
										new InputStreamReader(
												new FileInputStream("students.txt"))); 
								String line = bufferedReader.readLine(); 
								String words[] = line.split(",");			
								for(String word : words) {
										 System.out.println(word.trim());
								}
						} catch (Exception exception){

						} 
						System.out.println("Data Loaded.");
				}
				else if(args[0].equals("r")) {
						System.out.println("Loading data ...");			
						try {
								BufferedReader bufferedReader = new BufferedReader(
										new InputStreamReader(
												new FileInputStream("students.txt"))); 
								String line = bufferedReader.readLine(); 
								String words[] = line.split(",");	
								Random random = new Random();
								int index = random.nextInt(words.length);
								System.out.println(words[index].trim());
						} catch (Exception exception){

						} 
						System.out.println("Data Loaded.");			
				}
				else if(args[0].contains("+")){
						System.out.println("Loading data ...");			
						try {
								BufferedWriter bufferedWriter = new BufferedWriter(
										new FileWriter("students.txt", true));
								String subString = args[0].substring(1);
	        					Date date = new Date();
	        					String dateFprmatString = "yyyy-mm-dd hh:mm:ss a";
	        					DateFormat dateFormat = new SimpleDateFormat(dateFprmatString);
	        					String currentDate= dateFormat.format(date);
								bufferedWriter.write(", "+subString+"\nList last updated on "+currentDate);
								bufferedWriter.close();
						} catch (Exception exception){

						}							
						System.out.println("Data Loaded.");	
				}
				else if(args[0].contains("?")) {
						System.out.println("Loading data ...");			
						try {
								BufferedReader bufferedReader = new BufferedReader(
										new InputStreamReader(
												new FileInputStream("students.txt"))); 
								String line = bufferedReader.readLine();
								String words[] = line.split(",");	
								boolean done = false;
								String subString = args[0].substring(1);
								for(int index = 0; index<words.length && !done; index++) {
										if(words[index].equals(subString)) {
												System.out.println("We found it!");
												done=true;
										}
								}
						} catch (Exception exception){

						} 
						System.out.println("Data Loaded.");				
				}
				else if(args[0].contains("c")) {
						System.out.println("Loading data ...");			
						try {
								BufferedReader bufferedReader = new BufferedReader(
										new InputStreamReader(
												new FileInputStream("students.txt"))); 
								String line = bufferedReader.readLine();
								char letters[] = line.toCharArray();			
								boolean in_word = false;
								int count=0;
								for(char letter:letters) {
										if(letter ==' ') {
												if (!in_word) {	
														count++; in_word =true;	
												}
												else { 
														in_word=false;
												}			
										}
								}
								System.out.println(count +" word(s) found ");
						} catch (Exception exception){

						} 
						System.out.println("Data Loaded.");				
				}
		}
}
