package com.example.compose

import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            createListView()

        }
    }
}


@Preview
@Composable
fun createListView() {
    MaterialTheme() {

        FlexColumn {
            inflexible {
                // Item height will be equal content height
                TopAppBar( // App Bar with title
                    title = { Text("Jetpack Compose Sample", style = TextStyle(color = Color.White)) },
                    color = Color.Red
                )
            }
            expanded(1F) {
                // occupy whole empty space in the Column
                VerticalScroller {
                    Column {
                        (0..10).forEachIndexed { index, _ ->
                            Container(expanded = true, height = 350.dp) {
                                createListItem(index)
                            }
                            Divider(color = Color.Gray, height = 1.dp)
                        }
                    }
                }
            }
        }
        /*VerticalScroller {
            Column {
                (0..10).forEachIndexed { index, _ ->
                    Container(expanded = true, height = 350.dp) {
                        createListItem(index)
                    }
                    Divider(color = Color.Gray, height = 1.dp)
                }
            }
        }*/

    }
}


@Composable
private fun createListItem(itemIndex: Int) {
    val image = +imageResource(R.drawable.girl_in_glasses)
    Column(
        crossAxisSize = LayoutSize.Expand,
        modifier = Spacing(16.dp)
    )
    {
        Container(expanded = true, height = 180.dp) {
            Clip(shape = RoundedCornerShape(8.dp)) {
                DrawImage(image)
            }
        }
        HeightSpacer(16.dp)
        Text("He\'s a butterscotch Babe Ruth with crushed jewels on his tooth"+

            "made forty grand last weekend, I was sleeveless",
            maxLines = 2, overflow = TextOverflow.Ellipsis,
            style = (+themeTextStyle { h6 }).withOpacity(0.87f)
        )
        Text("Im off guys, cya later",
            style = (+themeTextStyle { body2 }).withOpacity(0.87f)
        )
        Text("Bella ciao",
            style = (+themeTextStyle { body2 }).withOpacity(0.6f)
        )

        Padding(left = 8.dp, right = 8.dp, top = 8.dp, bottom = 8.dp) {
            FlexRow(crossAxisAlignment = CrossAxisAlignment.Center) {
                expanded(1.0f) {
                    Text("")
                }
                inflexible {
                    Button(
                        "Likes 20$itemIndex",
                        style = ContainedButtonStyle(color = Color.Red),
                        onClick = {
                            //viewDialog()
                        })

                }
            }
        }
    }
}

@Composable
private fun viewDialog() {
    AlertDialog(
        onCloseRequest = {
            //closing request
        },
        title = {
            Text("Title of Alert Box")
        },
        text = {
            Text("Message of Alert Box")
        },
        confirmButton = {
            Button(

                text = "OK",
                style = ContainedButtonStyle(color = Color.Red),
                onClick = {
                    //click listeners request
                }
            )
        }
    )
}