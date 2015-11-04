package util;

import java.io.InputStream;

public class FileUtil {
	
    public InputStream getFile(String path){
    	InputStream in = getClass().getResourceAsStream(path);
    	return in;
    }

}
