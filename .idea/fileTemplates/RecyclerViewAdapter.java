import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ${NAME} extends RecyclerView.Adapter<${NAME}.${VIEW_HOLDER}> {
    List<${MODEL_LIST}> ${NAME_MODEL_LIST};

    public ${NAME}(List<${MODEL_LIST}> userList) {
        this.${NAME_MODEL_LIST} = ${NAME_MODEL_LIST};
    }
    
    @NonNull
    @Override
    public ${VIEW_HOLDER} onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.${NAME_LAYOUT}, parent, false);
        return new ${VIEW_HOLDER}(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ${VIEW_HOLDER} holder, int position) {

    }

    @Override
    public int getItemCount() {
        return ${NAME_MODEL_LIST} == null ? 0 : ${NAME_MODEL_LIST}.size();
    }

    class ${VIEW_HOLDER} extends RecyclerView.ViewHolder {

        public ${VIEW_HOLDER}(@NonNull View itemView) {
            super(itemView);

        }
    }
}