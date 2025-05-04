package com.example.listing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.component.SMGImage

@Composable
fun RealEstateListingRoute(
    viewModel: RealEstateListingViewModel,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    RealEstateListingScreen(
        realEstateList = state.realEstateList,
        onBookmarkClick = { id ->
            viewModel.onBookmarkClick(id)
        },
    )
}

@Composable
internal fun RealEstateListingScreen(
    realEstateList: List<RealEstateItem>,
    onBookmarkClick: (String) -> Unit = {},
) {
    Scaffold(
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding),
            ) {
                items(realEstateList) {
                    RealEstateRowItem(it, onBookmarkClick)
                }
            }
        }
    )
}

@Composable
internal fun RealEstateRowItem(
    item: RealEstateItem,
    onBookmarkClick: (String) -> Unit = {},
) {
    Column {
        SMGImage(
            modifier = Modifier
                .height(200.dp),
            imageUrl = item.thumbnailUrls.first(),
            contentDescription = null,
        )
        Text(text = item.title)
        Button(
            onClick = { onBookmarkClick(item.id) },
        ) {
            Text(text = if (item.bookmarked) "Unbookmark" else "Bookmark")
        }
    }
}

// TODO: add preview