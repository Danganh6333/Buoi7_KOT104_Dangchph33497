package com.dangchph33497.fpoly.buoi7_kot104.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.dangchph33497.fpoly.buoi7_kot104.R
import com.dangchph33497.fpoly.buoi7_kot104.model.Product
import com.dangchph33497.fpoly.buoi7_kot104.model.Type


class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val typeList = listOf(
        Type(1, R.drawable.baseline_star_24, "Popular"),
        Type(2, R.drawable.outline_chair_alt_24, "Chair"),
        Type(3, R.drawable.outline_table_bar_24, "Table"),
        Type(4, R.drawable.outline_chair_24, "Armchair"),
        Type(5, R.drawable.outline_bed_24, "Bed")
    )

    val productList = listOf(
        Product(1, "Black Simple Lamp", 12.0f, R.drawable.image2, 1),
        Product(2, "Minimal Stand", 25.0f, R.drawable.image4, 2),
        Product(3, "Coffee Chair", 20.0f, R.drawable.image1, 3),
        Product(4, "Simple Desk", 50.0f, R.drawable.image5, 4)
    )
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(16.dp)
        ) {
            typeList.forEach { type ->
                TypeItem(type = type)
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(16.dp)
        ) {
            items(productList) { product ->
                ProductItem(product = product)
            }
        }
    }
}
private val nunitoSansFamily = FontFamily(
    Font(R.font.nunitosans_10pt_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.nunitosans_italic_variablefont_ytlc_opsz_wdth_wght, FontWeight.Normal, FontStyle.Normal)
)
@Composable
fun TypeItem(type: Type) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 19.dp)

    ) {
        Box(
            modifier = Modifier
                .padding(2.dp)
                .size(50.dp)
                .background(
                    color = Color("#F5F5F5".toColorInt()),
                    shape = RoundedCornerShape(9.dp)
                ),
            contentAlignment = Alignment.Center,
        ) {
            Image(painter = painterResource(id = type.icon), contentDescription = "Logo")
        }
        Text(text = type.tenTheLoai, textAlign = TextAlign.Center)
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .padding(8.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = product.anh),
                contentDescription = product.tenSP,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20)
                    )
                    .padding(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_shopping_bag_24),
                    contentDescription = "Add to Cart",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(18.dp)
                )
            }
        }
        Text(
            text = product.tenSP,
            color = Color("#606060".toColorInt()),
            modifier = Modifier.padding(top = 8.dp),
            fontFamily = nunitoSansFamily,
        )
        Text(
            text = "$${product.donGia}",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


