package com.example.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest.Builder
import coil3.request.crossfade
import coil3.size.Precision

@Composable
fun SMGImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
) {
    val request = Builder(LocalPlatformContext.current).apply {
        data(imageUrl)
        crossfade(true)
        precision(Precision.EXACT)
        memoryCacheKey(imageUrl)
        diskCacheKey(imageUrl)
    }.build()
    AsyncImage(
        model = request,
        contentDescription = contentDescription,
        contentScale = contentScale,
        alignment = alignment,
        modifier = modifier,
    )
}