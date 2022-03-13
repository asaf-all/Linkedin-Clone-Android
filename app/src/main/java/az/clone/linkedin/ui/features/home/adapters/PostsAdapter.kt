package az.clone.linkedin.ui.features.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import az.clone.linkedin.databinding.ItemPostBinding
import az.clone.linkedin.ui.extensions.loadImage
import az.clone.linkedin.ui.features.home.models.Post
import az.clone.linkedin.ui.tools.diffutil.PostsDiffUtil
import com.bumptech.glide.Glide

class PostsAdapter(
    private val onItemClick: (Post) -> Unit
) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

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


    inner class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

            items[position].userProfileImg?.let { url ->
                binding.imgUser.loadImage(url)
            }
            items[position].picture?.let { url ->
                binding.imgContent.loadImage(url)
            }

            binding.txtUserName.text = items[position].userName
            binding.txtUserHeadline.text = items[position].userHeadline
            binding.txtContent.text = items[position].content
        }
    }

    override fun onCreateViewHolder(root: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(root.context),
                root,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(position = position)
        holder.itemView.setOnClickListener {
            onItemClick.invoke(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}