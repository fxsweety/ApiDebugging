# ApiDebugging using Charles Proxy
This is simple app to use for debugging charles proxy
The app makes a network call to https://storage.googleapis.com/myfirebasedemoproject-2c4d0.appspot.com/lightstatus.json
which returns json response
{
    "name": "Kitchen Light",
    "status": true
}
Based on this response, we update the UI
status = true -> Light UI ON
status = false -> Light UI OFF

Using the different rules in Charles proxy, we can change these values, even return an error status to see how the app responds

