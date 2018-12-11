import {Component} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalService} from 'ngx-bootstrap';
import {Profile} from '../users/profile';
import { Router } from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import {Service} from '../serviceCatalogue/service';

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
  role: number;
  password: string;
  user: SignUpProfile;
  constructor(private http: HttpService, private router: Router, private spinnerService: Ng4LoadingSpinnerService) {
  }
  createUser(login: string, email: string, password: string) {
    this.spinnerService.show();
    this.status = 'legal';
    this.role = 2;
    this.user = new SignUpProfile(this.login, this.email, this.tokens, this.password, this.status, this.role);
    console.log(this.user);
    this.http.createUser(this.user).subscribe((createdUser) => {
      this.spinnerService.hide();
      localStorage.setItem('loggedUserId', createdUser.id.toString());
      console.log('created user: ', createdUser);
      this.router.navigate(['/serviceCatalogue']);
    });
  }
}
export class SignUpProfile {
  login: string;
  email: string;
  tokens: number;
  password: string;
  status: string;
  role: number;
  services: Service[];

  constructor(login: string, email: string, tokens: number, password: string, status: string, role: number) {
    this.login = login;
    this.email = email;
    this.tokens = tokens;
    this.password = password;
    this.status = status;
    this.role = role;
  }

}
