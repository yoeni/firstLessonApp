package online.sezeryildirim.firstlessonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fl = findViewById(R.id.fragmentContainer);

    }

    public void firstFragmentButton(View view){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        firstFragment f1=new firstFragment();
        transaction.replace(fl.getId(),f1);
        transaction.commit();
    }

    public void secondFragmentButton(View view){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        secondFragment f2=new secondFragment();
        transaction.replace(fl.getId(),f2);
        transaction.commit();
    }
    public void listViewButton(View view){
        Intent i=new Intent(MainActivity.this,listviewActivity.class);
        startActivity(i);
    }
    public void sharedButton(View view){
        Intent i=new Intent(MainActivity.this,sharedPrefsActivty.class);
        startActivity(i);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}