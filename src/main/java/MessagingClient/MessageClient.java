package MessagingClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**x`
 * Created by aditya.mullela on 03/03/17.
 */
public class MessageClient implements Runnable {

    String url;

    public MessageClient(String key, String url) {

        this.url = url;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + "Start");
        makeCall(url);
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    public void makeCall(String url) {

        try {

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);


            HttpResponse response = httpClient.execute(get);
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());

            String type = response.getEntity().getContentType().toString();

            System.out.println("type:" + type);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }


           result.toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
