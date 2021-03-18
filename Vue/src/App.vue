<template>
  <div id="app">
    <form action="">
      <label for="Type">Type: </label>
      <select name="Type" >
        <option value="all">ALl</option>
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

export default {
  name: 'App',
  data(){
    return{
      query: {
        text: "",

      },
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
