<template>
  <div class="resultCard">
    <img v-bind:src="generateImageURL(result.poster_path)" alt="No Image Available" >
    <h3>{{result.title}}</h3>
  </div>
</template>

<script>
export default {
  data(){
    return{

    }
  },
  props: ["result"],
  methods: {
    generateImageURL(url){
      let result = "http://image.tmdb.org/t/p/" + "w185" + url;
      return result;
    }
  }
}
</script>

<style>

</style>