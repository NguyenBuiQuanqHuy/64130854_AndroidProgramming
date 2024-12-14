package th.nguyenbuiquanghuy.th_quizappgui2fullcode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
    CardView cardViewQues,cardViewOption1,cardViewOption2,cardViewOption3,cardViewOption4;
    TextView textViewOues,textViewOption1,textViewOption2,textViewOption3,textViewOption4,textViewKQ;
    Button buttonNext;
    ArrayList<Question> questionList;
    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        cardViewQues=findViewById(R.id.cardViewQues);
        cardViewOption1=findViewById(R.id.cardViewOption1);
        cardViewOption2=findViewById(R.id.cardViewOption2);
        cardViewOption3=findViewById(R.id.cardViewOption3);
        cardViewOption4=findViewById(R.id.cardViewOption4);

        textViewOues=findViewById(R.id.tvQues);
        textViewOption1=findViewById(R.id.tvOption1);
        textViewOption2=findViewById(R.id.tvOption2);
        textViewOption3=findViewById(R.id.tvOption3);
        textViewOption4=findViewById(R.id.tvOption4);
        textViewKQ=findViewById(R.id.tvKQ);

        buttonNext=findViewById(R.id.btnNext);

        questionList = new ArrayList<>();
        questionList.add(new Question("What is the capital of France?", "Paris", "London", "Berlin", "Rome", "Paris"));
        questionList.add(new Question("What is 2 + 2?", "3", "4", "5", "6", "4"));

        questionList.add(new Question("Who was the first president of the United States?", "George Washington", "Abraham Lincoln", "Thomas Jefferson", "John Adams", "George Washington"));

        questionList.add(new Question("Which word means 'big' in English?", "Small", "Huge", "Fast", "Slow", "Huge"));

        loadQuestion(currentQuestionIndex);



        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAnswerState();
                currentQuestionIndex++;
                if (currentQuestionIndex < questionList.size()) {
                    loadQuestion(currentQuestionIndex);

                } else {
                    textViewKQ.setText("Quiz finished!");
                    textViewKQ.setTextColor(getResources().getColor(android.R.color.black));
                }
            }
        });
    }

    private void setOptionClickListener(CardView cardView, final String option) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(option);
            }
        });
    }

    private void loadQuestion(int index) {
        Question currentQuestion = questionList.get(index);
        textViewOues.setText(currentQuestion.getQuestion());
        textViewOption1.setText(currentQuestion.getOption1());
        textViewOption2.setText(currentQuestion.getOption2());
        textViewOption3.setText(currentQuestion.getOption3());
        textViewOption4.setText(currentQuestion.getOption4());
        textViewKQ.setText("");

        setOptionClickListener(cardViewOption1, textViewOption1.getText().toString());
        setOptionClickListener(cardViewOption2, textViewOption2.getText().toString());
        setOptionClickListener(cardViewOption3, textViewOption3.getText().toString());
        setOptionClickListener(cardViewOption4, textViewOption4.getText().toString());
    }

    private void checkAnswer(String selectedOption) {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        if (selectedOption.equals(currentQuestion.getAnswer())) {
            setAnswerState(true, selectedOption);
        } else {
            setAnswerState(false, selectedOption);
        }
    }

    private void setAnswerState(boolean isCorrect, String selectedAnswer) {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        if (isCorrect) {
            setCardViewColor(selectedAnswer, getResources().getColor(R.color.green));
            textViewKQ.setText("Correct..");
            textViewKQ.setTextColor(getResources().getColor(R.color.green));
        } else {
            setCardViewColor(selectedAnswer, getResources().getColor(R.color.red));
            textViewKQ.setText("Wrong..");
            textViewKQ.setTextColor(getResources().getColor(R.color.red));
            setCardViewColor(currentQuestion.getAnswer(), getResources().getColor(R.color.green));
        }
    }

    private void setCardViewColor(String selectedAnswer, int color) {
        if (selectedAnswer.equals(textViewOption1.getText().toString())) {
            cardViewOption1.setCardBackgroundColor(color);
        } else if (selectedAnswer.equals(textViewOption2.getText().toString())) {
            cardViewOption2.setCardBackgroundColor(color);
        } else if (selectedAnswer.equals(textViewOption3.getText().toString())) {
            cardViewOption3.setCardBackgroundColor(color);
        } else if (selectedAnswer.equals(textViewOption4.getText().toString())) {
            cardViewOption4.setCardBackgroundColor(color);
        }
    }

    private void resetAnswerState() {
        cardViewOption1.setCardBackgroundColor(getResources().getColor(R.color.background));
        cardViewOption2.setCardBackgroundColor(getResources().getColor(R.color.background));
        cardViewOption3.setCardBackgroundColor(getResources().getColor(R.color.background));
        cardViewOption4.setCardBackgroundColor(getResources().getColor(R.color.background));
        textViewKQ.setText("");
    }
}