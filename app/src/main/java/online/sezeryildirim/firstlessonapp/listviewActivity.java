package online.sezeryildirim.firstlessonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class listviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView lv=findViewById(R.id.listview);



        //****************** TEK SATIRLI LİSTVİEW *******************
        /*String items[]={"İzmir","Manisa","İstanbul"};
        ArrayAdapter<String> adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,android.R.id.text1,items);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long i){
                String value = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });*/

        //****************** İKİ SATIRLI LİSTVİEW *******************
        /*String[] fromMapKey={"text1","text2"};
        int[] layoudId=new int[]{android.R.id.text1,android.R.id.text2};

        List<HashMap<String,String>> list=new ArrayList<>();
        HashMap hm=new HashMap();
        hm.put("text1","izmir");
        hm.put("text2","35");
        list.add(hm);

        hm=new HashMap();
        hm.put("text1","Çanakkale");
        hm.put("text2","17");
        list.add(hm);

        hm=new HashMap();
        hm.put("text1","İstanbul");
        hm.put("text2","34");
        list.add(hm);

        hm=new HashMap();
        hm.put("text1","Manisa");
        hm.put("text2","45");
        list.add(hm);

        hm=new HashMap();
        hm.put("text1","Tekirdağ");
        hm.put("text2","06");
        list.add(hm);

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list, android.R.layout.simple_list_item_2,fromMapKey,layoudId);
        lv.setAdapter(simpleAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap hm=list.get(position);
                String value=hm.get("text2").toString();
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });*/

        //****************** ÜÇ(İstediğin) SATIRLI LİSTVİEW *******************
        /*String[] fromMapKey={"tv1","tv2","tv3"};
        int[] layoudId=new int[]{R.id.tv1,R.id.tv2,R.id.tv3};

        List<HashMap<String,String,String>> list=new ArrayList<>();
        HashMap hm=new HashMap();
        hm.put("tv1","izmir");
        hm.put("tv2","35");
        hm.put("tv3","Alsanck no 5");
        list.add(hm);

        hm=new HashMap();
        hm.put("tv1","İstanbul");
        hm.put("tv2","35");
        hm.put("tv3","Esenler no 5");
        list.add(hm);

        hm=new HashMap();
        hm.put("tv1","Çanakkale");
        hm.put("tv2","35");
        hm.put("tv3","Kepez no 5");
        list.add(hm);

        hm=new HashMap();
        hm.put("tv1","Manisa");
        hm.put("tv2","35");
        hm.put("tv3","turgutlu no 5");
        list.add(hm);

        hm=new HashMap();
        hm.put("tv1","Tekirdağ");
        hm.put("tv2","35");
        hm.put("tv3","Süleymanpaşa no 5");
        list.add(hm);

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list, R.layout.custom_row_layout,fromMapKey,layoudId);
        lv.setAdapter(simpleAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap hm=list.get(position);
                String value=hm.get("tv3").toString();
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });*/


        //***** online jsondan veri alma **********
        //online json veri çekme

        /*if (isOnline()){
            parseJson task=new parseJson();
            task.execute();
        }*/

        //online json veri alıp listviewe aktarma
    /*
        String[] fromMapKey={"tv1","tv2","tv3"};
        int[] layoudId=new int[]{R.id.tv1,R.id.tv2,R.id.tv3};
        List<HashMap<String,String>> list =new ArrayList<>();

        if (isOnline()){
            test test_=new test();
            list=test_.doWork();
            SimpleAdapter simpleAdapter=new SimpleAdapter(this,list, R.layout.custom_row_layout,fromMapKey,layoudId);
            lv.setAdapter(simpleAdapter);
        }*/

    }
    public boolean isOnline(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager!=null){
            NetworkInfo netInfo =connectivityManager.getActiveNetworkInfo();
            return netInfo!=null&&netInfo.isConnectedOrConnecting();
        }
        return false;
    }

    private  class parseJson extends AsyncTask<Void,Void,String>{
        org.json.JSONObject jsonObject;
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
             pd=new ProgressDialog(listviewActivity.this);
            pd.setMessage("Devam ediyor...");
            pd.show();
        }

        @Override
        protected String doInBackground(Void ... Voids){
            javaJsonParser parser=new javaJsonParser();
            jsonObject = parser.getJSONFromUrl("https://dummy.restapiexample.com/api/v1/employee/1");
            return null;
        }
        protected  void onPostExecute(String s){
            super.onPostExecute(s);
            pd.dismiss();
        }
    }

    public class test{
        ExecutorService executor;
        public test(){

            executor= Executors.newSingleThreadExecutor();
        }
        private List<HashMap<String,String>> doWork(){
            Callable<JSONObject> callable;
            Future<JSONObject> future;
            JSONObject jsonResult=null;
            List<HashMap<String,String>> list = new ArrayList<>();
            try {
                    //create callable object with desired job
                callable=new Callable<JSONObject>() {
                    @Override
                    public JSONObject call() throws Exception {
                        JSONObject jsonResult=new JSONObject();

                        javaJsonParser jsonParser=new javaJsonParser();
                        String url="https://dummy.restapiexample.com/api/v1/employees";
                        jsonResult=jsonParser.getJSONFromUrl(url);

                        Log.d("*** get json 1",jsonResult.toString());

                        JSONArray array=jsonResult.getJSONArray("data");
                        for (int i=0;i<array.length();i++){
                            HashMap hm=new HashMap();
                            hm.put("tv1",array.getJSONObject(i).getString("employee_name"));
                            hm.put("tv2",Integer.toString(array.getJSONObject(i).getInt("employee_salary")));
                            hm.put("tv3",Integer.toString(array.getJSONObject(i).getInt("employee_age")));
                            list.add(hm);
                        }
                        /*HashMap hm=new HashMap();
                        hm.put("tv1",jsonResult.getString("status"));
                        hm.put("tv2",jsonResult.getString("message"));
                        hm.put("tv3","hiç");
                        list.add(hm);*/

                        return jsonResult;
                    }
                };
                future=executor.submit(callable);
                jsonResult=future.get();

            }catch (InterruptedException | ExecutionException ex){
                Log.d("*** interrapted", ex.toString());
            }
            return list;
        }

    }
}