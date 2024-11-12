package vn.nguyenbuiquanghuy.apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListViewBT extends AppCompatActivity {
    ArrayList<String> dsBaiTho;
    ListView lvBaiTho;
    Button btnThemBaiTho;
    Button btnBack;
    EditText editTextTenBT;
    void getControl(){
        btnBack=findViewById(R.id.btnBackList);
        lvBaiTho=findViewById(R.id.lvBT);
        btnThemBaiTho=findViewById(R.id.btnThem);
        editTextTenBT=findViewById(R.id.edtTenBaiTho);
    }
    //Hàm đọc dữ liệu từ nguồn bất kỳ
    ArrayList<String> getData(){
        ArrayList<String> lstTenBaiTho=new ArrayList<>();
        lstTenBaiTho.add("Bánh trôi nước");
        lstTenBaiTho.add("Sóng");
        lstTenBaiTho.add("Đất nước");
        lstTenBaiTho.add("Tây Tiến");
        lstTenBaiTho.add("Đồng Chí");
        return lstTenBaiTho;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_bt);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getControl();
        // Lấy dữ liệu
        dsBaiTho=getData();
        // Hiển thị thông tin
        ArrayAdapter<String>
                adapterBaiTho=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dsBaiTho);
        lvBaiTho.setAdapter(adapterBaiTho);
        //Thêm
        btnThemBaiTho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenBT=editTextTenBT.getText().toString();
                //Thêm
                dsBaiTho.add(tenBT);
                //Báo adapter cập nhât lại View
                adapterBaiTho.notifyDataSetChanged();
            }
        });

        // Quay lại
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backMain=new Intent(ListViewBT.this,MainActivity.class);
                startActivity(backMain);
            }
        });
    }
}