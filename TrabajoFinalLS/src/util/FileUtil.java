package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {
	
    public InputStream getFile(String path){
    	InputStream in = getClass().getResourceAsStream(path);
    	//BufferedReader input = new BufferedReader(new InputStreamReader(in));	
    	return in;
    }

}
