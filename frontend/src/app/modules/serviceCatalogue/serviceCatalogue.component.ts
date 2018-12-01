import {Component, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {HttpService} from '../../services/http.service';
import {Service} from './service';

@Component({
  selector: 'serviceCatalogue',
  templateUrl: './serviceCatalogue.component.html',
  styleUrls: ['./serviceCatalogue.component.css']
})
export class ServiceCatalogueComponent {
  @ViewChild('variantsToFollowTemplate') variantsToFollowTemplate;
  @ViewChild('acceptFollowTemplate') acceptFollowTemplate;


  modalRef: BsModalRef;

  public services: Service[];
  indexToFollow: number;
  subVariants: any[];

  public currentEditUser: any;
  notOwnedStatus = 'notOwned';

  constructor(private http: HttpService, private modalService: BsModalService) {
    http.getServices()
      .subscribe(services => this.services = services);
  }
  /*getStatus(myServices: any) {
    return myServices.status;
  }*/
  setIndToFollow(i: number) {
    this.indexToFollow = i;
  }

  showVariantsToFollowModal() {
    /*получение вариантов конкретной подписки из базы*/
    this.http.getSubVariants()
      .subscribe(subVariants => this.subVariants = subVariants);
    this.modalRef = this.modalService.show(this.variantsToFollowTemplate);
  }
  showAcceptFollowModal() {
    this.modalRef = this.modalService.show(this.acceptFollowTemplate);
  }
  acceptFollowing() {/*проверка на валидность транзакции и установка нового статуса*/}
}
