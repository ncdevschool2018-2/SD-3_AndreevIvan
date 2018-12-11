import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Profile} from './profile';
import {Service} from '../serviceCatalogue/service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import {Router} from '@angular/router';
import {UserService} from '../myServices/userService';

@Component({
  selector: 'users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  @ViewChild('acceptBanUserTemplate') acceptBanUserTemplate;
  @ViewChild('acceptUnbanUserTemplate') acceptUnbanUserTemplate;
  @ViewChild('acceptBanUserServiceTemplate') acceptBanUserServiceTemplate;
  @ViewChild('acceptUnbanUserServiceTemplate') acceptUnbanUserServiceTemplate;
  @ViewChild('addUserTemplate') addUserTemplate;
  @ViewChild('editTokensTemplate') editTokensTemplate;
  @ViewChild('userManageTemplate') userManageTemplate;
  userListItemActive = false;
  isVisibleUsers = false;
  public users: Profile[];
  selectedUser: Profile;
  modalRef: BsModalRef;
  public editMode = false;
  serviceName: string;
  basePrice: string;
  describition: string;
  currentUserTokens: number;
  editedUserService: UserService;
  newCurrentUserTokens: number;
  serviceData: Service;
  public services: Service[];
  constructor(private http: HttpService, private modalService: BsModalService,
              private spinnerService: Ng4LoadingSpinnerService) {
    http.getServices()
      .subscribe(services => this.services = services);
  }
  ngOnInit() {
    this.refreshServices();
  }
  showUserManageModal(user) {
    this.selectedUser = user;
    this.modalRef = this.modalService.show(this.userManageTemplate);
  }
  showEditUserTokensModal() {
    this.modalRef = this.modalService.show(this.editTokensTemplate);
  }
  showAcceptBanUserTemplate() {
    this.modalRef = this.modalService.show(this.acceptBanUserTemplate);
  }
  showAcceptUnbanUserTemplate() {
    this.modalRef = this.modalService.show(this.acceptUnbanUserTemplate);
  }
  showAcceptBanUserServiceTemplate() {
    this.modalRef = this.modalService.show(this.acceptBanUserServiceTemplate);
  }
  showAcceptUnbanUserServiceTemplate() {
    this.modalRef = this.modalService.show(this.acceptUnbanUserServiceTemplate);
  }
  userBanAction() {
    this.selectedUser.status = 'banned';
    this.http.updateUser(this.selectedUser).subscribe(newProfile => {
      this.selectedUser = newProfile;
    });
  }
  userUnbanAction() {
    this.selectedUser.status = 'legal';
    this.http.updateUser(this.selectedUser).subscribe(newProfile => {
      this.selectedUser = newProfile;
    });
  }
  setEditedUserService(userService: UserService) {
    this.editedUserService = userService;
  }
  userServiceBanAction() {
    this.editedUserService.status = 2;
    this.http.createUserService(this.editedUserService).subscribe(userService => {
      this.editedUserService = userService;
    });
  }
  userServiceUnBanAction() {
    this.editedUserService.status = 1;
    this.http.createUserService(this.editedUserService).subscribe(userService => {
      this.editedUserService = userService;
    });
  }
  refreshServices() {
    this.http.getServices()
      .subscribe(services => this.services = services);
  }
  createNewService(serviceName: string, basePrice: string, describition: string) {
    this.spinnerService.show();
    this.serviceData = new Service(null, serviceName, basePrice, describition, null);
    console.log(this.serviceData);
    this.http.createService(this.serviceData).subscribe(() => {
      this.spinnerService.hide();
      this.refreshServices();
    });
  }
  deleteService(id: number) {
    console.log('starting delete service...');
    this.spinnerService.show();
    console.log('showing spinner...');
    console.log(id.toString());
    this.http.deleteService(id.toString()).subscribe(() => {
      this.spinnerService.hide();
      this.refreshServices();
    });
  }
  setMyTokens() {
    this.modalRef.hide();
    this.selectedUser.tokens = this.currentUserTokens;
    this.http.updateUser(this.selectedUser).subscribe(newProfile => {
      this.newCurrentUserTokens = newProfile.tokens;
    });
    console.log('current user tokens after setting: ' + this.newCurrentUserTokens);
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
    this.http.getUsers().subscribe(accounts => {
      // Parse json response into local array
      this.users = accounts;
      this.isVisibleUsers = true;
    });
  }
  test() {
    console.log('25');
  }
}
