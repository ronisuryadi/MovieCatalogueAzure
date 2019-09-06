package com.ronisuryadi.moviecatalogue.utils;

import com.ronisuryadi.moviecatalogue.R;
import com.ronisuryadi.moviecatalogue.data.MovieEntity;
import com.ronisuryadi.moviecatalogue.data.TvEntity;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<MovieEntity> generateDummyMovie() {
        ArrayList<MovieEntity> movies = new ArrayList<>();

        movies.add(new MovieEntity(1,"Aquaman","Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm s half-human, half-Atlantean brother and true heir to the throne.", "Action, Adventure, Fantasy","2018",4,R.drawable.poster_aquaman));
        movies.add(new MovieEntity(2,"Avenger Infinity","As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.", "Adventure, Action, Science Fiction","2019",5,R.drawable.poster_avengerinfinity));
        movies.add(new MovieEntity(3,"BumbleBee","On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.", "Adventure, Action, Science Fiction","2018",4,R.drawable.poster_bumblebee));
        movies.add(new MovieEntity(4,"Creed II","Between personal obligations and training for his next big fight against an opponent with ties to his family s past, Adonis Creed is up against the challenge of his life.", "Drama","2018",3,R.drawable.poster_creed));
        movies.add(new MovieEntity(5,"Deadpoll","Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy s life.", "Action, Comedy, Adventure","2018",4,R.drawable.poster_deadpool));
        movies.add(new MovieEntity(6,"DragonBall","Goku and Vegeta encounter Broly, a Saiyan warrior unlike any fighter they ve faced before.", "Animation, Action, Adventure","2019",3,R.drawable.poster_dragonball));
        movies.add(new MovieEntity(7,"Glass","Security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities.", "Drama, Sci-Fi, Thriller","2019",4,R.drawable.poster_glass));
        movies.add(new MovieEntity(8,"Mortal Engine","Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.", "Adventure, Fantasy","2018",5,R.drawable.poster_mortalengine));
        movies.add(new MovieEntity(9,"Robin Hood","A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.", "Adventure, Action, Thriller","2018",4,R.drawable.poster_robinhood));
        movies.add(new MovieEntity(10,"Spiderman","Following the events of Avengers: Endgame (2019), Spider-Man must step up to take on new threats in a world that has changed forever.", "Action, Adventure, Sci-Fi","2019",4,R.drawable.poster_spiderman));
        movies.add(new MovieEntity(10,"Venom","Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.", "Science Fiction, Action","2018",5,R.drawable.poster_venom));

        return movies;
    }

    public static ArrayList<TvEntity> generateDummyTv() {
        ArrayList<TvEntity> tvs = new ArrayList<>();

        tvs.add(new TvEntity(1,"13 Reasons Why","Follows teenager Clay Jensen, in his quest to uncover the story behind his classmate and crush, Hannah, and her decision to end her life.","Drama | Mystery","2017","41 Episodes",3.8,R.drawable.reason_why));
        tvs.add(new TvEntity(2,"Mindhunter","Set in the late 1970s, two FBI agents are tasked with interviewing serial killers to solve open cases.","Crime | Drama | Thriller","2017","19 Episodes",4.3,R.drawable.mindhunter));
        tvs.add(new TvEntity(3,"Peaky Blinders","A gangster family epic set in 1919 Birmingham, England; centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby.","Crime | Drama","2014","37 Episodes",4.4,R.drawable.peaky_blinders));
        tvs.add(new TvEntity(4,"The Mandalorian ","The travails of a lone gunfighter in the outer reaches of the galaxy, far from the authority of the New Republic.","Action | Adventure | Fantasy | Sci-Fi","2019","10 Episodes",4.0,R.drawable.the_mandalorian));
        tvs.add(new TvEntity(5,"The Boys","A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers.","Action | Comedy | Crime | Sci-Fi","2019","9 Episodes",4.5,R.drawable.the_boys));
        tvs.add(new TvEntity(6,"Yellowstone","A ranching family in Montana faces off against others encroaching on their land.","Drama | Western","2018","29 Episodes",4.2,R.drawable.yellow_stone));

        tvs.add(new TvEntity(7,"Euphoria ","A look at life for a group of high school students as they grapple with issues of drugs, sex, and violence.","Drama","2019","9 Episodes",4.2,R.drawable.euphoria));
        tvs.add(new TvEntity(8,"Power ","James \"Ghost\" St. Patrick, a wealthy New York night club owner who has it all, catering to the city's elite and dreaming big, lives a double life as a drug kingpin.","Crime | Drama","2014","63 Episodes",4.1,R.drawable.power));
        tvs.add(new TvEntity(9,"Orange Is the New Black","Convicted of a decade old crime of transporting drug money to an ex-girlfriend, normally law-abiding Piper Chapman is sentenced to a year and a half behind bars to face the reality of how life-changing prison can really be.","Comedy | Crime | Drama","2013","91 Episodes",4.0,R.drawable.orange));

        tvs.add(new TvEntity(10,"Suits","On the run from a drug deal gone bad, Mike Ross, a brilliant college dropout, finds himself a job working with Harvey Specter, one of New York City's best lawyers.","Comedy | Drama","2011","134 Episodes",4.5,R.drawable.suits));

        return tvs;
    }

}
