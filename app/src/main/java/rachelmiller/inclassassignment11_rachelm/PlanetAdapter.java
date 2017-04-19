package rachelmiller.inclassassignment11_rachelm;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by rachelmiller on 4/18/17.
 */

public class PlanetAdapter extends FirebaseRecyclerAdapter<Planet, PlanetViewHolder> {

    public PlanetAdapter(Query ref) {
        super(Planet.class, R.layout.card_view_planet, PlanetViewHolder.class, ref);
    }

    @Override
    protected void populateViewHolder(PlanetViewHolder viewHolder, Planet planet, int position) {
        viewHolder.bind(planet);
    }
}
