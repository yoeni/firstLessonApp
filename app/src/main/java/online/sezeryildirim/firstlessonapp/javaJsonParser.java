package online.sezeryildirim.firstlessonapp;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class javaJsonParser {
    private InputStream is=null;
    private JSONObject jObj=null;
    private String json="";
    public javaJsonParser(){

    }
    public JSONObject getJSONFromUrl(String url){
        //Making http request
        try{
            URL urlObject=new java.net.URL(url);
            HttpURLConnection conn=(HttpURLConnection)urlObject.openConnection();
            conn.setRequestMethod("GET");
            is=new BufferedInputStream(conn.getInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(is,"UTF-8"));
            StringBuilder builder=new StringBuilder();
            String line;
            while((line=reader.readLine())!=null){
                String tmp=line+"\n";
                builder.append(tmp);
            }
            is.close();

            json=builder.toString();
        }catch (Exception e){
            Log.d("*** Buffer Error","Error converting result : "+e.toString());
        }

        //try parse string to a json object
        try{
            if(json!=null){
                jObj=new JSONObject(json);
            }else{
                jObj=null;
            }
        }catch (JSONException e){
            Log.d("*** json object",e.toString());
        }
        return jObj;
    }
}
