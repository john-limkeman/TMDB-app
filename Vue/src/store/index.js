
import Vue from 'vue'
import Vuex from 'vuex'



Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        results: [],
        query: {},
        focus: {},
    },
    mutations: {
        UPDATE_RESULTS(state, payload){
            state.results = payload;
        },
        UPDATE_QUERY(state, payload){
            state.query = payload;
        }
    },
    actions: {
        updateResults({commit}, payload){
            commit('UPDATE_RESULTS', payload)
        },
        updateQuery({commit}, payload){
            commit('UPDATE_QUERY', payload)
        }
    },
    getters: {
        getResults(state){
            return state.results.results;
        },
        getPageTotal(state){
            return state.results.total_pages;
        }
    }

})