package th.nguyenbuiquanghuy.th_quizappgui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Python extends AppCompatActivity {

    TextView answerA,answerB,answerC,answerD;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cactivity);
        answerA = findViewById(R.id.tv_answerA);
        answerB = findViewById(R.id.tv_answerB);
        answerC = findViewById(R.id.tv_answerC);
        answerD = findViewById(R.id.tv_answerD);
        btnNext=findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Python.this, Result.class);
                startActivity(intent);
            }
        });

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBorders();
                v.setBackgroundResource(R.drawable.border_green);
            }
        };

        answerA.setOnClickListener(answerClickListener);
        answerB.setOnClickListener(answerClickListener);
        answerC.setOnClickListener(answerClickListener);
        answerD.setOnClickListener(answerClickListener);

    }

    public void resetBorders() {
        answerA.setBackgroundResource(R.drawable.background_linear);
        answerB.setBackgroundResource(R.drawable.background_linear);
        answerC.setBackgroundResource(R.drawable.background_linear);
        answerD.setBackgroundResource(R.drawable.background_linear);
    }
}