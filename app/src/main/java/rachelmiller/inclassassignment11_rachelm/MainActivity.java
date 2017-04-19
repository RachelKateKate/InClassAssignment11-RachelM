package rachelmiller.inclassassignment11_rachelm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanetAdapter planetAdapter;

    private DatabaseReference planetReference = FirebaseDatabase.getInstance().getReference("planet");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        planetAdapter = new PlanetAdapter(planetReference);

        recyclerView.setAdapter(planetAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        planetAdapter.cleanup();
    }

    public void addPlanet(View view) {
        String id = UUID.randomUUID().toString();
        Random random = new Random();
        planetReference.child(id).setValue(new Planet(id, "Some planet", random.nextInt(100), random.nextBoolean()));
    }
}
