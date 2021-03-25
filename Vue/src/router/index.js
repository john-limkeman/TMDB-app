import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import ResultListing from '../views/ResultListing.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/results/:text/:page',
    name: 'ResultListing',
    component: ResultListing
  },
  
]

const router = new VueRouter({
    routes
  })

  export default router