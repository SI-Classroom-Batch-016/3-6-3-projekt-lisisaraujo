package de.syntax_institut.mvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import de.syntax_institut.mvvm.SharedViewModel
import de.syntax_institut.mvvm.data.model.Comment
import de.syntax_institut.mvvm.data.model.Location
import de.syntax_institut.mvvm.databinding.FragmentAddCommentBinding
import de.syntax_institut.mvvm.databinding.FragmentAddLocationBinding

class AddCommentFragment : Fragment() {
    private lateinit var binding: FragmentAddCommentBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCommentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.submitBTN.setOnClickListener {

            val comment = binding.commentET.text.toString()
            var location = viewModel.currentLocation.value?.name.toString()
//            var age: Int,
//            var sexualOrientation: MutableList<String>,
//            var gender: MutableList<String>,
//            var isBipoc: Boolean,

            val newComment = Comment(
                "", location, comment, 30, mutableListOf(), mutableListOf(), true
            )

            viewModel.addComment(
                newComment
            )
            it.findNavController().navigateUp()
            Log.d("AddedComment", viewModel.commentsList.value?.last()!!.comment)
            Log.d("CommentsList", viewModel.commentsList.value.toString())
        }
    }
}