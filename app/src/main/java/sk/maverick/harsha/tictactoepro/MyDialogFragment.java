/*
 * Copyright (c) 2015.
 * Author: Sree Harsha Mamilla.
 * Pasyanthi
 */

package sk.maverick.harsha.tictactoepro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Harsha on 8/2/2015.
 */
public class MyDialogFragment extends android.app.DialogFragment  implements View.OnClickListener{

    Button lame, serious;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.difficult_level_layout, null);

        lame = (Button) view.findViewById(R.id.difficulty_level_lame);
        serious = (Button) view.findViewById(R.id.difficulty_level_serious);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.difficulty_level_lame :  dismiss();
                Log.v("Difficulty level", "Lame selected");
                break;
            case R.id.difficulty_level_serious : dismiss();
                Log.v("Difficulty level","Serious selected");
                break;
            default: break;
        }
    }
}
