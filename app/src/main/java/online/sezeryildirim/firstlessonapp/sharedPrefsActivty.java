package online.sezeryildirim.firstlessonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sharedPrefsActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefs_activty);

        Button butonum=findViewById(R.id.butonum);
        EditText text=findViewById(R.id.editTextTextPersonName);
        TextView textView=findViewById(R.id.asd);


        String adSoyad=getSharedPreference(sharedPrefsActivty.this,"my_app_shared_prefs","isim","boş");
        textView.setText(adSoyad);
        butonum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSharedPreference(sharedPrefsActivty.this,"my_app_shared_prefs","isim",text.getText().toString());
            }
        });
    }

    public String getSharedPreference(Context context,String fileName,String key, String defaultValue){
        return context.getSharedPreferences(fileName,Context.MODE_PRIVATE).getString(key,defaultValue);
    }

    public void setSharedPreference(Context context,String fileName,String key,String value){
        SharedPreferences sp=context.getSharedPreferences(fileName,MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,value);
        editor.apply();
    }
    public void clearSharedPreference(Context context){
        SharedPreferences sp=context.getSharedPreferences(context.getPackageName(),MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.clear();
        editor.apply();
    }public void removeSharedPreference(Context context,String fileName,String key){
        SharedPreferences sp=context.getSharedPreferences(fileName,MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.remove(key);
        editor.apply();
    }
}