package de.syntax_institut.mvvm.data

import de.syntax_institut.mvvm.data.model.Location

class Repository {

    val locations: MutableList<Location>
        get() {
            return loadLocations()
        }

    private fun loadLocations(): MutableList<Location> {
        return  mutableListOf(
            Location("Tipsy Bear", "", listOf(52.540937, 13.4084972), "Bar", "Berlin", mutableListOf()),
            Location("SilverFuture", "", listOf(52.4880615, 13.4280239), "Bar", "Berlin", mutableListOf()),
            Location("Südblock", "", listOf(52.4987318, 13.4129215), "Bar", "Berlin", mutableListOf()),
            Location("Roses", "", listOf(52.5005109, 13.4171672), "Bar", "Berlin", mutableListOf()),
            Location("Möbel Olfe", "Adalbertstr. 1", listOf(52.499985, 13.415262), "Bar", "Berlin", mutableListOf()),
            Location("Bar Zum schmutzigen Hobby", "", listOf(52.507921, 13.451315), "Bar", "Berlin", mutableListOf()),
            Location("Monster Ronsons's Ichiban Karaoke", "", listOf(52.5052743, 13.4462772), "Bar", "Berlin", mutableListOf()),
            Location("FICKEN 3000", "", listOf(52.4886085, 13.4181037), "Bar", "Berlin", mutableListOf()),
            Location("Café-Bar Himmelreich", "", listOf(52.4885878, 13.3523611), "Bar", "Berlin", mutableListOf()),
            Location("Paloma Bar", "", listOf(52.4993178, 13.4167934), "Bar", "Berlin", mutableListOf()),
            Location("Betty F***", "", listOf(52.5276026, 13.4030642), "Bar", "Berlin", mutableListOf()),
            Location("Capture Bar", "", listOf(52.5098104, 13.45481), "Bar", "Berlin", mutableListOf()),
            Location("Greifbar", "", listOf(52.5496812, 13.4151626), "Bar", "Berlin", mutableListOf()),
            Location("New Action (only men)", "", listOf(52.5001681, 13.347258), "Bar", "Berlin", mutableListOf()),
            Location("WOOF Bar (only men)", "", listOf(52.4992382, 13.3415847), "Bar", "Berlin", mutableListOf()),
            Location("TOM'S Bar (only men)", "", listOf(52.4980435, 13.3493819), "Bar", "Berlin", mutableListOf()),
            Location("BarbieBar", "", listOf(52.4894692, 13.3845674), "Bar", "Berlin", mutableListOf()),
            Location("To Be Free", "", listOf(52.5331259, 13.1970187), "Bar", "Berlin", mutableListOf()),
            Location("Besenkammer", "", listOf(52.5206225, 13.4101261), "Bar", "Berlin", mutableListOf()),
            Location("OYA", "", listOf(52.5009211, 13.4210326), "Bar", "Berlin", mutableListOf()),
            Location("Große Freiheit", "", listOf(52.513483, 13.4539248), "Bar", "Berlin", mutableListOf()),
            Location("Cafe Cralle", "", listOf(52.550633, 13.3610829), "Bar", "Berlin", mutableListOf()),
            Location("kwia", "", listOf(52.4940408, 13.4236778), "Bar", "Berlin", mutableListOf()),
            Location("Kfetisch", "", listOf(52.483106, 13.4395609), "Bar", "Berlin", mutableListOf()),
            Location("Berghain", "", listOf(52.5112867, 13.4405008), "Club", "red", mutableListOf()),
            Location("About_blank", "", listOf(52.5025336, 13.4641796), "Club", "red", mutableListOf()),
            Location("SchwuZ", "", listOf(52.4794165, 13.4315742), "Club", "red", mutableListOf()),
            Location("Lab.Oratory", "", listOf(52.5116122, 13.4409219), "Club", "red", mutableListOf()),
            Location("SO36", "", listOf(52.5003921, 13.4199078), "Club", "red", mutableListOf()),
            Location("Watergate", "", listOf(52.5010558, 13.4430581), "Club", "red", mutableListOf()),
            Location("Sisyphos", "", listOf(52.4929592, 13.4890505), "Club", "red", mutableListOf()),
            Location("Golden Gate", "", listOf(52.5129892, 13.4055363), "Club", "red", mutableListOf()),
            Location("Club Triebwerk", "", listOf(52.4892443, 13.4164536), "Club", "red", mutableListOf()),
            Location("Revier Südost", "", listOf(52.45989, 13.503286), "Club", "red", mutableListOf()),
            Location("TRAUMA BAR UND KINO", "", listOf(52.5306511, 13.362311), "Club", "red", mutableListOf()),
            Location("Volkspark Hasenheide (cruising)", "", listOf(52.4842015, 13.4145337), "Cruising", "green", mutableListOf()),
            Location("Tiergarten (cruising)", "", listOf(52.5107805, 13.3365643), "Cruising", "green", mutableListOf()),
            Location("Volkspark Friedrichshain (cruising)", "", listOf(52.5280353, 13.4341994), "Cruising", "green", mutableListOf()),
            Location("Grunewald (cruising)", "", listOf(52.4858443, 13.2035949), "Cruising", "green", mutableListOf()),
            Location("Ernst-Thälmann park (cruising)", "", listOf(52.5386387, 13.4312424), "Cruising", "green", mutableListOf()),
            Location("Oyoun", "", listOf(13.4206611, 52.4838959), "Community-Center", "yellow", mutableListOf())
        )


    }
}