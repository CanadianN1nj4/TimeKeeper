package tsutlovic.com.timekeeper;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    //region Views
    public View getView(int position, View convertView, ViewGroup parent) {
        //conditional statement to see if the convert view is null and use the inflater
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(resource, parent, false);
        }


        return convertView;
    }
    //endregion
}
