/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MyDialogFragment extends android.app.DialogFragment  implements View.OnClickListener{

    Button lame, serious;
    Intent intent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.difficult_level_layout, null);

        lame = (Button) view.findViewById(R.id.difficulty_level_lame);
        serious = (Button) view.findViewById(R.id.difficulty_level_serious);
        lame.setOnClickListener(this);
        serious.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.difficulty_level_lame :
                                                    ArtificialIntelligence.setIntelligence(new LameIntelligence());
                                                    Log.v("Difficulty level", "Lame selected");

                                                    intent = new Intent(getActivity(), GameActivity.class);
                                                    intent.putExtra("player-type", "computer");
                                                    startActivity(intent);
                                                    dismiss();
                                                    break;

            case R.id.difficulty_level_serious :
                                                    ArtificialIntelligence.setIntelligence(new ABitSeriousIntelligence());
                                                    Log.v("Difficulty level", "Serious selected");

                                                    intent = new Intent(getActivity(), GameActivity.class);
                                                    intent.putExtra("player-type", "computer");
                                                    startActivity(intent);
                                                    dismiss();
                                                    break;
            default: break;
        }
    }
}
