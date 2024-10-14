package vn.nguyenbuiquanghuy.recyclerview_qgia;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CountryAdapter countryAdapter;
    ArrayList<Country> RecyclerCountry;
    RecyclerView recyclerViewCountry;

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
        RecyclerCountry=getRecyclerView();
        recyclerViewCountry=findViewById(R.id.RecyclerQG);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerViewCountry.setLayoutManager(layoutManager);
        countryAdapter=new CountryAdapter(this,RecyclerCountry);
        recyclerViewCountry.setAdapter(countryAdapter);
    }
    ArrayList<Country> getRecyclerView(){
        ArrayList<Country> dsDuLieu=new ArrayList<>();
        Country country1=new Country("vietnam","Việt Nam","100 triệu dân");
        dsDuLieu.add(country1);
        dsDuLieu.add(new Country("cuba","Cuba","50 triệu dân"));
        return dsDuLieu;
    }
}