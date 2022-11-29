import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
		public static void main(String[] args) {

				if(args.length != 1){
					System.out.println(Constants.improper_arguement);
					System.exit(1);
				}
		
				//Check arguments
				if(args[0].equals(Constants.arguement_a)) {
						System.out.println(Constants.loading);		
						String line = readFromFile(); 
						String words[] = line.split(Constants.comma);			
						for(String word : words) {
								 System.out.println(word.trim());
						}  
						System.out.println(Constants.data_loaded);
				}
				else if(args[0].equals(Constants.arguement_r)) {
						System.out.println(Constants.loading);			
						String line = readFromFile();
						String words[] = line.split(Constants.comma);	
						Random random = new Random();
						int index = random.nextInt(words.length);
						System.out.println(words[index].trim());
						System.out.println(Constants.data_loaded);			
				}
				else if(args[0].contains(Constants.arguement_plus)){
						System.out.println(Constants.loading);			
						String subString = args[0].substring(1);
	        			DateFormat dateFormat = new SimpleDateFormat(Constants.date_format);
	        			String currentDate= dateFormat.format(new Date());
						writeToFile(subString, currentDate);								
						System.out.println(Constants.data_loaded);	
				}
				else if(args[0].contains(Constants.arguement_ques)) {
						System.out.println(Constants.loading);			
						String line = readFromFile();
						String words[] = line.split(Constants.comma);	
						String subString = args[0].substring(1);
						for(int index = 0; index<words.length; index++) {
								if(words[index].equals(subString)) {
										System.out.println(Constants.word_found);
										break;
								}
						}
						System.out.println(Constants.data_loaded);				
				}
				else if(args[0].contains(Constants.arguement_c)) {
						System.out.println(Constants.loading);			
						String line = readFromFile();
						String studentNames[] = line.split(Constants.space);			
						System.out.println(studentNames.length + Constants.words_found); 
						System.out.println(Constants.data_loaded);				
				}
				else{
						System.out.println(Constants.error_message_for_invalid_arguement);
						System.exit(1);
				}
		}
		public static String readFromFile(){
				try {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(
									new FileInputStream(Constants.filename))); 
					return bufferedReader.readLine();
				}catch (Exception exception){
					
				}
				return Constants.blank;
				
		}
		public static void writeToFile(String subString, String currentDate){
				try {
						BufferedWriter bufferedWriter = new BufferedWriter(
								new FileWriter(Constants.filename, true));
						bufferedWriter.write(Constants.comma_space + subString + Constants.list_Update + currentDate);
						bufferedWriter.close();
				} catch (Exception exception){

				}
		}
}
