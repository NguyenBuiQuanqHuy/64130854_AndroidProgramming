package vn.nguyenbuiquanghuy.apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {
    Button bmi;
    EditText editTextH,editTextW;
    TextView textViewKQ,textViewBMI;
    void getControl(){
        bmi=findViewById(R.id.btnBMI);
        editTextW=findViewById(R.id.edittxtWeight);
        editTextH=findViewById(R.id.edittextHeight);
        textViewKQ=findViewById(R.id.textViewKQ);
        textViewBMI=findViewById(R.id.textViewbmi);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getControl();
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double w=Double.parseDouble(editTextW.getText().toString());
                double h=Double.parseDouble(editTextH.getText().toString());
                double bmi=w/(h*h);
                String bmiRounded=String.format("%.1f",bmi);
                textViewKQ.setText(String.valueOf(bmiRounded));
                if(bmi<18.5){
                    textViewBMI.setText("Gầy");
                }
                else if(bmi>=18.5 && bmi<=24.9){
                    textViewBMI.setText("Bình thường");
                } else if (bmi<25) {
                    textViewBMI.setText("Thừa cân");
                } else if (bmi>=25 && bmi<29.9) {
                    textViewBMI.setText("Tiền béo phì");
                } else if (bmi>=30 && bmi<=34.9) {
                    textViewBMI.setText("Béo phì độ I");
                }
                else textViewBMI.setText("Béo phì độ II");
            }
        });
    }

    public void Back(View v){
        Intent backMain=new Intent(BMI.this,MainActivity.class);
        startActivity(backMain);
    }
}