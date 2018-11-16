import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Profile} from './profile';
import {Service} from '../serviceCatalogue/service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import {Router} from '@angular/router';

@Component({
  selector: 'users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
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
  refreshServices() {
    this.http.getServices()
      .subscribe(services => this.services = services);
  }
  createNewService(serviceName: string, basePrice: string, describition: string) {
    this.spinnerService.show();
    this.serviceData = new Service(serviceName, basePrice, describition);
    console.log(this.serviceData);
    this.http.createService(this.serviceData).subscribe(() => {
      this.spinnerService.hide();
      this.refreshServices();
    });
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
      this.users = accounts as Profile[];
      this.isVisibleUsers = true;
    });
  }
  test() {
    console.log('25');
  }
}
