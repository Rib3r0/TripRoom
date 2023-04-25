package br.senai.sp.jandira.triproom.repository

import br.senai.sp.jandira.triproom.model.Trip
import java.time.LocalDate

class TripRpository {

    companion object{
        fun getTrips(): List<Trip>{
            return listOf(
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Cidede de merda, nao tem porra nenhuma",
                    starDate = LocalDate.of(2023,4,15),
                    endDate = LocalDate.of(2023,4,15)
                ),
                Trip(
                    id = 2,
                    location = "Jandira",
                    description = "Cidede de merda, nao tem porra nenhuma",
                    starDate = LocalDate.of(2023,4,15),
                    endDate = LocalDate.of(2023,4,15)
                ),
                Trip(
                    id = 3,
                    location = "Jandira",
                    description = "Cidede de merda, nao tem porra nenhuma",
                    starDate = LocalDate.of(2023,4,15),
                    endDate = LocalDate.of(2023,4,15)
                ),
                Trip(
                    id = 4,
                    location = "Jandira",
                    description = "Cidede de merda, nao tem porra nenhuma",
                    starDate = LocalDate.of(2023,4,15),
                    endDate = LocalDate.of(2023,4,15)
                ),
            )
        }
    }

}