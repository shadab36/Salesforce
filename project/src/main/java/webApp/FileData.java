package webApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;



public class FileData {
	static String filePath = "F:\\file\\file_id.txt";
	public static String readTextFile(String FileName){
		String content="";
		try {
			content=new String(Files.readAllBytes(Paths.get(FileName)));
		}catch(IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	public static void writeToTextFile(String FileName, String content)  {
        try {
            
    				Files.write(Paths.get(FileName), content.getBytes(), StandardOpenOption.CREATE);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	    }
    		public static int  readFile(){
    			
    			return Integer.parseInt(FileData.readTextFile(filePath));
    		}
    		public static void writeFile(int number){
    			FileData.writeToTextFile(filePath, String.valueOf(number));
    		}
    		
    		public static int nextNumber(){
    			int number =  readFile();
    			number=number+1;
    		
   			writeFile(number);
   			return number;
    		}
    
     
    


}
