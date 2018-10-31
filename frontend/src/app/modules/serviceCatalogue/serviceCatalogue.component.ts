import {Component, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {HttpService} from '../../services/http.service';

@Component({
  selector: 'serviceCatalogue',
  templateUrl: './serviceCatalogue.component.html',
  styleUrls: ['./serviceCatalogue.component.css']
})
export class ServiceCatalogueComponent {
  @ViewChild('acceptVariantsToFollowTemplate') acceptVariantsToFollowTemplate;
  @ViewChild('acceptFollowTemplate') acceptFollowTemplate;


  modalRef: BsModalRef;

  public services: any[];
  indexToFollow: number;

  public currentEditUser: any;
  notOwnedStatus = "notOwned";

  constructor(private http: HttpService, private modalService: BsModalService) {
    http.getServices()
      .subscribe(services => this.services = services);
  }


  getStatus(myServices: any) {
    return myServices.status;
  }
  setIndToFollow(i: number) {
    this.indexToFollow = i;
  }

  showVariantsToFollowModal() {
    this.modalRef = this.modalService.show(this.acceptVariantsToFollowTemplate);
  }
  showAcceptFollowModal() {
    this.modalRef = this.modalService.show(this.acceptFollowTemplate);
  }
  acceptFollowing() {/*проверка на валидность транзакции и установка нового статуса*/}
}
