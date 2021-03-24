<template>
  <div>
<h4>Results</h4>
<select name="typeToggle" id="" @change="toggleType()" v-model=chosenType>
    <option value="movie">Movies</option>
    <option value="tv">TV Shows</option>
    <option value="person">People</option>

</select>
<div v-if="showMovies" class="movieListing">
  <div v-for="item in allMovies" v-bind:key="item.id" >
    <MovieCard v-bind:result="item"/>
  </div>

</div>
<div v-if="showTV" class="tvListing">
  <div v-for="item in allTVShows" v-bind:key="item.id" >
    <TVCard v-bind:result="item"/>
  </div>

</div>
<div v-if="showPeople" class="peopleListing">
  <div v-for="item in allPeople" v-bind:key="item.id" >
    <PeopleCard v-bind:result="item"/>
  </div>

</div>
  </div>
</template>

<script>
import MovieCard from '../components/MovieCard.vue'
import TVCard from '../components/TVCard.vue'
import PeopleCard from '../components/PeopleCard.vue'
export default {
  data(){

    return{
      showMovies: true,
      showPeople: false,
      showTV: false,
      chosenType: "movie",
    }
  },
  methods:{
      toggleType(){
        if(this.chosenType == "movie"){
          this.showMovies = true;
          this.showPeople = false;
          this.showTV = false;
        } else if (this.chosenType == "tv"){
          this.showTV = true;
          this.showMovies = false;
          this.showPeople = false;
        } else {
          this.showPeople = true;
          this.showTV = false;
          this.showMovies = false;
        }
      },

  },
  computed: {
    allResults(){
    return this.$store.getters.getResults;
    },
    allPeople(){
      let people = this.allResults.filter(item => {
        return item.media_type == "person"
      });
    return people;
    },
    allMovies(){
       let movies = this.allResults.filter(item => {
        return item.media_type == "movie"
      });
    return movies;
    },
    allTVShows(){
       let tv = this.allResults.filter(item => {
        return item.media_type == "tv"
      });
    return tv;
    }
  },
  components: {
    MovieCard,
    TVCard,
    PeopleCard
  },
  created(){
  
  }
  
}
</script>

<style scoped>

</style>