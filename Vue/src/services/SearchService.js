import axios from 'axios';

const http = axios.create({ baseURL: 'http://localhost:8080' })

export default{
    multiSearch(query){
        return http.get('/search/multi', query)
    },
    movieSearch(query){
        return http.get('/search/movie', query)
    }, 
    tvSearch(query){
        return http.get('/search/tv', query)
    },
    actorSearch(query){
        return http.get('/search/actor', query)
    }
}