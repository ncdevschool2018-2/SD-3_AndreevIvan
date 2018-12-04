import {Component} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {UserIDService} from '../../services/user.id.service';
import {Profile} from '../users/profile';
import {Router} from '@angular/router';
import {timeout} from 'rxjs/operators';

@Component({
  selector: 'logIn',
  templateUrl: './logIn.component.html',
  styleUrls: ['./logIn.component.css']
})
export class LogInComponent {
  login: string;
  password: string;
  private user: Profile;
  constructor(private http: HttpService, private userIdService: UserIDService, private router: Router) {
  }
  signIn(login: string, password: string): void {
    this.http.getUserByLoginAndPassword(login, password).subscribe(
      userRet => {this.user = userRet;
        console.log('userId into sign in: ' + this.user.id);
        this.userIdService.setID(this.user.id);
        this.router.navigate(['/myServices']);
        // this.router.navigate(['/myServices']);
      });
  }
  /*goToMyServices() {
    this.router.navigate(['/myServices']);
  }*/
}
