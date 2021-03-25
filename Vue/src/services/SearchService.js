import axios from 'axios';

const http = axios.create({ baseURL: 'http://localhost:8080' })

export default{
    multiSearch(text, page){
        return http.get(`/search/multi/${text}/${page}`)
    },
    movieSearch(text, page){
        return http.get(`/search/movie/${text}/${page}`)
    }, 
    tvSearch(query){
        return http.get(`/search/tv/${query.text}`)
    },
    actorSearch(query){
        return http.get(`/search/actor/${query.text}`)
    },
    actorTest(){
        return http.get('/test');
    }
}