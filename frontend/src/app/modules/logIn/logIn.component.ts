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
  login: string;
  password: string;
  private user: Profile;
  modalRef: BsModalRef;
  constructor(private http: HttpService, private modalService: BsModalService,
              private userIdService: UserIDService, private router: Router) {
  }
  signIn(login: string, password: string): void {
    this.http.getUserByLoginAndPassword(login, password).subscribe(
      userRet => {
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
  /*goToMyServices() {
    this.router.navigate(['/myServices']);
  }*/
}
