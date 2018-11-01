import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Profile} from './profile';

@Component({
  selector: 'myProfile',
  templateUrl: './myProfile.component.html',
  styleUrls: ['./myProfile.component.css']
})
export class MyProfileComponent {
  @ViewChild('editTokensTemplate') editTokensTemplate;

  profile: Profile;
  modalRef: BsModalRef;

  constructor(private http: HttpService, private modalService: BsModalService) {
    http.getUserInfo()
      .subscribe(profile => this.profile = profile);
    console.log(this.profile);
  }
  showEditTokensModal() {
    console.log(this.profile);
    this.modalRef = this.modalService.show(this.editTokensTemplate);
  }
}
