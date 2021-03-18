<template>
  <div id="app">
    <form action="">
      <input type="text" name="search" id="searchInput" placeholder="Search..." v-model="query">
      <button >SEARCH</button>
    </form>
  </div>
</template>

<script>

export default {
  name: 'App',
  data(){
    return{
      query: "",
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
