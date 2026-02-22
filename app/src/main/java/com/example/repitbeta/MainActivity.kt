package com.example.repitbeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repitbeta.ui.theme.RepItBetaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepItBetaTheme {
                RoutinesHomePage()
            }
        }
    }
}

@Composable
fun RoutinesHomePage() {
    val routines = remember { mutableStateListOf<Routine>().apply { addAll(RoutineUtil.getAllRoutines()) } }
    var autoId by remember { mutableIntStateOf(routines.size + 1) }

    Scaffold(
        containerColor = Color(0xFFF4F4F4)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                HeaderCard()
            }

            item {
                SectionTitle(title = "Mes défis")
            }

            items(routines, key = { it.id }) { routine ->
                RoutineCard(routine = routine)
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            val newRoutine = Routine(
                                id = autoId,
                                title = "Routine #$autoId",
                                description = "Routine ajoutée rapidement depuis l'accueil.",
                                category = "Libre",
                                progressPercent = 0,
                                frequency = "Quotidien"
                            )
                            RoutineUtil.addRoutine(newRoutine)
                            routines.add(newRoutine)
                            autoId += 1
                        }
                    ) {
                        Text("Ajouter une routine test")
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun HeaderCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF6D5BD0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Bonjour !",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = "Prêt pour ton défi du jour ?",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Exemples: boire de l'eau, marcher, méditer.",
                color = Color.White.copy(alpha = 0.85f)
            )
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun RoutineCard(routine: Routine) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = routine.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = routine.frequency, color = Color.DarkGray)
            }

            Text(
                text = routine.description,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = routine.category,
                color = Color(0xFF24A85B),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { routine.progressPercent / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color(0xFF35C3E6),
                trackColor = Color(0xFFE6EEF2)
            )

            Text(
                text = "Progression: ${routine.progressPercent}%",
                modifier = Modifier.padding(top = 6.dp),
                fontWeight = FontWeight.Medium
            )
        }
    }
}
