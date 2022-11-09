package com.ramanie.motionlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene

@OptIn(ExperimentalMotionApi::class)
@Composable
fun ProfileHeader(progress: Float){
    val context = LocalContext.current
    val motionScene = remember {
        // we need the string version of whatever we wrote in the file so we read the bytes and then decode them to a str
        context.resources.openRawResource(R.raw.motion_scene).readBytes().decodeToString()
    }

    MotionLayout(motionScene = MotionScene(content = motionScene),
        // the progress defines the %age value of where we're currently at with the animation
        progress = progress,
        modifier = Modifier.fillMaxWidth()
        ) {
        // below we're getting the custom properties we passed to the profile_pic blocks(both start and end)
        val properties = motionProperties(id = "profile_pic")
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            // the layoutId() has to match the key used in the ConstraintsSet to rep. the box
            .layoutId("box"))
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "profile picture",
            modifier = Modifier
                .clip(CircleShape)
                .border(width = 1.dp, color = properties.value.color("background"), shape = CircleShape)
                .layoutId("profile_pic")
        )
        Text(text = "Random Text",
            modifier = Modifier.layoutId("username"),
            fontSize = 24.sp,
            color = properties.value.color("background"))
    }
}