<template>
  <div>
<h4>Results</h4>
<h6 @click="goHome()" class="BackBtn">(Go Back)</h6>
<select name="typeToggle" id="" @change="toggleType()" v-model=chosenType>
    <option value="all">All</option>
    <option value="movie">Movies</option>
    <option value="tv">TV Shows</option>
    <option value="person">People</option>
</select>

<div class="pagesContainer">
  <h5>PAGE: </h5>
  <div v-for="page in allPages" v-bind:key="page" v-on:click="goToPage(page)" class="pageNum">
    {{page}}
  </div>
</div>

<h3>Movies</h3> <br/>
<div v-if="(showMovies || showAll) && allMovies.length > 0" class="movieListing">
  <div v-for="item in allMovies" v-bind:key="item.id" class="listing">
    <MovieCard v-bind:result="item"/>
  </div>

</div>
  <h3>TV Shows</h3> <br/>
<div v-if="(showTV || showAll) && allTVShows.length > 0" class="tvListing">
  <div v-for="item in allTVShows" v-bind:key="item.id" class="listing">
    <TVCard v-bind:result="item"/>
  </div>

</div>
  <h3>People</h3>  <br/>
<div v-if="(showPeople || showAll) && allPeople.length > 0" class="peopleListing">
  <div v-for="item in allPeople" v-bind:key="item.id" class="listing">
    <PeopleCard v-bind:result="item"/>
  </div>

</div>
  </div>
</template>

<script>
import MovieCard from '../components/MovieCard.vue'
import TVCard from '../components/TVCard.vue'
import PeopleCard from '../components/PeopleCard.vue'
import SearchService from '../services/SearchService'
export default {
  data(){

    return{
      showAll: true,
      showMovies: false,
      showPeople: false,
      showTV: false,
      chosenType: "all",
      chosenItem: [],

    }
  },
  methods:{
      toggleType(){
         this.showMovies = false;
          this.showPeople = false;
          this.showTV = false;
          this.showAll = false;


        if(this.chosenType == "movie"){
          this.showMovies = true;
          let results;
          SearchService.movieSearch(this.$route.params.text, this.$route.params.page).then(response => {
            results = response.data;
          })
          this.$store.dispatch('updateResults', results);
          console.log(results);


        } else if (this.chosenType == "tv"){
          this.showTV = true;
        } else if (this.chosenType == "person"){
          this.showPeople = true;
        } else {
          this.showAll = true;
        }
      },
    goHome(){
      this.$router.push("/");
    },
    goToPage(num){
      console.log("PAGE CALL")
      let results = [];
      let query = {
        text: this.$store.state.query.text,
        page: num
      }
      this.$store.dispatch('updateQuery', query)
      SearchService.multiSearch(query.text, query.page).then(response => {
          results = response.data;
        })
         this.$store.dispatch('updateResults', results)
    }

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
    },

    allPages(){
      let num = this.$store.getters.getPageTotal;
      let pages = [];
      for (let i = 1; i <= num; i++){
        pages.push(i);
      }
      return pages;
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

.movieListing, .tvListing, .peopleListing{
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.BackBtn:hover{
  cursor: pointer;
}

h3{
  width: 100%;
  background-color: navy;
  color: white;
  font-weight:bold;

}

.pagesContainer{
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  width: 20%;
}

.pageNum:hover{
  cursor: pointer;
  color:gray;
}
</style>