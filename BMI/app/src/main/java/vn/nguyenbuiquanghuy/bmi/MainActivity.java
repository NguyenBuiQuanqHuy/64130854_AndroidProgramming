package vn.nguyenbuiquanghuy.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getControl();
    }

    public void BMI(View v){
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
}