import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../classes/user';
import {Observable} from 'rxjs';

@Injectable()
export class AuthService {
  private static api = 'http://localhost:8080/auth';
  public static user: User;

  constructor(
    private http: HttpClient
  ) {
  }

  public logout(): void {
    this.http.get(AuthService.api + '/logout').subscribe(() => {
      this.setUser(undefined);
    });
  }

  public login(userName: string, password: string): Observable<User> {
    return this.http.post(AuthService.api + '/login', {
      userName,
      password
    }) as Observable<User>;
  }

  public setUser(user: User) {
    AuthService.user = user;
  }

  public getUser(): User {
    return AuthService.user;
  }

  public syncLoginStatus(): void {
    this.http.get(AuthService.api + '/user').subscribe((user: User) => {
      if (user) {
        this.setUser(user);
      }
    });
  }

  public hasRole(role) {
    if (!this.getUser()) {
      return false;
    }
    return this.getUser().role === role;
  }
}
