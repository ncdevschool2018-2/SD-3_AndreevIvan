import {Component, Input, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {HttpService} from '../../services/http.service';
import {Service} from './service';
import {UserIDService} from '../../services/user.id.service';
import {UserService} from '../myServices/userService';

@Component({
  selector: 'serviceCatalogue',
  templateUrl: './serviceCatalogue.component.html',
  styleUrls: ['./serviceCatalogue.component.css']
})
export class ServiceCatalogueComponent {
  @ViewChild('variantsToFollowTemplate') variantsToFollowTemplate;
  @ViewChild('acceptFollowTemplate') acceptFollowTemplate;


  @Input() loggedUserIDObs = this.userIdService.data;
  loggedUserID;
  modalRef: BsModalRef;
  public havingServices: Service[];
  public allServices: Service[];
  idToFollow: number;
  subVariants: any[];
  userIsLogged = false;
  currentNativeServiceId: number;
  setActive = false;

  public currentEditUser: any;
  notOwnedStatus = 'notOwned';
  activeStatus = 'active';

  constructor(private http: HttpService, private modalService: BsModalService, private userIdService: UserIDService) {
    this.loggedUserIDObs.subscribe(loggedUserID => this.loggedUserID = loggedUserID);
    this.loggedUserID = this.userIdService.getID();
    if (this.loggedUserID > -1) {
      this.userIsLogged = true;
      http.getHavingServices(this.loggedUserID)
        .subscribe(services => {
          this.havingServices = services;
          console.log(this.havingServices);
        });
    }
    http.getServices()
      .subscribe(services => {
        this.allServices = services;
      });
  }
  /*операция подписки*/
  subscribeOperation() {
    if (this.userIsLogged) {
      /*тело операции*/
    }
  }
  getServiceStatus(service: Service): string {
    if (this.loggedUserID > -1) {
      this.setActive = false;
      this.currentNativeServiceId = service.id;
      this.havingServices.forEach((havingService) => {
        if (this.currentNativeServiceId === havingService.id) {
          this.setActive = true;
        }
      });
      console.log(this.setActive);
      if (this.setActive) {
        return this.activeStatus;
      } else {
        return this.notOwnedStatus;
      }
    }
  }
  /*получение вариантов конкретной подписки из базы*/
  showVariantsToFollowModal(id: number) {
    this.http.getSubVariants()
      .subscribe(subVariants => this.subVariants = subVariants);
    this.modalRef = this.modalService.show(this.variantsToFollowTemplate);
  }
  showAcceptFollowModal() {
    this.modalRef = this.modalService.show(this.acceptFollowTemplate);
  }
  acceptFollowing() {/*проверка на валидность транзакции и установка нового статуса*/}

  /*getStatus(service: Service) {
    return service.status;
  }*/
  /*showServicesToConsole(services: Service[]) {
    console.log(services);
  }*/
}
