# Popular-Movies-APP-Stage1
Udacity Nanodegree Android Developre project 2 Popular Movie APP satge1

hello,
you need to add your API-key just in once file (GetDataFromInternet class) , in getResponseFromHttpUrl method 

if(sortingType.equals("popular")){
    base_URL =
 "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=[your_API_Key]";
    }else{
         base_URL =
 "http://api.themoviedb.org/3/discover/movie?certification_country=US&certification=R&sort_by=vote_average.desc&api_key=[your_API_Key]";
        }



