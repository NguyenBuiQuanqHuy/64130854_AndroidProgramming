package th.nguyenbuiquanghuy.th_quizappfullcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView cardViewC,cardViewJava,cardViewPython;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cardViewC=findViewById(R.id.layoutC);
        cardViewJava=findViewById(R.id.layoutJava);
        cardViewPython=findViewById(R.id.layoutPython);

        cardViewC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CPlus.class);
                startActivity(intent);
            }
        });

        cardViewJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Java.class);
                startActivity(intent);
            }
        });

        cardViewPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Python.class);
                startActivity(intent);
            }
        });
    }
}