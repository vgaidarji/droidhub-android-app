package com.vgaidarji.droidhub.contributions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContributionsFragment : Fragment() {
    private val contributionsViewModel: ContributionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DroidHubTheme {
                    ContributionsScreen(contributionsViewModel = contributionsViewModel)
                }
            }
        }
    }
}
