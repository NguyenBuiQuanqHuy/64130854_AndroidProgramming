package th.nguyenbuiquanghuy.th_basicgui_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText chieucao, cannang;
    TextView textViewBMI,textViewKQ;
    RadioGroup radioGroupChoosen;
    Button buttonBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        chieucao =findViewById(R.id.txtHeight);
        cannang=findViewById(R.id.txtWeight);
        textViewBMI=findViewById(R.id.tvBMI);
        textViewKQ=findViewById(R.id.tvKQ);
        radioGroupChoosen=findViewById(R.id.radioChoosen);
        buttonBMI=findViewById(R.id.btnBMI);

        buttonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height=Double.parseDouble(chieucao.getText().toString());
                double weight=Double.parseDouble(cannang.getText().toString());
                double bmi=weight/(height*height);
                String bmiRounded=String.format("%.2f",bmi);
                textViewBMI.setText(String.valueOf(bmiRounded));

                int checkID=radioGroupChoosen.getCheckedRadioButtonId();

                if(checkID == R.id.rbYes){
                    if(bmi<17.5){
                        textViewKQ.setText("Asian: Underweight");
                    }
                    else if(bmi>=17.5 && bmi<=22.99){
                        textViewKQ.setText("Asian: Normal weight");
                    } else if (bmi>=23 && bmi<=27.99) {
                        textViewKQ.setText("Asian: Over Weight");
                    }
                    else textViewKQ.setText("Asian: Obese");
                }

                else if(checkID == R.id.rbNo){
                    if(bmi<18.5){
                        textViewKQ.setText("WHO: Underweight");
                    }
                    else if(bmi>=18.5 && bmi<=24.99){
                        textViewKQ.setText("WHO: Normal weight");
                    } else if (bmi>=25 && bmi<=29.99) {
                        textViewKQ.setText("WHO: Over Weight");
                    }
                    else textViewKQ.setText("WHO: Obese");
                }
            }
        });
    }
}