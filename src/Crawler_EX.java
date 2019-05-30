import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Crawler_EX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sca = new Scanner(System.in);
		String str = sca.nextLine();
		//String content ="<html>...<div><img alt ='xxx' src='yyy'><img alt='xxx' src='mmm'></div></html>"
		URL targeturl=null;
		URL url=null;
		URL url=null;
		URL url=null;
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
            
            /* //==Solution 1.直接讀入
            while ( ( r = is.read() ) != -1){
                fos.write(r);

             } */

           /* //==Solution 2.讀到 buffer , <<速度較快>>
            byte[] buf = new byte[100000]; // 100kb buffer
            while ( ( r = is.read(buf) ) != -1){
                fos.write(buf,0,r);
            }*/

            /*//==Solution 3.讀到 buffer , <<較快一點 & 精準的寫法>>
            //因為不能保證連線的品質，或是檔案較大的時候，也許會有lose
            int chunkSize = 1024 * 8;
            byte[] buf = new byte[chunkSize];
            int readLen;
            while ((readLen = is.read( buf, 0, buf.length)) != -1) {
               fos.write(buf, 0, readLen);  
            }*/
            
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
