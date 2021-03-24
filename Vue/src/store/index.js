
import Vue from 'vue'
import Vuex from 'vuex'



Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        results: [],
        focus: {},
    },
    mutations: {
        UPDATE_RESULTS(state, payload){
            state.results = payload;
        }
    },
    actions: {
        updateResults({commit}, payload){
            commit('UPDATE_RESULTS', payload)
        }
    },
    getters: {
        getResults(state){
            return state.results.results;
        }
    }

})