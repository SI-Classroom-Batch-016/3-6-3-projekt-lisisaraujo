package de.syntax_institut.mvvm.data

import de.syntax_institut.mvvm.data.model.Comment
import de.syntax_institut.mvvm.data.model.Location

class Repository {

    val locations: MutableList<Location>
        get() {
            return loadLocations()
        }

    val comments: MutableList<Comment>
        get() {
            return loadComments()
        }

    private fun loadLocations(): MutableList<Location> {
        return mutableListOf(
            Location("Tipsy Bear", 52.540937, 13.4084972, "Bar"),
            Location("SilverFuture", 52.4880615, 13.4280239, "Bar"),
            Location("Südblock", 52.4987318, 13.4129215, "Bar"),
            Location("Roses", 52.5005109, 13.4171672, "Bar"),
            Location("Möbel Olfe", 52.499985, 13.415262, "Bar"),
            Location("Bar Zum schmutzigen Hobby", 52.507921, 13.451315, "Bar"),
            Location("Monster Ronsons's Ichiban Karaoke", 52.5052743, 13.4462772, "Bar"),
            Location("FICKEN 3000", 52.4886085, 13.4181037, "Bar"),
            Location("Café-Bar Himmelreich", 52.4885878, 13.3523611, "Bar"),
            Location("Paloma Bar", 52.4993178, 13.4167934, "Bar"),
            Location("Betty F***", 52.5276026, 13.4030642, "Bar"),
            Location("Capture Bar", 52.5098104, 13.45481, "Bar"),
            Location("Greifbar", 52.5496812, 13.4151626, "Bar"),
            Location("New Action (only men)", 52.5001681, 13.347258, "Bar"),
            Location("WOOF Bar (only men)", 52.4992382, 13.3415847, "Bar"),
            Location("TOM'S Bar (only men)", 52.4980435, 13.3493819, "Bar"),
            Location("BarbieBar", 52.4894692, 13.3845674, "Bar"),
            Location("To Be Free", 52.5331259, 13.1970187, "Bar"),
            Location("Besenkammer", 52.5206225, 13.4101261, "Bar"),
            Location("OYA", 52.5009211, 13.4210326, "Bar"),
            Location("Große Freiheit", 52.513483, 13.4539248, "Bar"),
            Location("Cafe Cralle", 52.550633, 13.3610829, "Bar"),
            Location("kwia", 52.4940408, 13.4236778, "Bar"),
            Location("Kfetisch", 52.483106, 13.4395609, "Bar"),
            Location("Berghain", 52.5112867, 13.4405008, "Club"),
            Location("About_blank", 52.5025336, 13.4641796, "Club"),
            Location("SchwuZ", 52.4794165, 13.4315742, "Club"),
            Location("Lab.Oratory", 52.5116122, 13.4409219, "Club"),
            Location("SO36", 52.5003921, 13.4199078, "Club"),
            Location("Watergate", 52.5010558, 13.4430581, "Club"),
            Location("Sisyphos", 52.4929592, 13.4890505, "Club"),
            Location("Golden Gate", 52.5129892, 13.4055363, "Club"),
            Location("Club Triebwerk", 52.4892443, 13.4164536, "Club"),
            Location("Revier Südost", 52.45989, 13.503286, "Club"),
            Location("TRAUMA BAR UND KINO", 52.5306511, 13.362311, "Club"),
            Location("Volkspark Hasenheide (cruising)", 52.4842015, 13.4145337, "Cruising"),
            Location("Tiergarten (cruising)", 52.5107805, 13.3365643, "Cruising"),
            Location("Volkspark Friedrichshain (cruising)", 52.5280353, 13.4341994, "Cruising"),
            Location("Grunewald (cruising)", 52.4858443, 13.2035949, "Cruising"),
            Location("Ernst-Thälmann park (cruising)", 52.5386387, 13.4312424, "Cruising"),
            Location("Oyoun", 13.4206611, 52.4838959, "Community-Center")
        )
    }

    private fun loadComments(): MutableList<Comment> {
        return mutableListOf(
            Comment(
                "23.05.2024",
                "Kfetisch",
                "first comment",
                30,
                mutableListOf("gay", "queer"),
                mutableListOf("cis woman", "gender fluid"),
                true
            ),
            Comment(
                "23.05.2024",
                "Kfetisch",
                "first comment",
                30,
                mutableListOf("gay", "queer"),
                mutableListOf("cis woman", "gender fluid"),
                true
            ),
            Comment(
                "23.05.2024",
                "Kfetisch",
                "first comment",
                30,
                mutableListOf("gay", "queer"),
                mutableListOf("cis woman", "gender fluid"),
                true
            ),
            Comment(
                "23.05.2024",
                "location",
                "first comment",
                30,
                mutableListOf("gay", "queer"),
                mutableListOf("cis woman", "gender fluid"),
                true
            ),
            Comment(
                "23.05.2024",
                "location",
                "first comment",
                30,
                mutableListOf("gay", "queer"),
                mutableListOf("cis woman", "gender fluid"),
                true
            ),
            Comment(
                "23.05.2024",
                "location",
                "first comment",
                30,
                mutableListOf("gay", "queer"),
                mutableListOf("cis woman", "gender fluid"),
                true
            )
        )
    }
}