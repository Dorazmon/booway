package Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import sun.misc.BASE64Encoder;

public class HttpClientTest
{

    public static void main(String[] args) throws ClientProtocolException, IOException
    {
        // TODO Auto-generated method stub
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        
        String parameter="章赣";
        BASE64Encoder encoder = new BASE64Encoder();
        String newParameter = encoder.encode(parameter.getBytes("utf-8"));
        String url = "http://localhost:8080/Class-1/ServletTest?p=" + newParameter;
        HttpGet httpGet = new HttpGet(url);
        HttpResponse cHR = httpCilent.execute(httpGet);
        HttpEntity hE = cHR.getEntity();
        InputStream is = hE.getContent();
        //      方法一:	
        //		int i = 0;
        //		byte[] str = new byte[1024];
        //		StringBuilder strBuer = new StringBuilder();
        //		while ((i = is.read(str)) != -1) {
        //			strBuer.append(new String(str, 0, i, "utf-8"));
        //
        //		}
        //		System.out.println(strBuer.toString());
        //      方法二:	
        ByteArrayOutputStream Bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int i = 0;
        while (true)
        {
            i = is.read(buffer);
            if (i == -1)
            {
                break;
            }
            Bos.write(buffer, 0, i);

        }
        System.out.println(new String(Bos.toByteArray(), "utf-8"));

    }
}
