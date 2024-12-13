package th.nguyenbuiquanghuy.th_quizappfullcode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Python extends AppCompatActivity {

    private TextView questionTextView;
    private CardView cardA, cardB, cardC, cardD;
    private TextView textA, textB, textC, textD;
    private Question currentQuestion;
    private Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_python);
        questionTextView = findViewById(R.id.tvQues);
        cardA = findViewById(R.id.cardViewA);
        cardB = findViewById(R.id.cardViewB);
        cardC = findViewById(R.id.cardViewC);
        cardD = findViewById(R.id.cardViewD);

        buttonNext=findViewById(R.id.btnNext);

        textA=findViewById(R.id.tvA);
        textB=findViewById(R.id.tvB);
        textC=findViewById(R.id.tvC);
        textD=findViewById(R.id.tvD);

        currentQuestion = new Question(
                "Lệnh nào dùng để in ra màn hình trong Python?",
                "print",
                "System.out.println",
                "echo",
                "cout",
                "print"
        );



        displayQuestion();
        setupOptionListeners();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Python.this, Result.class);
                startActivity(intent);
            }
        });
    }

    private void displayQuestion() {
        questionTextView.setText(currentQuestion.getQuestion());
        textA.setText("A: "+currentQuestion.getA());
        textB.setText("B: "+currentQuestion.getB());
        textC.setText("C: "+currentQuestion.getC());
        textD.setText("D: "+currentQuestion.getD());
    }

    private void setupOptionListeners() {
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBorders();
                String selectedAnswer = "";

                if (view == cardA) selectedAnswer = currentQuestion.getA();
                else if (view == cardB) selectedAnswer = currentQuestion.getB();
                else if (view == cardC) selectedAnswer = currentQuestion.getC();
                else if (view == cardD) selectedAnswer = currentQuestion.getD();

                if (selectedAnswer.equals(currentQuestion.getAnswer())) {
                    view.setBackgroundColor(Color.GREEN);
                } else {
                    view.setBackgroundColor(Color.RED);
                }
            }
        };

        cardA.setOnClickListener(listener);
        cardB.setOnClickListener(listener);
        cardC.setOnClickListener(listener);
        cardD.setOnClickListener(listener);
    }

    public void resetBorders() {
        cardA.setBackgroundResource(R.drawable.background_linear);
        cardB.setBackgroundResource(R.drawable.background_linear);
        cardC.setBackgroundResource(R.drawable.background_linear);
        cardD.setBackgroundResource(R.drawable.background_linear);
    }
}