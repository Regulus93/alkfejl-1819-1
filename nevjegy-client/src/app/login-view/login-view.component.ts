import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../services/auth.service';
import {User} from '../classes/user';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-login-view',
  templateUrl: './login-view.component.html',
  styleUrls: ['./login-view.component.css'],
  providers: [AuthService]
})
export class LoginViewComponent implements OnInit {
  private error: boolean;
  private from: string;

  constructor(
    private activatedRoute: ActivatedRoute,
    private authService: AuthService,
    private router: Router,
    private component: AppComponent
  ) {
  }

  ngOnInit() {
    this.from = this.activatedRoute.snapshot.queryParamMap.get('from');
  }

  private tryLogin(email: string, password: string): void {
    this.authService.login(email, password).subscribe((user) => {
      console.log(user);
      this.authService.setUser(user as User);
      if (this.from) {
        this.router.navigate(['/' + this.from]);
      } else {
        this.router.navigate(['/']);
      }
      this.component.changeText();
    }, (err) => {
      if (err.status === 403) {
        this.error = true;
      }
    });
  }

}
