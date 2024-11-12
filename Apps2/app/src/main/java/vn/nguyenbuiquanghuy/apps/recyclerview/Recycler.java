package vn.nguyenbuiquanghuy.apps.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.nguyenbuiquanghuy.apps.MainActivity;
import vn.nguyenbuiquanghuy.apps.R;

public class Recycler extends AppCompatActivity {
    Button btnBack;
    CountryAdapter countryAdapter;
    ArrayList<Country> listCountry;
    RecyclerView recyclerViewCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Khởi tạo dữ liệu và ánh xạ RecyclerView
        listCountry=recyclerViewData();
        recyclerViewCountry=findViewById(R.id.recyclerViewCountry);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerViewCountry.setLayoutManager(layoutManager);
        // Tạo và thiết lập Adapter cho RecyclerView
        countryAdapter=new CountryAdapter(this,listCountry);
        recyclerViewCountry.setAdapter(countryAdapter);

        // Trở về màn hình chính
        btnBack=findViewById(R.id.btnBackRecycler);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backRecycler=new Intent(Recycler.this, MainActivity.class);
                startActivity(backRecycler);
            }
        });
    }

    ArrayList<Country> recyclerViewData(){
        ArrayList<Country> dsCountry =new ArrayList<>();
        Country countryVN= new Country("flag_of_vietnam","Việt Nam","Dân số: gần 101 triệu dân");
        dsCountry.add(countryVN);
        dsCountry.add(new Country("flag_of_cuba","Cuba","Dân số: hơn 11 triệu người"));
        dsCountry.add(new Country("flag_of_laos","Lào","Dân số: khoảng 7.5 triệu người"));
        return dsCountry;
    }
}