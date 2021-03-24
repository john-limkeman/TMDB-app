<template>
  <div>
    <img v-bind:src="generateImageURL(result.poster_path)" alt="">
    <h3>{{result.name}}</h3>
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
      let result = "http://image.tmdb.org/t/p/" + "w92" + url;
      return result;
    }
  }
}
</script>

<style>

</style>