import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

public class ${NAME} extends DiffUtil.Callback {
    private List<${LIST_MODEL}> oldList;
    private List<User> newList;

    public ${NAME}(List<${LIST_MODEL}> oldList, List<${LIST_MODEL}> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList == null ? 0 : oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList == null ? 0 : newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition == newItemPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}

//    public void updateList(List<Note> listUpdate){
//        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new NoteDiffUtil(noteList, listUpdate));
//        diffResult.dispatchUpdatesTo(this);
//        noteList.clear();
//        noteList.addAll(listUpdate);
//    }

