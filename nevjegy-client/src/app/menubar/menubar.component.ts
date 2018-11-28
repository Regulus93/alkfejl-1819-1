import { Component} from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.css']
})
export class MenubarComponent {

  constructor(authService: AuthService) {
    this.authService = authService;
  }

  title = 'issue-tracker-client';
  text = 'Login';
  authService: AuthService;

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

  public isLoggedIn(){
    return this.authService.getUser() != null;
  }

}
