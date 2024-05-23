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
            Location("Südblock", 52.4987328, 13.4129215, "Bar"),
            Location("Roses", 52.5005109, 13.4171672, "Bar"),
            Location("Möbel Olfe", 52.499985, 13.415262, "Bar"),
            Location("Bar Zum schmutzigen Hobby", 52.507921, 13.451325, "Bar"),
            Location("Monster Ronsons's Ichiban Karaoke", 52.5052743, 13.4462772, "Bar"),
            Location("FICKEN 3000", 52.4886085, 13.4181037, "Bar"),
            Location("Café-Bar Himmelreich", 52.4885878, 13.3523611, "Bar"),
            Location("Paloma Bar", 52.4993278, 13.4167934, "Bar"),
            Location("Betty F***", 52.5276026, 13.4030642, "Bar"),
            Location("Capture Bar", 52.5098104, 13.45481, "Bar"),
            Location("Greifbar", 52.5496812, 13.4151626, "Bar"),
            Location("New Action (only men)", 52.5001681, 13.347258, "Bar"),
            Location("WOOF Bar (only men)", 52.4992382, 13.3415847, "Bar"),
            Location("TOM'S Bar (only men)", 52.4980435, 13.3493819, "Bar"),
            Location("BarbieBar", 52.4894692, 13.3845674, "Bar"),
            Location("To Be Free", 52.5332259, 13.1970187, "Bar"),
            Location("Besenkammer", 52.5206225, 13.4101261, "Bar"),
            Location("OYA", 52.5009211, 13.4210326, "Bar"),
            Location("Große Freiheit", 52.513483, 13.4539248, "Bar"),
            Location("Cafe Cralle", 52.550633, 13.3610829, "Bar"),
            Location("kwia", 52.4940408, 13.4236778, "Bar"),
            Location("Kfetisch", 52.483206, 13.4395609, "Bar"),
            Location("Berghain", 52.5112867, 13.4405008, "Club"),
            Location("About_blank", 52.5025336, 13.4641796, "Club"),
            Location("SchwuZ", 52.4794165, 13.4325742, "Club"),
            Location("Lab.Oratory", 52.5116122, 13.4409219, "Club"),
            Location("SO36", 52.5003921, 13.4199078, "Club"),
            Location("Watergate", 52.5010558, 13.4430581, "Club"),
            Location("Sisyphos", 52.4929592, 13.4890505, "Club"),
            Location("Golden Gate", 52.5129892, 13.4055363, "Club"),
            Location("Club Triebwerk", 52.4892443, 13.4164536, "Club"),
            Location("Revier Südost", 52.45989, 13.503286, "Club"),
            Location("TRAUMA BAR UND KINO", 52.5306511, 13.362321, "Club"),
            Location("Volkspark Hasenheide (cruising)", 52.4842015, 13.4145337, "Cruising"),
            Location("Tiergarten (cruising)", 52.5107805, 13.3365643, "Cruising"),
            Location("Volkspark Friedrichshain (cruising)", 52.5280353, 13.4341994, "Cruising"),
            Location("Grunewald (cruising)", 52.4858443, 13.2035949, "Cruising"),
            Location("Ernst-Thälmann park (cruising)", 52.5386387, 13.4322424, "Cruising"),
            Location("Oyoun", 13.4206611, 52.4838959, "Community-Center")
        )
    }

    private fun loadComments(): MutableList<Comment> {
        return mutableListOf(
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "Great atmosphere and friendly staff!",
                "30",
                "queer",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "Loved the cocktails here, definitely coming back.",
                "28",
                "gay",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "Loved the cocktails here, definitely coming back.",
                "28",
                "queer",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "Fun place for a night out with friends.",
                "25",
                "queer",
                "trans woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "Fun place for a night out with friends.",
                "25",
                "inclusive",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "Music was amazing, but it gets crowded.",
                "32",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "Music was amazing, but it gets crowded.",
                "32",
                "queer",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "A bit pricey, but worth it for the vibe.",
                "27",
                "queer",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Tipsy Bear",
                "A bit pricey, but worth it for the vibe.",
                "27",
                "inclusive",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "One of the best queer bars in the city.",
                "35",
                "queer",
                "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "One of the best queer bars in the city.",
                "35",
                "inclusive",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "Love the eclectic decor and friendly crowd.",
                "29",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "Love the eclectic decor and friendly crowd.",
                "29",
                "queer",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "Perfect spot for a relaxed evening.",
                "30",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "Perfect spot for a relaxed evening.",
                "30",
                "inclusive",
                "trans woman",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "Amazing drinks and great music.",
                "26",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "Amazing drinks and great music.",
                "26",
                "inclusive",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "Always a welcoming and vibrant environment.",
                "32",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "SilverFuture",
                "Always a welcoming and vibrant environment.",
                "32",
                "inclusive",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "A must-visit for queer nightlife.",
                "33",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "A must-visit for queer nightlife.",
                "33",
                "queer",
                "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "Great venue with fantastic events.",
                "28",
                "queer",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "Great venue with fantastic events.",
                "28",
                "inclusive",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "The outdoor area is perfect for summer nights.",
                "34",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "The outdoor area is perfect for summer nights.",
                "34",
                "queer",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "Friendly crowd and good vibes.",
                "27",
                "queer",
                "trans woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "Friendly crowd and good vibes.",
                "27",
                "inclusive",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "Nice place to meet new people.",
                "29",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Südblock",
                "Nice place to meet new people.",
                "29",
                "inclusive",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "Unique decor and lively atmosphere.",
                "36",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "Unique decor and lively atmosphere.",
                "36",
                "inclusive",
                "trans woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "Always a fun night at Roses.",
                "32",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "Always a fun night at Roses.",
                "32",
                "queer",
                "gender fluid",
                true
            )
            ,
            Comment(
                "23.05.2024",
                "Roses",
                "Great place for dancing and drinks.",
                "29",
                "queer",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "Great place for dancing and drinks.",
                "29",
                "inclusive",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "The decor is so kitschy and fun.",
                "33",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "The decor is so kitschy and fun.",
                "33",
                "queer",
                "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "One of my favorite bars in the city.",
                "28",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Roses",
                "One of my favorite bars in the city.",
                "28",
                "inclusive",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Trendy spot with a great crowd.",
                "30",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Trendy spot with a great crowd.",
                "30",
                "queer",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Awesome place to start the night.",
                "32",
                "queer",
                "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Awesome place to start the night.",
                "32",
                "inclusive",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Drinks are a bit pricey but worth it.",
                "29",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Drinks are a bit pricey but worth it.",
                "29",
                "queer",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Love the unique interior design.",
                "27",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Love the unique interior design.",
                "27",
                "inclusive",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Always a fun crowd here.",
                "32",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Möbel Olfe",
                "Always a fun crowd here.",
                "32",
                "queer",
                "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Great music and a fantastic vibe.",
                "35",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Great music and a fantastic vibe.",
                "35",
                "inclusive",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Perfect spot for a late-night adventure.",
                "30",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Perfect spot for a late-night adventure.",
                "30",
                "queer",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Love the quirky decor and friendly staff.",
                "32",
                "queer",
                "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Love the quirky decor and friendly staff.",
                "32",
                "inclusive",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Always a good time here.",
                "28",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Always a good time here.",
                "28",
                "queer",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Great place to meet interesting people.",
                "33",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Bar Zum schmutzigen Hobby",
                "Great place to meet interesting people.",
                "33",
                "inclusive",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "The best karaoke bar in town!",
                "30",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "The best karaoke bar in town!",
                "30",
                "queer",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "So much fun singing with friends here.",
                "29",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "So much fun singing with friends here.",
                "29",
                "inclusive",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "Great vibe and awesome song selection.",
                "32",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "Great vibe and awesome song selection.",
                "32",
                "queer",
                "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "Love the private karaoke rooms.",
                "28",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "Love the private karaoke rooms.",
                "28",
                "inclusive",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "Always a blast at Monster Ronson's!",
                "32",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Monster Ronson's Ichiban Karaoke",
                "Always a blast at Monster Ronson's!",
                "32",
                "queer",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "FICKEN 3000",
                "Crazy fun and wild nights here.",
                "33",
                "queer",
                "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "FICKEN 3000",
                "Crazy fun and wild nights here.",
                "33",
                "inclusive",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "FICKEN 3000",
                "An experience you won't forget!",
                "30",
                "gay",
                "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "FICKEN 3000",
                "An experience you won't forget!",
                "30",
                "queer",
                "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "FICKEN 3000",
                "Always a wild party at FICKEN 3000.",
                "29",
                "queer",
                "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "FICKEN 3000",
                "Always a wild party at FICKEN 3000.",
                "29",
                "inclusive",
                "non-binary",
                true
            ),
            Comment(
                "23.05.2024",
                "FICKEN 3000",
                "Great music and an amazing crowd.",
                "32",
                "gay",
                "cis woman",
                true
            ), Comment(
                "23.05.2024",
                "WOOF Bar (only men)",
                "Always a fun time at WOOF Bar.",
                "32",
                "queer","cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "WOOF Bar (only men)",
                "Great drinks and friendly staff.",
                "34",
           "inclusive", "cis men",
                true
            ),
            Comment(
                "23.05.2024",
                "TOM'S Bar (only men)",
                "Legendary bar with a great atmosphere.",
                "29",
                "queer","cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "TOM'S Bar (only men)",
                "Always a good time at TOM'S Bar.",
                "33",
            "gay", "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "TOM'S Bar (only men)",
                "Great place for meeting new people.",
                "30",
                "queer","cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "TOM'S Bar (only men)",
                "Love the music and atmosphere.",
                "28",
            "gay", "cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "TOM'S Bar (only men)",
                "Always a fun crowd here.",
                "32",
                "queer","cis man",
                true
            ),
            Comment(
                "23.05.2024",
                "BarbieBar",
                "Fun and colorful decor.",
                "34",
               "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "BarbieBar",
                "Great place for a themed night out.",
                "29",
            "non binary", "queer",
                true
            ),
            Comment(
                "23.05.2024",
                "BarbieBar",
                "Love the unique atmosphere.",
                "32",
              "gay", "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "BarbieBar",
                "Always a blast at BarbieBar.",
                "28",
            "gay", "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "To Be Free",
                "Relaxing spot with great drinks.",
                "33",
                  "queer", "trans woman",
                true
            ),
            Comment(
                "23.05.2024",
                "To Be Free",
                "Love the chill vibe here.",
                "30",
               "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "To Be Free",
                "Perfect for a quiet evening out.",
                "29",
            "non binary", "queer",
                true
            ),
            Comment(
                "23.05.2024",
                "To Be Free",
                "Friendly staff and great service.",
                "32",
              "gay", "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Besenkammer",
                "Unique spot with a great vibe.",
                "34",
            "gay", "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Besenkammer",
                "Love the cozy atmosphere.",
                "32",
                  "queer", "trans woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Besenkammer",
                "Great place for a quiet drink.",
                "29",
               "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Besenkammer",
                "Perfect for a low-key night out.",
                "32",
            "non binary", "queer",
                true
            ),
            Comment(
                "23.05.2024",
                "Besenkammer",
                "Always a friendly crowd.",
                "30",
              "gay", "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "OYA",
                "Love the eclectic decor.",
                "29",
            "gay", "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "OYA",
                "Always a fun night out at OYA.",
                "30",
                  "queer", "trans woman",
                true
            ),
            Comment(
                "23.05.2024",
                "OYA",
                "Great place to meet new people.",
                "32",
               "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "OYA",
                "Perfect for a night out with friends.",
                "28",
            "non binary", "queer",
                true
            ),
            Comment(
                "23.05.2024",
                "Große Freiheit",
                "Fantastic club with a great atmosphere.",
                "34",
            "gay", "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Große Freiheit",
                "Always a good time here.",
                "32",
                  "queer", "trans woman",
                true
            ),
            Comment(
                "23.05.2024",


                "Große Freiheit",
                "Great music and lively crowd.",
                "29",
               "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Große Freiheit",
                "Love the inclusive atmosphere.",
                "32",
            "non binary", "queer",
                true
            ),
            Comment(
                "23.05.2024",
                "Große Freiheit",
                "Always a great night out here.",
                "30",
              "gay", "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Rauschgold",
                "Amazing drag shows and performances.",
                "28",
                "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Rauschgold",
                "Love the energy here.",
                "33",
             "queer", "non binary",
                true
            ),
            Comment(
                "23.05.2024",
                "Rauschgold",
                "Fantastic place for a night out.",
                "32",
           "trans man", "inclusive",
                true
            ),
            Comment(
                "23.05.2024",
                "Rauschgold",
                "Great performances and friendly crowd.",
                "34",
                "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Rauschgold",
                "Always a fun time at Rauschgold.",
                "30",
                "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Heile Welt",
                "Cozy place with a welcoming vibe.",
                "32",
               "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Heile Welt",
                "Great drinks and friendly staff.",
                "32",
                  "queer", "trans woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Heile Welt",
                "Always a relaxing spot to hang out.",
                "29",
            "gay", "cis woman",
                true
            ),
            Comment(
                "23.05.2024",
                "Heile Welt",
                "Love the ambiance here.",
                "28",
             "queer", "gender fluid",
                true
            ),
            Comment(
                "23.05.2024",
                "Heile Welt",
                "Great place for a chill night out.",
                "30",
              "gay", "trans man",
                true
            ),
            Comment(
                "23.05.2024",
                "Kfetisch",
                "Great place for a chill night out.",
                "30",
              "gay", "trans man",
                true
            )
        )
    }
}
