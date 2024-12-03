package th.nguyenbuiquanghuy.th_basic_simplemath;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB;
    RadioButton rbCong, rbTru, rbNhan, rbChia;
    Button btnTinh;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        rbCong = findViewById(R.id.rbCong);
        rbTru = findViewById(R.id.rbTru);
        rbNhan = findViewById(R.id.rbNhan);
        rbChia = findViewById(R.id.rbChia);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        btnTinh = findViewById(R.id.btnTinh);
        tvKetQua = findViewById(R.id.tvKetQua);


        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double a=Double.parseDouble(txtA.getText().toString());
                double b=Double.parseDouble(txtB.getText().toString());
                double kq=0;

                int checkedId = radioGroup.getCheckedRadioButtonId();

                if (checkedId==R.id.rbCong) {
                    kq = a + b;
                } else if (checkedId==R.id.rbTru) {
                    kq = a - b;
                } else if (checkedId==R.id.rbNhan) {
                    kq = a * b;
                } else if (checkedId==R.id.rbChia) {
                    if (b != 0) {
                        kq = a / b;
                    } else {
                        Toast.makeText(MainActivity.this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                tvKetQua.setText("Kết quả: " + kq);
            }
        });
    }
}