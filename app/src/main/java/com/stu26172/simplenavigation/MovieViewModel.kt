package com.stu26172.simplenavigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu26172.simplenavigation.models.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class MovieViewModel : ViewModel() {

    /*It is not necessary to define the max Seats because it
      is already generated when instantiating the class*/
    val movies = listOf(
        Movie(
            id = 0,
            title = "GHOSTBUSTERS: FROZEN EMPIRE",
            posterResId = R.drawable.poster_ghostbusters,
            description = "In Ghostbusters: Frozen Empire, the Spengler family returns to where it all started – the iconic New York City firehouse – to team up with the original Ghostbusters, who’ve developed a top-secret research lab to take busting ghosts to the next level. But when the discovery of an ancient artifact unleashes an evil force, Ghostbusters new and old must join forces to protect their home and save the world from a second Ice Age.",
            runningTime = "1hr 56mins",
            starring = "Paul Rudd, Bill Murray, Finn Wolfhard, Dan Aykroud, Annie Potts, Mckenna Grace, Ernie Hudson"
        ), Movie(
            id = 1,
            title = "IMMACULATE",
            posterResId = R.drawable.poster_immaculate,
            description = "Cecilia, a woman of devout faith, is warmly welcomed to the picture-perfect Italian countryside where she is offered a new role at an illustrious convent. But it becomes clear to Cecilia that her new home harbors dark and horrifying secrets.",
            runningTime = "1hr 29mins",
            starring = "Sydney Sweeney, Benedetta Porcaroli, Álvaro Morte, Simona Tabasco"
        ), Movie(
            id = 2,
            title = "DUNE: PART TWO",
            posterResId = R.drawable.poster_dune_part_ii,
            description = "Paul Atreides unites with Chani and the Fremen while on a warpath of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the known universe, he endeavors to prevent a terrible future only he can foresee.",
            runningTime = "2hr 46mins",
            starring = "Timothée Chalamet, Florence Pugh, Zendaya , Souheila Yacoub, Austin Butler"
        ), Movie(
            id = 3,
            title = "GODZILLA X KONG: THE NEW EMPIRE",
            posterResId = R.drawable.godzilla_x_gong_the_new_empire,
            description = "The epic battle continues! Legendary Pictures’ cinematic Monsterverse follows up the explosive showdown of “Godzilla vs. Kong” with an all-new adventure that pits the almighty Kong and the fearsome Godzilla against a colossal undiscovered threat hidden within our world, challenging their very existence—and our own. “Godzilla x Kong: The New Empire” delves further into the histories of these Titans and their origins, as well as the mysteries of Skull Island and beyond, while uncovering the mythic battle that helped forge these extraordinary beings and tied them to humankind forever.",
            runningTime = "1hr 55mins",
            starring = "Rebecca Hall, Dan Stevens, Brian Tyree Henry, Fala Chen, Kaylee Hottle, Alex Ferns"
        ),
        Movie(
            id = 4,
            title = "AADUJEEVITHAM - THE GOAT LIFE",
            posterResId = R.drawable.poster_aadujeevitham_malayalam,
            description = "The real-life incident of an Indian migrant worker, Najeeb Muhammad, who goes to Saudi Arabia to earn money. However, in a twist of fate, he finds himself living a slave-like existence, herding goats in the middle of the desert.",
            runningTime = "2hr 41mins",
            starring = "Prithviraj Sukumaran, Amala Paul, Jimmy Jean-Louis, Rik Aby, Ajesh Babu\n"
        ),
        Movie(
            id = 5,
            title = "THE FIRST OMEN",
            posterResId = R.drawable.poster_the_first_omen,
            description = "When a young American woman is sent to Rome to begin a life of service to the church, she encounters a darkness that causes her to question her own faith and uncovers a terrifying conspiracy that hopes to bring about the birth of evil incarnate.",
            runningTime = "1hr 59mins",
            starring = "Bill Nighy, Ralph Ineson, Sônia Braga, Nell Tiger Free, Tawfeek Barhom"
        ),
        Movie(
            id = 6,
            title = "MONKEY MAN",
            posterResId = R.drawable.poster_monkey_man,
            description = "scar® nominee Dev Patel (Lion, Slumdog Millionaire) achieves an astonishing, tour-de-force feature directing debut with an action thriller about one man’s quest for vengeance against the corrupt leaders who murdered his mother and continue to systemically victimize the poor and powerless. Inspired by the legend of Hanuman, an icon embodying strength and courage, Monkey Man stars Patel as Kid, an anonymous young man who ekes out a meager living in an underground fight club where, night after night, wearing a gorilla mask, he is beaten bloody by more popular fighters for cash. After years of suppressed rage, Kid discovers a way to infiltrate the enclave of the city’s sinister elite. As his childhood trauma boils over, his mysteriously scarred hands unleash an explosive campaign of retribution to settle the score with the men who took everything from him.",
            runningTime = "2hr 1min",
            starring = "Sharlto Copley, Dev Patel, Sobhita Dhulipala, Ashwini Kalsekar, Adithi Kalkunte, Sikandar Kher, Pitobash , Vipin Sharma, Makarand Deshpande"
        ),
        Movie(
            id = 7,
            title = "WONKA",
            posterResId = R.drawable.poster_wonka,
            description = "Armed with nothing but a hatful of dreams, young chocolatier Willy Wonka manages to change the world, one delectable bite at a time.",
            runningTime = "1hr 56mins",
            starring = "Timothée Chalamet, Olivia Colman, Rowan Atkinson, Keegan-Michael Key, Matt Lucas"
        ),
        Movie(
            id = 8,
            title = "MIGRATION",
            posterResId = R.drawable.poster_migration,
            description = "A family of ducks decides to leave the safety of a New England pond for an adventurous trip to Jamaica. However, their well-laid plans quickly go awry when they get lost and wind up in New York City. The experience soon inspires them to expand their horizons, open themselves up to new friends, and accomplish more than they ever thought possible.",
            runningTime = "1hr 30mins",
            starring = "Elizabeth Banks, Danny DeVito, Keegan-Michael Key, Kumail Nanjiani, Awkwafina"
        ),
        Movie(
            id = 9,
            title = "ABIGAIL",
            description = "After a group of would-be criminals kidnap the 12-year-old ballerina daughter of a powerful underworld figure, all they have to do to collect a \$50 million ransom is watch the girl overnight. In an isolated mansion, the captors start to dwindle, one by one, and they discover, to their mounting horror, that they’re locked inside with no normal little girl.",
            runningTime = "N/A",
            starring = "Dan Stevens, Giancarlo Esposito, Kathryn Newton, Kevin Durand, Alisha Weir",
            posterResId = R.drawable.pt_abigail
        ),
        Movie(
            id = 10,
            title = "SEIZE THEM!",
            description = "Dark age Britain where Queen Dagan is toppled by a revolution led by Humble Joan. The Queen becomes a fugitive in her own land and must face hardship and danger as she embarks on a voyage to win back her throne.",
            runningTime = "1hr 31mins",
            starring = "Nick Frost, Paul Kaye, Nitin Ganatra, Aimee Lou Wood, Murray McArthur, Nicola Coughlan, Lolly Adefope",
            posterResId = R.drawable.pt_seize_them
        ),
        Movie(
            id = 11,
            title = "MOTHERS’ INSTINCT",
            description = "Starring Academy Award winners Jessica Chastain and Anne Hathaway, Mothers’ Instinct is an unnerving psychological thriller about two best friends and neighbors, Alice and Céline, whose perfect lives in ‘60s suburbia are shattered by a tragic accident involving one of their children. Marking the directorial debut of acclaimed cinematographer Benoit Delhomme, we follow Alice and Céline as their familial bonds are gradually undermined by guilt and paranoia and a gripping battle of wills develops, revealing the darker side of maternal love.",
            runningTime = "1hr 34mins",
            starring = "Jessica Chastain, Anne Hathaway",
            posterResId = R.drawable.pt_mothers_instinct
        ),
        Movie(
            id = 12,
            title = "IO CAPITANO",
            description = "ave Dakar to travel to Europe where they believe opportunities await. On a journey neither could have imagined, the boys face the dangers and the beauty of the desert, the shock of detention centres in Libya, and the perils of the sea in their pursuit of a better life, in an epic story that offers a deeply human perspective on the migrant crisis.\n" +
                    "\n" +
                    "\n" +
                    "Directed by two-time BAFTA-nominee Matteo Garrone (Gomorrah, Tale of Tales), IO CAPITANO has been nominated for Best International Feature at the Academy Awards, and won the Silver Lion and Best Young Actor Awards at Venice Film Festival.\n" +
                    "\n",
            runningTime = "2hr 1min",
            starring = "Bamar Kane, Seydou Sarr, Didier Njikam, Moustapha Fall",
            posterResId = R.drawable.pt_io_capitano
        ),
        Movie(
            id = 13,
            title = "SUGA | AGUST D TOUR ‘D-DAY’ THE MOVIE",
            description = "The eagerly awaited film of BTS SUGA’s Encore Concert <SUGA│Agust D TOUR ‘D-DAY’ THE MOVIE> bursts onto the big screen worldwide, with a behind the scenes look of what made his concert a worldwide phenomenon, featuring never before seen footage!\n" +
                    "\n" +
                    "As the grand finale of the world tour, “SUGA | Agust D TOUR ‘D-DAY’ THE FINAL” marked the culmination of 25 concerts held in 10 cities, which captivated a total audience of 290,000 throughout its run. \n" +
                    "\n" +
                    "Experience the pulsating energy and excitement of “D-DAY’ THE FINAL” on screen, everything from the exquisite sounds traversing the boundary between “21st Century Pop Icon” BTS member SUGA and solo artist Agust D, electrifying performance, explosive energy, to special duet stages featuring fellow BTS members RM, Jimin, and Jung Kook.",
            runningTime = "1hr 24mins",
            starring = "SUGA",
            posterResId = R.drawable.pt_suga
        ),
        Movie(
            id = 14,
            title = "WICKED LITTLE LETTERS",
            description = "A 1920s English seaside town bears witness to a dark and absurd scandal in this riotous mystery comedy. Based on a stranger than fiction true story, WICKED LITTLE LETTERS follows two neighbours: deeply conservative local Edith Swan (Olivia Colman) and rowdy Irish migrant Rose Gooding (Jessie Buckley). When Edith and fellow residents begin to receive wicked letters full of unintentionally hilarious profanities, foulmouthed Rose is charged with the crime. The anonymous letters prompt a national uproar, and a trial ensues. However, as the town's women - led by Police Officer Gladys Moss (Anjana Vasan) - begin to investigate the crime themselves, they suspect that something is amiss, and Rose may not be the culprit after all.",
            runningTime = "1hr 40mins",
            starring = "Olivia Colman, Timothy Spall, Eileen Atkins, Gemma Jones, Anjana Vasan, Jessie Buckley",
            posterResId = R.drawable.pt_wicked_little_letters
        ),
        Movie(
            id = 15,
            title = "LATE NIGHT WITH THE DEVIL",
            description = "October 31, 1977. Johnny Carson rival Jack Delroy hosts a syndicated late night talk show ‘Night Owls’ that has long been a trusted companion to insomniacs around the country. A year after the tragic death of Jack’s wife, ratings have plummeted. Desperate to turn his fortunes around, Jack plans a Halloween special like no other, unaware that he is about to unleash evil into the living rooms of America.",
            runningTime = "1hr 33mins",
            starring = "David Dastmalchian, Fayssal Bazzi, Laura Gordon, Ian Bliss",
            posterResId = R.drawable.late_night_with_the_devil
        ),
        Movie(
            id = 16,
            title = "LUGA (2021)",
            description = "Set in a beautiful seaside town on the Italian Riviera, the original animated feature is a coming-of-age story about one young boy experiencing an unforgettable summer filled with gelato, pasta and endless scooter rides. Luca shares these adventures with his newfound best friend, but all the fun is threatened by a deeply-held secret: he is a sea monster from another world just below the water’s surface.",
            runningTime = "1hr 31mins",
            starring = "Maya Rudolph, Jacob Tremblay, Jack Dylan Grazer, Emma Berman, Marco Barricelli",
            posterResId = R.drawable.pt_luca
        )
    ).sortedBy { it.title }

    fun getMovieById(movieId: Int): Movie {
        return movies.find { it.id == movieId }!!
    }

    private val _searchText = MutableStateFlow("")
    private val searchText = _searchText.asStateFlow()
    private val _searchedMovies = MutableStateFlow(movies)
    val searchedMovies = searchText
        .combine(_searchedMovies){ text, movies ->
            when {
                text.isNotEmpty() -> movies.filter { movie ->
                    movie.title.contains(text.trim(), ignoreCase = true)
                }

                else -> emptyList()
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onSearchTextChange(text: String){
        _searchText.value = text
    }
}