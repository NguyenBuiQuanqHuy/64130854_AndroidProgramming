package vn.nguyenbuiquanghuy.pokemon;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    Button buttonTT;
    TextView txtViewKQ;
    void getControl(){
        editTextName=findViewById(R.id.txtName);
        buttonTT=findViewById(R.id.btnPokemon);
        txtViewKQ=findViewById(R.id.textViewKQ);
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
        buttonTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String api=editTextName.getText().toString();
                if(api.isEmpty()){
                    txtViewKQ.setText("Please enter a valid Pokémon ID or Name.");
                }
                else getPokemon(api);
            }
        });
    }


    public void getPokemon(String api) {
        new Thread(() -> {
            try {
                URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + api);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();
                connection.disconnect();

                // Cập nhật UI trên UI Thread
                runOnUiThread(() -> {
                    try {
                        getInfoPokemon(content.toString());
                    } catch (JSONException e) {
                        txtViewKQ.setText("Error parsing JSON.");
                    }
                });

            } catch (IOException e) {
                runOnUiThread(() -> txtViewKQ.setText("Error fetching data."));
            }
        }).start();
    }

    public void getInfoPokemon(String json) throws JSONException {
        // Lấy tên, cân nặng, chiều cao Pokemon
        JSONObject jsonObject=new JSONObject(json);
        String pokemon=jsonObject.getString("name");
        int weight=jsonObject.getInt("weight");
        int height=jsonObject.getInt("height");
        // Lấy loại Pokemon
        StringBuilder types=new StringBuilder("Types: ");
        JSONArray typeArray= jsonObject.getJSONArray("types");
        for (int i = 0; i < typeArray.length(); i++) {
            JSONObject typeObject=typeArray.getJSONObject(i).getJSONObject("type");
            types.append(typeObject.getString("name")).append(" ");
        }
        // Lấy khả năng Pokemon
        StringBuilder abilities =new StringBuilder("Abilities: ");
        JSONArray arrayAbbility= jsonObject.getJSONArray("abilities");
        for (int i = 0; i < arrayAbbility.length(); i++) {
            JSONObject abitity = arrayAbbility.getJSONObject(i).getJSONObject("ability");
            abilities.append(abitity.getString("name")).append(" ");
        }

        // Lấy chỉ số Pokemon
        StringBuilder stats =new StringBuilder("Stats: ");
        JSONArray arrayStats=jsonObject.getJSONArray("stats");
        for (int i = 0; i < arrayStats.length(); i++) {
            JSONObject stat = arrayStats.getJSONObject(i).getJSONObject("stat");
            int baseStat = arrayStats.getJSONObject(i).getInt("base_stat");
            stats.append(stat.getString("name")).append(": ").append(baseStat).append("\n");
        }
        // Lấy link hình ảnh pokemon
        JSONObject sprites = jsonObject.getJSONObject("sprites");
        String frontSprite = sprites.getString("front_default");

        // In ra màn hình
        txtViewKQ.setText("Name: " +pokemon +
                "\nWeight: " + weight +
                "\nHeight: " + height +
                "\n" + types +
                "\n" + abilities +
                "\n" + stats +
                "\nSprite URL: " + frontSprite);
    }
}