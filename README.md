# Exercise Statistics App

This small app is for trying out making an app in Kotlin that uses Dagger2 and RxJava2.
It pulls information from the Strava API and displays in a pie chart, how many kilometers of cycling, swimming and running were recorded by Strava for the user.

The user needs to authorize the app to access this data. [Strava are making changes to their OAuth process](https://developers.strava.com/docs/oauth-updates/?utm_source=strava&utm_medium=mktgemail&utm_campaign=2018_10_15_API_update)
I may or may not update this app, depending on if I want to use it to try something else out.

If for some reason you want to run the app you will need to get a [Strava Client ID and secret](https://developers.strava.com/).
And then add these as string resources with ids:

* kotlinstravatrial_strava_client_id
* strava_client_secret
