package com.example.healthyheart;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadUrl {

    public String readUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        //HttpsURLConnection urlConnection = null;
        HttpURLConnection urlConnection = null;
        //String test_url = "http://www.google.com/maps/place/Wilmington+Apartments/@39.7293325,-84.1598845,17.26z/data=!4m15!1m8!3m7!1s0x884084424acfa881:0x1893680a8d5c70e2!2s929+Wilmington+Ave,+Dayton,+OH+45420!3b1!8m2!3d39.7292235!4d-84.1579208!16s%2Fg%2F11c4r0kswf!3m5!1s0x884084426a401641:0xd227496695cdeb6e!8m2!3d39.7304023!4d-84.1578924!16s%2Fg%2F1tdwwcf3";
        try {
            URL url = new URL(strUrl);
            //URL url = new URL(test_url);
            System.out.println("Check");
            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            System.out.println("Creating http connection:"+urlConnection);
            //urlConnection.setRequestMethod("GET");
            // Connecting to url
            urlConnection.connect();
            System.out.println("Connecting to url");
            // Reading data from url
            iStream = urlConnection.getInputStream();
            System.out.println("iStream:"+iStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());
            br.close();

        } catch (Exception e) {
            System.out.println("Exception occured Check");
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
}