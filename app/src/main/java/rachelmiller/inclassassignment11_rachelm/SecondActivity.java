package rachelmiller.inclassassignment11_rachelm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class SecondActivity extends AppCompatActivity {

    private DatabaseReference planetReference = FirebaseDatabase.getInstance().getReference("planet");
    private ArrayList<Planet> planets = new ArrayList<>();

    private EditText planet;
    private EditText distance;
    private CheckBox hasWater;
    private Planet planetObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent() != null)
            planetObject = (Planet) getIntent().getSerializableExtra(Keys.PLANET);

        planet = (EditText) findViewById(R.id.planetName);
        distance = (EditText) findViewById(R.id.distance);
        hasWater = (CheckBox) findViewById(R.id.hasWater);

        if (planetObject != null) {
            planet.setText(planetObject.name);
            distance.setText(String.valueOf(planetObject.distance));
            hasWater.setChecked(planetObject.hasWater);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_save:
                String id = UUID.randomUUID().toString();
                Random random = new Random();
                String planetName = planet.getText().toString();
                int distanceName = Integer.parseInt(distance.getText().toString());
                boolean hasWaterBox = hasWater.isChecked();
                planetReference.child(id).setValue(new Planet(id, planetName, distanceName, hasWaterBox));

                Intent msIntent = new Intent(this, MainActivity.class);
                startActivity(msIntent);
                return true;
            case R.id.menu_item_trash:
                Intent mrIntent = new Intent(this, MainActivity.class);
                startActivity(mrIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void addPlanet() {
        String id = UUID.randomUUID().toString();
        Planet p = new Planet(id, planet.getText().toString(), Integer.parseInt(distance.getText().toString()), hasWater.isChecked());
        planetReference.child(id).setValue(p);
    }

    public void savePlanet() {
        planetObject.name = planet.getText().toString();
        planetObject.distance = Integer.parseInt(distance.getText().toString());
        planetObject.hasWater = hasWater.isChecked();

        planetReference.child(planetObject.id).setValue(planet);
    }
}

