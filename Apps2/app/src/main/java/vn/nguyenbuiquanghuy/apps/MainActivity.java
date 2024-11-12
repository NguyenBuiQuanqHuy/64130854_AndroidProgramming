package vn.nguyenbuiquanghuy.apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.nguyenbuiquanghuy.apps.recyclerview.Recycler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void BMI(View v){
        Intent bmi=new Intent(MainActivity.this,BMI.class);
        startActivity(bmi);
    }

    public void Profile(View v){
        Intent profile=new Intent(MainActivity.this,Profile.class);
        startActivity(profile);
    }

    public void ListView(View v){
        Intent listView=new Intent(MainActivity.this,ListViewBT.class);
        startActivity(listView);
    }

    public void RecyclerView(View v){
        Intent recyclerView=new Intent(MainActivity.this, Recycler.class);
        startActivity(recyclerView);
    }
}