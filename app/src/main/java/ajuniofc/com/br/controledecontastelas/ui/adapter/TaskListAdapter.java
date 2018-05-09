package ajuniofc.com.br.controledecontastelas.ui.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Task;
import ajuniofc.com.br.controledecontastelas.ui.activity.ContasActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.HomeActivity;


public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
    private final List<Task> tasks;
    private HomeActivity activity;

    public TaskListAdapter(List<Task> tasks, HomeActivity activity){
        this.tasks = tasks;
        this.activity = activity;
    }

    @Override
    public TaskListAdapter.TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, ContasActivity.class));
            }
        });
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskListAdapter.TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.bind(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        public TaskViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.task_item_title);
        }

        public void bind(Task task){
            title.setText(task.getTitle());
        }
    }
}
