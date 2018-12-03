import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {filter, find, map, tap} from 'rxjs/operators';
import {Observable, pipe} from 'rxjs';
import {BusinessCard} from '../BusinessCard';

const bccEndpoint = 'http://localhost:8080/BCC/';
const userEndpoint = 'http://localhost:8080/BCC/user/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': btoa('admin1:123456')
  })
};

@Injectable({
  providedIn: 'root'
})
export class BccService {

  constructor(private http: HttpClient) {
  }

  // ALL BC
  getBccs(): Observable<BusinessCard[]> {
    console.log(httpOptions.headers.get('Authorization'));
    return this.http.get<BusinessCard[]>(bccEndpoint + 'getAllBC');
  }

  // BC BY ID
  getBcc(id): Observable<BusinessCard[]> {
    return this.http.get<BusinessCard[]>(bccEndpoint + 'getBCById?bcId=' + id, httpOptions);
  }

  // BC update
  updateBc(bc: BusinessCard): Observable<BusinessCard> {
    return this.http.put(userEndpoint + 'updateBC', bc, httpOptions);
  }

  // BC post
  postBc(bc: BusinessCard): Observable<BusinessCard> {
    return this.http.post(userEndpoint + 'createBC', bc, httpOptions);
  }

  // Feedbacks by bc id
  getFeedback(id) {
    return this.http.get<BusinessCard[]>(bccEndpoint + 'getFeedbacks/' + id, httpOptions);
  }

  // Delete by id
  deleteBc(id): Observable<BusinessCard[]> {
    return this.http.delete<BusinessCard[]>(userEndpoint + 'deleteBC', httpOptions);
  }

  collectBc(id): Observable<BusinessCard[]> {
    return this.http.post<BusinessCard[]>(userEndpoint + 'collectBC?bcId=' + id, httpOptions);
  }

  dropBc(id): Observable<BusinessCard[]> {
    return this.http.post<BusinessCard[]>(userEndpoint + 'dropBC?bcId=' + id, httpOptions);
  }

  addFeedback(feedback: Feedback, id): Observable<Feedback> {
    return this.http.post(userEndpoint + 'addFeedback?=bcId' + id, feedback, httpOptions);
  }

  removeFeedback(id): Observable<Feedback> {
    return this.http.post(userEndpoint + 'removeFeedback?=bcId' + id, httpOptions);
  }
}
