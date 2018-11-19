import {Component} from '@angular/core';
import {AuthService} from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [AuthService]
})
export class AppComponent {
  title = 'issue-tracker-client';
  text = 'Login';

  constructor(private authService: AuthService) {
  }


  public changeText() {
    if (this.text === 'Login') {
      this.text = 'Logout';
    }
  }

  public logout() {
    if (this.text === 'Logout') {
      this.authService.logout();
      this.text = 'Login';
    }
  }
}
