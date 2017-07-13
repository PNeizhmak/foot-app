import {Injectable} from '@angular/core';
import {Http, Response, URLSearchParams} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RestProvider {

  private serverUrl = 'http://10.61.20.45:8080';

  private playersAllUrl = this.serverUrl + '/players/all';
  private makeTeamsUrl = this.serverUrl + '/team-balancer/makeTeams';
  private gamesAllUrl = this.serverUrl + '/game/all-games';
  private saveGameUrl = this.serverUrl + '/game/save';
  private teamsByGameIdUrl = this.serverUrl + '/game/find-teams-by-game-id';

  constructor(public http: Http) {
  }

  getPlayers(): Observable<string[]> {
    return this.http.get(this.playersAllUrl)
      .map(RestProvider.extractData)
      .catch(RestProvider.handleError);
  }

  makeTeams(players, teamsCount, balanceWithParent): Observable<string[]> {
    const params: URLSearchParams = new URLSearchParams();
    let ids = players.map(function (p) {
      return p.id;
    }).join(',');
    params.set('playerIds', ids);
    params.set('teamsCount', teamsCount);
    params.set('balanceWithParent', balanceWithParent);
    params.set('createPng', 'false');
    return this.http.get(this.makeTeamsUrl, {
      params: params
    })
      .map(RestProvider.extractData)
      .catch(RestProvider.handleError);
  }

  saveGame(game): Observable<string[]> {
    return this.http.post(this.saveGameUrl, game)
      .map(RestProvider.extractData)
      .catch(RestProvider.handleError);
  }

  getGames(): Observable<string[]> {
    return this.http.get(this.gamesAllUrl)
      .map(RestProvider.extractData)
      .catch(RestProvider.handleError);
  }

  getTeamsByGameId(gameId): Observable<string[]> {
    const params: URLSearchParams = new URLSearchParams();
    params.set('gameId', gameId);
    return this.http.get(this.teamsByGameIdUrl, {
      params: params
    })
      .map(RestProvider.extractData)
      .catch(RestProvider.handleError);
  }

  private static extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private static handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
