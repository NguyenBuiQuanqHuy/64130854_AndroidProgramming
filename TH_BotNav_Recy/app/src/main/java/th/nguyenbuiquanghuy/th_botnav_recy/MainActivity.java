package th.nguyenbuiquanghuy.th_botnav_recy;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.botnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.cn1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Cn1Fragment()).commit();
                } else if (item.getItemId() == R.id.cn2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Cn2Fragment()).commit();
                } else if (item.getItemId() == R.id.cn3) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Cn3Fragment()).commit();
                } else if (item.getItemId() == R.id.cn4) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Cn4Fragment()).commit();
                }
                return true;
            }
        });
        }
}