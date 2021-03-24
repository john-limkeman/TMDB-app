<template>
  <div>
<h4>Results</h4>
<h6 @click="goHome()" class="BackBtn">(Go Back)</h6>

<div class="PreviewContainer">
<div v-if="allMovies.length > 0" class="preview" @click="toggleType('movie')">
<h3>Movies</h3>
<img v-bind:src="generateImageURL(allMovies[0].poster_path)" alt="image unavailable">
  </div>


<div v-if="allTVShows.length > 0" class="preview" @click="toggleType('tv')">
<h3>TV Shows</h3>
<img v-bind:src="generateImageURL(allTVShows[0].poster_path)" alt="image unavailable">
  </div>

<div v-if="allPeople.length > 0" class="preview" @click="toggleType('person')">
<h3>People</h3>
<img v-bind:src="generateImageURL(allPeople[0].profile_path)" alt="image unavailable">
  </div>
</div>

  </div>
</template>

<script>

export default {
  data(){

    return{
      showAll: true,
      showMovies: false,
      showPeople: false,
      showTV: false,
      chosenType: "all",
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
        } else if (this.chosenType == "tv"){
          this.showTV = true;
        } else if (this.chosenType == "person"){
          this.showPeople = true;
        } else {
          this.showAll = true;
        }
        
      },
       generateImageURL(url){
      let result = "http://image.tmdb.org/t/p/" + "w185" + url;
      return result;
    },
    goHome(){
      this.$router.push("/");
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
    }
  },
  components: {
  },
  created(){
  
  }
  
}
</script>

<style scoped>

.movieListing, .tvListing, .peopleListing{
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
}
.BackBtn:hover{
  cursor: pointer;
}
img{
    height: 350px;
    width: 230px;
}

</style>