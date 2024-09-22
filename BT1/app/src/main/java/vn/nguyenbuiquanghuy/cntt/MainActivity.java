package vn.nguyenbuiquanghuy.cntt;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import vn.nguyenbuiquanghuy.cntt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
    public void Hello(View v){
        //Tìm điều khiển
        EditText Sothunhat= findViewById(R.id.edtNum1);
        EditText Sothuhai= findViewById(R.id.edtNum2);
        //Lấy dữ liệu(getter)
        String s1=Sothunhat.getText().toString();
        String s2=Sothuhai.getText().toString();
        //Chuyển kiểu
        int num1= Integer.parseInt(s1);
        int num2=Integer.parseInt(s2);
        int sum=num1+num2;
        //Xuất kết quả'
        String tong="Tổng là"+ String.valueOf(sum);
        Toast.makeText(this,tong,Toast.LENGTH_SHORT).show();
    }
}