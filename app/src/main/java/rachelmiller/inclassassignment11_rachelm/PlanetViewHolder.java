package rachelmiller.inclassassignment11_rachelm;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rachelmiller on 4/18/17.
 */

public class PlanetViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView planetNameText;
    private TextView planetDistanceText;
    private TextView planetHasWater;
    private Context context;

    public PlanetViewHolder(View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        planetNameText = (TextView) itemView.findViewById(R.id.planet_name);
        planetDistanceText = (TextView) itemView.findViewById(R.id.planet_distance);
        planetHasWater = (TextView) itemView.findViewById(R.id.planet_hasWater);
        this.context = itemView.getContext();
    }

    public void bind(final Planet planet) {
        planetNameText.setText(planet.name);
        planetDistanceText.setText("Distance: " + planet.distance);
        planetHasWater.setText("Has water: " + planet.hasWater);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, planetNameText.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
