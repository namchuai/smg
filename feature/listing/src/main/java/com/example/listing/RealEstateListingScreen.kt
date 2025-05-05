package com.example.listing

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.component.SMGImage

@Composable
fun RealEstateListingRoute(
    viewModel: RealEstateListingViewModel,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val asyncState = state) {
        is AsyncState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is AsyncState.Success -> {
            RealEstateListingScreen(
                realEstateList = asyncState.data.realEstateList,
                onBookmarkClick = viewModel::onBookmarkClick,
                onAddressClick = { _, _ ->
                    // handle later
                }
            )
        }
        is AsyncState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Error: ${asyncState.errorMessage}",
                    color = Color.Red, // Example error styling
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
internal fun RealEstateListingScreen(
    realEstateList: List<RealEstateItem>,
    onBookmarkClick: (String) -> Unit = {},
    onAddressClick: (latitude: Double?, longitude: Double?) -> Unit = { _, _ -> },
) {
    Scaffold(
        content = { padding ->
            LazyColumn(
                contentPadding = padding,
            ) {
                items(realEstateList) {
                    RealEstateRowItem(
                        item = it,
                        onBookmarkClick = onBookmarkClick,
                        onAddressClick = onAddressClick
                    )
                }
            }
        }
    )
}

@Composable
internal fun RealEstateRowItem(
    modifier: Modifier = Modifier,
    item: RealEstateItem,
    onBookmarkClick: (String) -> Unit = {},
    onAddressClick: (latitude: Double?, longitude: Double?) -> Unit = { _, _ -> },
) {
    Column(
        modifier = modifier.padding(bottom = 16.dp)
    ) {
        Box {
            SMGImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f),
                imageUrl = item.thumbnailUrls.first(),
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 8.dp)
                    .shadow(elevation = 16.dp, shape = RectangleShape)
                    .clip(RectangleShape)
                    .background(Color.White)
                    .border(width = 1.dp, color = Color.Black, shape = RectangleShape)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = item.pricing.toAmountDisplay(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            IconButton(
                onClick = { onBookmarkClick(item.id) },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(Color.Black.copy(alpha = 0.5f), CircleShape)
            ) {
                Icon(
                    imageVector = if (item.bookmarked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (item.bookmarked) "Remove bookmark" else "Add bookmark",
                    tint = Color.White
                )
            }
        }
        Text(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            text = item.title, style = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.W500,
            )
        )
        Row(
            modifier = Modifier
                .clickable { onAddressClick(item.latitude, item.longitude) }
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.LocationOn,
                tint = Color.Blue,
                contentDescription = "Address",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = item.address,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Blue,
                )
            )
        }
    }
}
