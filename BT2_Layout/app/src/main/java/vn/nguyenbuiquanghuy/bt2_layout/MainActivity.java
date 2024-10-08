package vn.nguyenbuiquanghuy.bt2_layout;

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
    Button bCong,bTru,bNhan,bChia;
    EditText editTextA,editTextB;
    TextView textViewKQ;

    void getControls(){
        bCong=findViewById(R.id.btnCong);
        bTru=findViewById(R.id.btnTru);
        bNhan=findViewById(R.id.btnNhan);
        bChia=findViewById(R.id.btnChia);
        editTextA=findViewById(R.id.txtA);
        editTextB=findViewById(R.id.txtB);
        textViewKQ=findViewById(R.id.txtviewKQ);
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
        getControls();
    }
    public void Xuly_Cong(View v) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double kq = a + b;
        textViewKQ.setText(String.valueOf(kq));
    }

    public void Xuly_Tru(View v) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double kq = a - b;
        textViewKQ.setText(String.valueOf(kq));
    }

    public void Xuly_Nhan(View v) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double kq = a * b;
        textViewKQ.setText(String.valueOf(kq));
    }

    public void Xuly_Chia(View v) {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        if(b!=0){
            double kq = a / b;
            textViewKQ.setText(String.valueOf(kq));
        }
        else {
            String tb="Không hợp lệ!";
            Toast.makeText(this,tb,Toast.LENGTH_SHORT).show();
        }
    }
}