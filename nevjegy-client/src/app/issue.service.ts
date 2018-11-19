import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {filter, find, map, tap} from 'rxjs/operators';
import {Observable, pipe} from 'rxjs';
import {BusinessCard} from './BusinessCard';

const bccEndpoint = 'http://localhost:8080/BCC/';
const userEndpoint = 'http://localhost:8080/BCC/user/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': btoa('admin1:1234567')
  })
};

@Injectable({
  providedIn: 'root'
})
export class IssueService {

  constructor(private http: HttpClient) {
  }

  getIssues(): Observable<BusinessCard[]> {
    console.log(httpOptions.headers.get('Authorization'));
    return this.http.get<BusinessCard[]>(bccEndpoint + 'getAllBC');
  }

  getIssue(id): Observable<BusinessCard[]> {
    return this.http.get<BusinessCard[]>(bccEndpoint + 'getAllBC', httpOptions).pipe(map(data => data.filter(bc => bc.id === id)));
  }

  postIssue(bc: BusinessCard): void {
    this.http.put(userEndpoint + 'updateBC', bc, httpOptions).subscribe();
  }
}
