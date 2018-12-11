import {Component, Input, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {template} from '@angular/core/src/render3';
import {UserService} from './userService';
import {UserIDService} from '../../services/user.id.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'myServices',
  templateUrl: './myServices.component.html',
  styleUrls: ['./myServices.component.css']
})
export class MyServicesComponent {
  @ViewChild('acceptUnfollowTemplate') acceptUnfollowTemplate;

  modalRef: BsModalRef;

  /*@Input() loggedUserIDObs = this.userIdService.data;
  loggedUserID;*/
  loggedUserID: number;
  public myServices: UserService[];
  indexToDelete: number;

  constructor(private http: HttpService, private modalService: BsModalService, private userIdService: UserIDService) {
    /*this.loggedUserIDObs.subscribe(loggedUserID => this.loggedUserID = loggedUserID);
    this.loggedUserID = this.userIdService.getID();*/
    this.loggedUserID = parseInt(localStorage.getItem('loggedUserId'), 10);
    console.log('userId into my services: ' + this.loggedUserID);
    if (this.loggedUserID > -1) {
      http.getUserServices(this.loggedUserID)
        .subscribe(services => this.myServices = services);
    }
    console.log(this.myServices);
  }
  deleteMyService(id: number) {
    this.http.deleteUserService(id.toString()).subscribe(() => {
      this.refreshMyServices();
    });
  }
  refreshMyServices() {
    this.http.getUserServices(this.loggedUserID)
      .subscribe(services => this.myServices = services);
  }
  setIndToDelete(i: number) {
    this.indexToDelete = i;
  }

  showAcceptUnfollowModal() {
    this.modalRef = this.modalService.show(this.acceptUnfollowTemplate);
  }
  /*searchUserByLogin() {
    this.http.get('https://api.myjson.com/bins/1gb9tf')
      .subscribe((res: Response) => {
        this.result = res.json();
        this.displayItems = this.result['results'];
      }, error => {
        console.log(error);
        this.errorFromSubscribe = error;
      });
  }*/
}
