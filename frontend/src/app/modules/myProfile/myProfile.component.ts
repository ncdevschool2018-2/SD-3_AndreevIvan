import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Profile} from '../users/profile';
import {UserIDService} from '../../services/user.id.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'myProfile',
  templateUrl: './myProfile.component.html',
  styleUrls: ['./myProfile.component.css']
})
export class MyProfileComponent {
  @ViewChild('editTokensTemplate') editTokensTemplate;

  profile: Profile;
  modalRef: BsModalRef;
  currentUserId: number;
  tokens: number;
  newTokens: number;
  http2: HttpService;
  httpClient: HttpClient;
  userIsLogged = false;
  loggedUserID: number;

  constructor(private http: HttpService, private modalService: BsModalService,
              private userIdService: UserIDService) {
    // this.currentUserId = NumberConverter(this.userIdService.getID());
    this.currentUserId = parseInt(localStorage.getItem('loggedUserId'), 10);
    console.log(this.currentUserId);
    if (this.currentUserId > -1) {
      this.userIsLogged = true;
      this.http.getUserById(this.currentUserId)
        .subscribe(profile => this.profile = profile);
    }
  }
  logOut() {
    localStorage.setItem('loggedUserId', '-1');
  }
  refresh(): void {
    window.location.reload();
  }
  showEditTokensModal() {
    console.log(this.profile);
    this.modalRef = this.modalService.show(this.editTokensTemplate);
  }
  setMyTokens() {
    this.modalRef.hide();
    this.profile.tokens = this.tokens;
    this.http.updateUser(this.profile).subscribe(newProfile => this.newTokens = newProfile.tokens);
    console.log('current user tokens after setting: ' + this.newTokens);
  }
}

export var NumberConverter = (value: any) => {
  if (value === null || value === undefined || typeof value === 'number')
    return value;

  return parseInt(value.toString());
}

