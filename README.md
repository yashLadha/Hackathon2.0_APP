## About the app

This app basically uses three high level api's 
* id's by location
* id's by family id
* id's by aadhar card

basically the the third query relies on second query as in the backend it will search
for the family id in the index. 

This app uses a backend server for api that is using django in the backend and elastic search.

However using elastic search directly would be a very resource intensive task so it is
using api's and using minimal hardware resources for functioning which is makes it fats
and stable.

Uses _Volley_ for network tasks and fetching the response from api. The app is based on
material design. However this api is very generic as it uses JSON for tasks. 

##### ID's by location
We show the designated HOF in that pincode registered. It is easy if someone had forgotten
his card. This will be very helpul in rural as well as urban areas.

##### ID's by familyID
Searches for the details of all the family members based on family id or bhamashah id ,
but the main benefit it has over others is that it uses two indexes and communicate with
each other which makes functioning faster as compared to single index. This also incorporates
the query of ID's by aadhar card as well.

###### We can extend this product further by including more api's from server.
However word of caution is that API url are hardcoded based on the network on which the server is running. 
So please check the internet address before building app. It can be checked using commands `ifconfig and ipconfig`
based on which works perfectly on your machine.

##### Install instructions
* Make sure server is running on the designated network and port
* Change the api url according to that
* Build the app
* Enjoy it!! :smile: