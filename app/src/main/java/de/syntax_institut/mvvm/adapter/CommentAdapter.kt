package de.syntax_institut.mvvm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.mvvm.R
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.data.model.Comment
import de.syntax_institut.mvvm.data.model.Location
import de.syntax_institut.mvvm.databinding.CommentCardBinding
import de.syntax_institut.mvvm.databinding.LocationDetailsBinding

class CommentAdapter(
    private val comments: MutableList<Comment>,
//    val itemClickedCallback: (Comment) -> Unit
    val location: String
) :
    RecyclerView.Adapter<CommentAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: CommentCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemViewHolder {
        val binding =
            CommentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val comment = comments[position]
        val binding = holder.binding

        binding.commentTV.text = comment.comment

//        binding.commentCV.setOnClickListener {
//            itemClickedCallback(comment)
//        }


    }
}