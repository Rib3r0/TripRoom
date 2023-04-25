package br.senai.sp.jandira.triproom.model

import androidx.compose.ui.graphics.painter.Painter
import br.senai.sp.jandira.triproom.R
import java.time.LocalDate

data class Trip(
    var id: Long = 0,
    var location: String = "",
    var description: String = "",
    var starDate: LocalDate = LocalDate.of(2000,1,1),
    var endDate: LocalDate = LocalDate.of(2000,1,1),
    var image: Int = R.drawable.defaultimagethumbnail
)
