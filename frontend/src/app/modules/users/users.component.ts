import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Profile} from './profile';

@Component({
  selector: 'users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {
  @ViewChild('addUserTemplate') addUserTemplate;
  @ViewChild('editTokensTemplate') editTokensTemplate;
  @ViewChild('userManageTemplate') userManageTemplate;
  userListItemActive = false;
  isVisibleUsers = false;
  public users: Profile[];
  modalRef: BsModalRef;

  constructor(private http: HttpService, private modalService: BsModalService) {
  }
  showUserManageModal(i) {
    this.modalRef = this.modalService.show(this.userManageTemplate);
  }

  isUserListItemActive() {
    return this.userListItemActive;
  }
  onBlurUserListItem() {
    this.userListItemActive = false;
  }
  onFocusUserListItem() {
    this.userListItemActive = true;
  }
  onBlurSearchForm() {
    this.isVisibleUsers = false;
  }
  onFocusSearchForm() {
    this.http.getBillingAccounts().subscribe(accounts => {
      // Parse json response into local array
      this.users = accounts as Profile[];
      this.isVisibleUsers = true;
    });
  }
}
