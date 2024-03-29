import {BrowserModule} from '@angular/platform-browser';
import {NgModule, ErrorHandler} from '@angular/core';
import {HttpModule} from '@angular/http';
import {IonicApp, IonicModule, IonicErrorHandler} from 'ionic-angular';
import {MyApp} from './app.component';

import {HomePage} from '../pages/home/home';
import {PlayersPage} from '../pages/players/players';
import {TeamsPage} from '../pages/teams/teams';
import {GamesPage} from '../pages/games/games';

import {StatusBar} from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';
import {RestProvider} from '../providers/rest/rest';
import {Model} from '../services/model';
import {TeamsModalPage} from "../pages/teams/modal/teams-modal";
import {GameModalPage} from "../pages/games/modal/game-modal";

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    PlayersPage,
    TeamsPage,
    GamesPage,
    TeamsModalPage,
    GameModalPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    PlayersPage,
    TeamsPage,
    GamesPage,
    TeamsModalPage,
    GameModalPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    RestProvider,
    Model
  ]
})
export class AppModule {
}
