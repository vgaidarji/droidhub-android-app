package com.vgaidarji.droidhub.ui.starred

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vgaidarji.droidhub.databinding.FragmentStarredBinding

class StarredFragment : Fragment() {

    private var _binding: FragmentStarredBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val starredViewModel =
            ViewModelProvider(this).get(StarredViewModel::class.java)

        _binding = FragmentStarredBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textStarred
        starredViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
