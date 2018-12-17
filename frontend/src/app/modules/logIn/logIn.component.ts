import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {UserIDService} from '../../services/user.id.service';
import {Profile} from '../users/profile';
import {Router} from '@angular/router';
import {timeout} from 'rxjs/operators';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';

@Component({
  selector: 'logIn',
  templateUrl: './logIn.component.html',
  styleUrls: ['./logIn.component.css']
})
export class LogInComponent {
  @ViewChild('userBannedTemplate') userBannedTemplate;
  @ViewChild('unknownUserTemplate') unknownUserTemplate;
  login: string;
  password: string;
  authInfo: AuthInfo;
  private user: Profile;
  modalRef: BsModalRef;
  constructor(private http: HttpService, private modalService: BsModalService,
              private userIdService: UserIDService, private router: Router) {
  }
  signIn(login: string, password: string): void {
    this.authInfo = new AuthInfo(login, password);
    this.http.getUserByLoginAndPassword(this.authInfo).subscribe(
      userRet => {
        if (!userRet) {
          this.showUnknownUserModal();
          return;
        }
        if (userRet.status === 'banned') {
          this.showUserBannedModal();
          return;
        }
        this.user = userRet;
        console.log('userId into sign in: ' + this.user.id);
        this.userIdService.setID(this.user.id);
        localStorage.setItem('loggedUserId', this.user.id.toString());

        this.router.navigate(['/myServices']);
        // this.router.navigate(['/myServices']);
      });
  }
  showUserBannedModal() {
    this.modalRef = this.modalService.show(this.userBannedTemplate);
  }
  showUnknownUserModal() {
    this.modalRef = this.modalService.show(this.unknownUserTemplate);
  }
  /*goToMyServices() {
    this.router.navigate(['/myServices']);
  }*/
}
export class AuthInfo {
  login: string;
  password: string;
  constructor(login: string, password: string) {
    this.login = login;
    this.password = password;
  }
}
