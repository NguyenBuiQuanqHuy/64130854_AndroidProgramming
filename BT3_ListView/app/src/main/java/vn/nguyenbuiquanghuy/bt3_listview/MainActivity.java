package vn.nguyenbuiquanghuy.bt3_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Nguồn dữ liệu
    ArrayList<String> dsBaiTho;
    //
    ListView lvBaiTho;
    Button btnThemBaiTho;
    EditText editTextTenBT;
    void getControl(){
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
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getControl();
        dsBaiTho=getData();
        ArrayAdapter<String>
                adapterBaiTho=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dsBaiTho);
        lvBaiTho.setAdapter(adapterBaiTho);
        lvBaiTho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                XuLyKhiNhanVaoViTri(i);

            }

        });
        btnThemBaiTho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lấy tên bài
                String tenBT=editTextTenBT.getText().toString();
                //Thêm
                dsBaiTho.add(tenBT);
                //Báo adapter cập nhât lại View
                adapterBaiTho.notifyDataSetChanged();
            }
        });
    }
    void XuLyKhiNhanVaoViTri(int pos){
        String item=dsBaiTho.get(pos);
        Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
    }
}