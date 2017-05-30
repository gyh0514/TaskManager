package android.myapplicationdev.com.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15039836 on 30/5/2017.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    Context context;
    ArrayList<Task> tasks;
    int resource;
    TextView tvTask, tvDes;

    public TaskAdapter(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context = context;
        this.tasks = tasks;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        tvTask = (TextView) rowView.findViewById(R.id.tvTask);
        tvDes = (TextView) rowView.findViewById(R.id.tvDes);

        Task task = tasks.get(position);

        tvTask.setText(task.getId()+ " " + task.getTask());
        tvDes.setText(task.getDescription());

        return rowView;
    }
}
