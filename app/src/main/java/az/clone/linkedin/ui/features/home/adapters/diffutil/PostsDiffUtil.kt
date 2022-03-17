package az.clone.linkedin.ui.features.home.adapters.diffutil

import androidx.recyclerview.widget.DiffUtil
import az.clone.linkedin.ui.features.home.models.Post

class PostsDiffUtil(
    private val oldList: List<Post>,
    private val newList: List<Post>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}