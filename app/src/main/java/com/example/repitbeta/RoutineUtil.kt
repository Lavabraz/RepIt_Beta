package com.example.repitbeta

/**
 * Fichier Util simple pour stocker les routines en mémoire.
 * Pas d'API, pas de base de données: juste des données locales pour le TP.
 */
data class Routine(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val progressPercent: Int,
    val frequency: String
)

object RoutineUtil {
    private val routines = mutableListOf(
        Routine(
            id = 1,
            title = "Boire 2L d'eau",
            description = "Hydratation quotidienne pour rester en forme.",
            category = "Santé",
            progressPercent = 80,
            frequency = "Quotidien"
        ),
        Routine(
            id = 2,
            title = "Marcher 10 000 pas",
            description = "Objectif de marche journalière.",
            category = "Sport",
            progressPercent = 72,
            frequency = "Quotidien"
        ),
        Routine(
            id = 3,
            title = "Étirements matinaux",
            description = "10 minutes d'étirements doux.",
            category = "Bien-être",
            progressPercent = 45,
            frequency = "5 jours/semaine"
        )
    )

    fun getAllRoutines(): List<Routine> {
        return routines
    }

    fun addRoutine(routine: Routine) {
        routines.add(routine)
    }
}
