package uk.co.peterscorner;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpGetDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BufferedReader in = null;
        try{
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet("http://www.volareweekend.com/search/flight/return/fix/MIL/LON/01052012/08052012/500.0/1/0/0/00:00-23:59/00:00-23:59/ECONOMY/47293");//("http://code.google.com/android/");
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while((line = in.readLine()) != null){
                sb.append(line + NL);
            }

            String page = sb.toString();
            Log.i("HttpGetDemo", page);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(in != null){
                try{
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}

