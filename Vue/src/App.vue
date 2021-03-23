<template>
  <div id="app">
    <form @submit.prevent="conductSearch(query)">
      <label for="Type">Type: </label>
      <select name="Type" v-model="query.type">
        <option value="all">ALL</option>
        <option value="actor">Actors</option>
        <option value="movie">Movies</option>
        <option value="tv">TV Shows</option>
      </select>
      <input type="text" name="search" id="searchInput" placeholder="Search..." v-model="query.text">
      <button >SEARCH</button>
    </form>
  </div>
</template>

<script>
import SearchService from './services/SearchService.js'
export default {
  name: 'App',
  data(){
    return{
      query: {
        text: "",
        type: "all"
      },
      results : [],
    }
  },
  methods: {
    conductSearch(query){
      if(this.query.type === "all"){

        SearchService.multiSearch(query).then(response => {
          this.results = response.data;
        })
      } else if(this.query.type === "movie"){
        SearchService.movieSearch(query).then(response => {
          this.results = response.data;
        })
      } else if (this.query.type === "tv"){
        SearchService.tvSearch(query).then(response =>{
          this.results = response.data;
        })
      } else {
        SearchService.actorSearch(query).then(response => {
          this.results = response.data;
        })
      }
      console.log(this.results)
    }
  },
  components: {
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
