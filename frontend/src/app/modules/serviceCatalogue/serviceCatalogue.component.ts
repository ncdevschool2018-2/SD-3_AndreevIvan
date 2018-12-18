import {Component, Input, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {HttpService} from '../../services/http.service';
import {Service} from './service';
import {UserIDService} from '../../services/user.id.service';
import {UserService} from '../myServices/userService';
import {Profile} from '../users/profile';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';

@Component({
  selector: 'serviceCatalogue',
  templateUrl: './serviceCatalogue.component.html',
  styleUrls: ['./serviceCatalogue.component.css']
})
export class ServiceCatalogueComponent {
  @ViewChild('variantsToFollowTemplate') variantsToFollowTemplate;
  @ViewChild('acceptFollowTemplate') acceptFollowTemplate;
  @ViewChild('successfulOperation') successfulOperation;
  @ViewChild('badOperation') badOperation;


  /*@Input() loggedUserIDObs = this.userIdService.data;
  loggedUserID;*/
  loggedUserID: number;
  modalRef: BsModalRef;
  public allServices: Service[];
  idToFollow: number;
  subVariants: any[];
  userIsLogged = false;
  setActive = false;
  loggedUser: Profile;
  serviceToFollow: Service;
  newUserServiceData: UserService;
  variantToSubscribe: number;
  periodToSubscribe: number;
  daysToSubscribe: number;
  test: string;

  public currentEditUser: any;
  notOwnedStatus = 'notOwned';
  activeStatus = 'active';

  constructor(private http: HttpService, private modalService: BsModalService, private userIdService: UserIDService,
              private spinnerService: Ng4LoadingSpinnerService) {
    // this.loggedUserIDObs.subscribe(loggedUserID => this.loggedUserID = loggedUserID);
    this.loggedUserID = parseInt(localStorage.getItem('loggedUserId'), 10);
    console.log(this.loggedUserID);
    if (this.loggedUserID > -1) {
      this.userIsLogged = true;
      http.getServices()
        .subscribe(services => {
          this.allServices = services;
          console.log(this.allServices);
        });
      this.http.getUserById(this.loggedUserID)
        .subscribe(user => {
          this.loggedUser = user;
          console.log(this.loggedUser);
        });
    }
  }
  /*операция подписки*/
  subscribeOperation() {
    this.spinnerService.show();
    if (this.userIsLogged) {
      this.daysToSubscribe = this.periodToSubscribe;
      if (this.daysToSubscribe > 30) {
        this.daysToSubscribe = 0;
      }
      console.log('user id: ', this.loggedUserID.toString());
      this.newUserServiceData = new UserService(this.daysToSubscribe, 1, this.serviceToFollow.name,
        parseInt(this.serviceToFollow.basePrice, 10), this.periodToSubscribe,
        parseInt(this.loggedUserID.toString(), 10), this.serviceToFollow.id, null, this.variantToSubscribe);
      console.log(this.newUserServiceData);
      this.http.createUserService(this.newUserServiceData).subscribe((createdService) => {
        this.refreshServices();
        this.spinnerService.hide();
        if (createdService.id > 0) {
          this.showSuccessful();
        } else {
          this.badOperation();
        }
      });
    }
  }
  refreshWindow(): void {
    window.location.reload();
  }
  refreshServices() {
    console.log('refreshing...');
    this.http.getServices()
      .subscribe(services => {
        this.allServices = services;
        console.log(this.allServices);
      });
  }
  setServiceToSubscribe(service: Service) {
    this.serviceToFollow = service;
  }
  getServiceStatus(service: Service): string {
    if (this.loggedUserID > -1) {
        this.setActive = false;
        this.loggedUser.userServices.forEach((userService) => {
          if (service.id === userService.serviceId) {
            this.setActive = true;
          }
        });
        if (this.setActive) {
          return this.activeStatus;
        } else {
          return this.notOwnedStatus;
        }
    }
  }
  toShowSubscribeButton(status: string): boolean {
    if (status === this.activeStatus) {
      return false;
    } else {
      return true;
    }
  }
  /*получение вариантов конкретной подписки из базы*/
  showVariantsToFollowModal(id: number) {
    this.http.getSubVariants()
      .subscribe(subVariants => this.subVariants = subVariants);
    this.modalRef = this.modalService.show(this.variantsToFollowTemplate);
  }
  showAcceptFollowModal(i: number, days: string) {
    this.variantToSubscribe = i;
    this.periodToSubscribe = parseInt(days, 10);
    this.modalRef = this.modalService.show(this.acceptFollowTemplate);
  }
  showSuccessful() {
    this.modalRef = this.modalService.show(this.successfulOperation);
  }
  showBad() {
    this.modalRef = this.modalService.show(this.badOperation);
  }
  /*getStatus(service: Service) {
    return service.status;
  }*/
  /*showServicesToConsole(services: Service[]) {
    console.log(services);
  }*/
}
