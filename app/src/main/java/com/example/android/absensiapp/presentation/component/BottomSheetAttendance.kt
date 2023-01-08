package com.example.android.absensiapp.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.absensiapp.R
import com.example.android.absensiapp.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun BottomSheetAttendance(
    modifier: Modifier = Modifier,
    onClickCheckIn: () -> Unit
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        modifier = modifier,
        sheetShape = RoundedCornerShape(
            topStart = DIMENS_12dp, topEnd = DIMENS_12dp
        ),
        scaffoldState = scaffoldState,
        sheetElevation = DIMENS_8dp,
        sheetContent = {
            BottomSheetAttendanceContent(
                onClickCheckIn = { onClickCheckIn.invoke() }
            )
        },
        content = {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.img_photo_profile),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
    )
}

@Composable
fun BottomSheetAttendanceContent(
    modifier: Modifier = Modifier,
    onClickCheckIn: () -> Unit
) {
    Column(
        modifier = modifier
            .background(BgColor1)
            .fillMaxWidth()
            .padding(top = DIMENS_18dp, bottom = DIMENS_18dp)
    ) {
        Divider(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(DIMENS_4dp)
                .width(DIMENS_80dp)
                .shadow(shape = RoundedCornerShape(DIMENS_8dp), elevation = DIMENS_2dp),
            color = TextColorSecond,
        )

        Spacer(modifier = Modifier.height(DIMENS_12dp))

        Text(
            modifier = Modifier.padding(start = DIMENS_16dp),
            text = stringResource(id = R.string.current_location),
            fontSize = TEXT_SIZE_12sp,
            fontWeight = FontWeight.Bold,
            color = TextColorPrimary
        )

        Spacer(modifier = Modifier.height(DIMENS_10dp))

        Row(
            modifier = Modifier.padding(start = DIMENS_16dp, end = DIMENS_16dp),
        ) {
            Image(
                imageVector = Icons.Default.LocationOn,
                contentDescription = stringResource(R.string.image_location),
                colorFilter = ColorFilter.tint(color = TextColorPrimary)
            )

            Spacer(modifier = Modifier.width(DIMENS_8dp))

            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = stringResource(R.string.sample_location),
                fontSize = TEXT_SIZE_10sp,
                fontWeight = FontWeight.Medium,
                color = TextColorPrimary
            )
        }

        Spacer(modifier = Modifier.height(DIMENS_12dp))

        Text(
            modifier = Modifier.padding(start = DIMENS_16dp),
            text = stringResource(id = R.string.your_photo),
            fontSize = TEXT_SIZE_12sp,
            fontWeight = FontWeight.Bold,
            color = TextColorPrimary
        )

        Spacer(modifier = Modifier.height(DIMENS_8dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = DIMENS_16dp, end = DIMENS_16dp),
            backgroundColor = BgColor4,
            border = BorderStroke(width = DIMENS_1dp, color = TextColorSecond),
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(DIMENS_12dp)
                    .size(DIMENS_24dp),
                imageVector = Icons.Default.AddCircle,
                contentDescription = stringResource(R.string.image_add_photo),
                colorFilter = ColorFilter.tint(color = SecondaryColor)
            )
        }

        Spacer(modifier = Modifier.height(DIMENS_12dp))

        ButtonCommon(
            backgroundColor = PrimaryColor,
            title = stringResource(id = R.string.check_in)
        ) {
            onClickCheckIn.invoke()
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun BottomSheetAttendancePreview() {
    BottomSheetAttendance(
        onClickCheckIn = {}
    )
}