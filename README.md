# Score board

## Story

You recently visited your grandfather who just started to use his new smartphone, but he is a little sceptical about the necessity of it. From all the strange modern devices he prefers the television, because that's where he can hear about the game results of his favorite sport and how his favorite team is doing. You decide that the best way to convice him about how great smartphones are is to write an app for him, where he can check the latest sport results anytime, no need to wait for the evening News to start. At first, you only include one league though.

## What are you going to learn?

- practice working with `JSON` 
- practice the usage of `RxJava` library
- practice the usage of `Retrofit` library
- practice the usage of MVP

## Tasks

1. Create a `ViewPager` main screen with 2 tabs
    - The first tab shows the last 15 events
    - The second tab shows the next 15 events, but the list loads only when the tab is opened
    - The free sport data API is linked below

2. Create a page where you display the scores of the last 15 events in the league. Only the essential data is shown in the list, but there should be an option for the user to click for more details
    - There is a page showing the last 15 events
    - Only the essential data is shown in the list, and there is an option for the user to click for more details
    - The user can also click on the team name to open the detail page about them

3. Create a page where you display the next 15 events in the league Only the essential data is shown in the list, but there should be an option for the user to click for more details
    - There is a page showing the last 15 events
    - Only the essential data is shown in the list, and there is an option for the user to click for more details
    - The user can also click on the team name to open the detail page about them

4. Create a page where you display details about the selected game
    - The data connected to an event is displayed on the event page
    - The data is forwarded from the list view without fetching it again from the API

5. Create a page where details about the selected team are displayed
    - The data is downloaded and displayed from the API by team id

6. The app needs to have a custom icon, big font size, and has to handle device rotation.
    - The application has an icon other than the default
    - The application handles device rotation
    - The font size is huge to provide better readability for people with weak eyesight

## General requirements

- The package name is `com.codecool.scoreboard`, and the name of the application is `Score Board`
- The project is using the MVP architecture pattern
- All colors, dimens, and string resources in the project are extracted into their respective `xml` files
- The project uses the `Retrofit` library to load `JSON` from the APIs
- The project uses the `RxJava` library to handle the API responses asynchronously
- The project uses the `OkHttp` library as an HTTP client

## Hints

None

## Starting your project

To start your project click [this link](https://journey.code.cool/v2/project/team/blueprint/score-board/java), and make sure to **select or create your team**.

## Background materials

- [Sports DB API documentation](https://https://www.thesportsdb.com/api.php)
