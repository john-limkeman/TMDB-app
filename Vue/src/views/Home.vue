<template>
  <div>

    <h2>Search Movies, TV, and people!</h2>
   <form >
         <input type="text" name="search" id="searchInput" placeholder="Search..." v-model="query.text">
      <button @click.prevent="conductSearch(query)">SEARCH</button>
      <button @click.prevent="movieSearch(query)">SEARCH MOVIES</button>
    </form>
  </div>
</template>

<script>
import SearchService from '../services/SearchService.js'
export default {
data(){
    return{
      query: {
        text: "",
        page: 1
      },
      results : [],
    }
},
methods: {

    conductSearch(query){
        this.$store.dispatch('updateQuery', query);
        console.log(this.$store.state.query)
        SearchService.multiSearch(query.text, query.page).then(response => {
          this.results = response.data;
        })
         this.$store.dispatch('updateResults', this.results)
      console.log(this.results)
    if(this.$store.getters.getResults != null){
        this.$router.push({ name: 'ResultListing', params: {text: query.text, page: query.page }});
      } else{
        console.log("try again")
        // this.conductSearch(query); recursion doesn't solve it
      }
    },
    movieSearch(query){
      SearchService.movieSearch(query.text, query.page).then(response => {
        this.results = response.data;
      })
      this.$store.dispatch('updateResults', this.results)
      console.log("movie results:")
      console.log(this.results)
      if(this.$store.getters.getResults != null){
        this.$router.push({ name: 'ResultListing', params: {text: query.text, page: query.page }});
      } else{
        console.log("try again")
      }
    },
}
}
</script>

<style>

</style>