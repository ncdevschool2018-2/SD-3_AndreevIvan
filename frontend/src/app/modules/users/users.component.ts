import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {template} from '@angular/core/src/render3';

@Component({
  selector: 'users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {
  @ViewChild('addTemplate') addTemplate;
  @ViewChild('editTemplate') editTemplate

  modalRef: BsModalRef;

  public users: any[];

  public addUserName: string;

  public currentEditUser: any

  constructor(private http: HttpService, private modalService: BsModalService) {
    http.getUsers()
      .subscribe(users => this.users = users);
  }

  deleteUser(userIndex: number) {
    const user = this.users[userIndex];

    this.http.deleteUser(user.id)
      .subscribe(() => {
        this.users.splice(userIndex, 1);
      });
  }

  addUser() {
    const newUser = {
      id: Date.now() + '',
      name: this.addUserName
    };

    this.users.push(newUser);
    this.modalRef.hide();
  }

  editUser(userIndex: number) {
    this.currentEditUser = this.users[userIndex];

    this.modalRef = this.modalService.show(this.editTemplate);
  }

  showModal() {
    this.modalRef = this.modalService.show(this.addTemplate);
  }
}
