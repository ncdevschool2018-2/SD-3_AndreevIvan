import {Component} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalService} from 'ngx-bootstrap';
import {Profile} from '../users/profile';
import { Router } from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'signUp',
  templateUrl: './signUp.component.html',
  styleUrls: ['./signUp.component.css']
})
export class SignUpComponent {
  login: string;
  email: string;
  tokens = 0;
  status: string;
  password: string;
  user: Profile;
  constructor(private http: HttpService, private router: Router, private spinnerService: Ng4LoadingSpinnerService) {
  }
  createUser(login: string, email: string, password: string) {
    this.spinnerService.show();
    this.status = 'unbanned';
    this.user = new Profile(this.login, this.email, this.tokens, this.password, this.status);
    this.http.createUser(this.user).subscribe(() => {
      this.spinnerService.hide();
      this.router.navigate(['/myServices']);
    });
  }
}
