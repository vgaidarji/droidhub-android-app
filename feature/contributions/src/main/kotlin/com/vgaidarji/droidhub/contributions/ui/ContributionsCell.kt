package com.vgaidarji.droidhub.contributions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributionsDay

@Composable
fun ContributionsCell(contributionsDay: GitHubUserContributionsDay) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color(android.graphics.Color.parseColor(contributionsDay.color)))
            .size(24.dp)
    ) {
        // show contributions count per day (hidden to match GitHub UI), uncomment for debug
        //Text(text = contributionsDay.contributionCount.toString(), color = Color.White)
    }
}
