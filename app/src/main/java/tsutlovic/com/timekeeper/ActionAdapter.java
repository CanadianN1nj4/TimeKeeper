package tsutlovic.com.timekeeper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import tsutlovic.com.timekeeper.model.Action;

public class ActionAdapter extends ArrayAdapter<Action>{

    //region Field Variables
    private Context context;
    private int resource;
    //endregion

    //region Constructor

    ActionAdapter(Context context, int resource, ArrayList<Action> actions){
        super(context, resource, actions);

        this.context = context;
        this.resource = resource;

    }

    //endregion

}
