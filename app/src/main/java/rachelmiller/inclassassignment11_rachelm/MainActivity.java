package rachelmiller.inclassassignment11_rachelm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);//calling from my main menu object takes menu xml and inflates it
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_add:
                Intent msIntent = new Intent(this, SecondActivity.class);
                startActivity(msIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
