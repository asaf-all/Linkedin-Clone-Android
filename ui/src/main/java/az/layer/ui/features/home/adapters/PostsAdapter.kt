package az.layer.ui.features.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import az.layer.ui.databinding.ItemPostBinding
import az.layer.ui.features.home.models.Post
import az.layer.ui.tools.diffutil.PostsDiffUtil

class PostsAdapter(
    private val onItemClick: (Post) -> Unit
): RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    private val items = arrayListOf<Post>()

    fun setItems(list: List<Post>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun updateAllItems(newList: List<Post>) {
        val diffUtil = PostsDiffUtil(items, newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        items.clear()
        items.addAll(newList)
        diffUtilResult.dispatchUpdatesTo(this)
    }

    fun addNewItems(newItems: List<Post>) {
        val newList = arrayListOf<Post>()
        newList.addAll(items)
        for (index in items.indices) {
            if (newItems.size > index) {
                if (items[index] != newItems[index]) {
                    newList.add(newItems[index])
                }
            }
        }
        val diffUtil = PostsDiffUtil(items, newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        items.clear()
        items.addAll(newList)
        diffUtilResult.dispatchUpdatesTo(this)
    }


    inner class PostViewHolder(itemView: ItemPostBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind() {
        }
    }

    override fun onCreateViewHolder(root: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(ItemPostBinding.inflate(LayoutInflater.from(root.context), root, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind()
        holder.itemView.setOnClickListener {
            onItemClick.invoke(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}