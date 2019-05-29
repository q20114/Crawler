import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Crawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url=null;
		try { String[] pic = {
				"https://pbs.twimg.com/media/D7vAJCNU0AEP-hX.jpg",    
                "http://pic.pimg.tw/robertvmp/1171610321.jpg"};
		for (int k = 0; k<pic.length;k++)
		{
			url = new URL(pic[k]);
			FileOutputStream fos = new FileOutputStream(k+1+".jpg",false);
			InputStream is = url.openStream();
			int r = 0;
			System.out.println("Downloading - " +(k+1));
            while ( ( r = is.read() ) != -1){
                fos.write(r);
             }
			is.close();
			fos.close();
		}
		System.out.println("Download Finished. ");
		}
		catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
		catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
