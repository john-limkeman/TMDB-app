import axios from 'axios';

const http = axios.create({ baseURL: 'http://localhost:8080' })

export default{
    multiSearch(query){
        return http.get(`/search/multi/${query.text}`)
    },
    movieSearch(query){
        return http.get(`/search/movie/${query.text}`)
    }, 
    tvSearch(query){
        return http.get(`/search/tv/${query.text}`)
    },
    actorSearch(query){
        return http.get(`/search/actor/${query.text}`)
    }
}