<template>
  <div id="app">
    <div @click="goHome()" class="homeBtn">
    <h1>TMDb</h1>
    </div>

    <button @click="doTest()">TEST</button>
  <router-view>

  </router-view>
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
        page: 1
      },
      results : [],
    }
  },
  methods: {
    // conductSearch(query){
    //   console.log(query)
    //   // if(this.query.type === "all"){

    //     SearchService.multiSearch(query).then(response => {
    //       this.results = response.data;
    //     })
      // } else if(this.query.type === "movie"){
      //   SearchService.movieSearch(query).then(response => {
      //     this.results = response.data;
      //   })
      // } else if (this.query.type === "tv"){
      //   SearchService.tvSearch(query).then(response =>{
      //     this.results = response.data;
      //   })
      // } else {
      //   SearchService.actorSearch(query).then(response => {
      //     this.results = response.data;
      //   })
      // }
      // this.$store.dispatch('updateResults', this.results)
      // console.log(this.results)
      // if(this.$store.getters.getResults != null){
      //   this.$router.push('/results');
      // } else{
      //   console.log("try again")
      // }
    // },
    doTest(){
      SearchService.actorTest().then(response => {
        this.test = response.data;
      })
      console.log("TESTING: ")
      console.log(this.test);
    },
    goHome(){
      this.$router.push("/");
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
.resultCard{
  margin: 10px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  }

  .resultCard img{
    height: 350px;
    width: 230px;
  }

  .resultCard h3{
    width: 230px;
  }

  .homeBtn:hover{
    cursor: pointer;
  }
</style>
