<template>
  <div>

    <h2>Search Movies, TV, and people!</h2>
   <form @submit.prevent="conductSearch(query)">
         <input type="text" name="search" id="searchInput" placeholder="Search..." v-model="query.text">
      <button >SEARCH</button>
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
      test: []
    }
},
methods: {
    conductSearch(query){
      console.log(query)

        SearchService.multiSearch(query)
        
        
        .then(response => {
          this.results = response.data;
        })
         this.$store.dispatch('updateResults', this.results)
      console.log(this.results)
    if(this.$store.getters.getResults != null){
        this.$router.push({ name: 'ResultsPreview', params: {text: query.text, page: query.page }});
      } else{
        console.log("try again")
      }
    },
}
}
</script>

<style>

</style>