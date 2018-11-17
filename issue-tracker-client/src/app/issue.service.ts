import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {find, map} from 'rxjs/operators';
import {Observable} from 'rxjs';

const endpoint = 'http://localhost:8080/BCC/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class IssueService {


  /*issues: BusinessCard[] = [
    {
      id: 1,
      name: 'issue1',
      phone: 'Some long phone about issue 1',
      address: 'PC6',
      status: 'NEW',
      updated_at: '2018-11-11'
    },
    {
      id: 2,
      name: 'issue2',
      phone: 'Some long phone about issue 1',
      address: 'PC6',
      status: 'DOING',
      updated_at: '2018-11-11'
    },
    {
      id: 3,
      name: 'issue3',
      phone: 'Some long phone about issue 1',
      address: 'PC6',
      status: 'DOING',
      updated_at: '2018-11-11'
    },
    {
      id: 4,
      name: 'issue4',
      phone: 'Some long phone about issue 1',
      address: 'PC6',
      status: 'DONE',
      updated_at: '2018-11-11'
    },
  ];*/

  constructor(private http: HttpClient) {
  }

  getIssues(): Observable<any> {
    return this.http.get(endpoint + 'GetAllBC').pipe(map(this.extractData));
  }

  getIssue(id) {
    return this.http.get(endpoint + 'GetAllBC').pipe(map(this.extractData)).pipe(find(id));
  }

  private extractData(res: Response) {
    return res;
  }
}
