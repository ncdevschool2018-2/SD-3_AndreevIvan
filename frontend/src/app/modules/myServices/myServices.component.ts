import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {template} from '@angular/core/src/render3';
import {UserService} from './userService';

@Component({
  selector: 'myServices',
  templateUrl: './myServices.component.html',
  styleUrls: ['./myServices.component.css']
})
export class MyServicesComponent {
  @ViewChild('acceptUnfollowTemplate') acceptUnfollowTemplate;

  modalRef: BsModalRef;

  public myServices: UserService[];
  indexToDelete: number;

  constructor(private http: HttpService, private modalService: BsModalService) {
    http.getUserServices(1)
      .subscribe(services => this.myServices = services);
  }
  /*deleteServiceFromMyServices(serviceIndex: number) {
    console.log(this.myServices);
    const service = this.myServices[serviceIndex];

    this.http.deleteServiceFromMyServices(service.id)
      .subscribe(() => {
        this.myServices.splice(serviceIndex, 1);
      });
  }*/

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
