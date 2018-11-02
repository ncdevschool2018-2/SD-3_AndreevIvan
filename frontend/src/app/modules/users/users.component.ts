import {Component, ViewChild} from '@angular/core';
import {HttpService} from '../../services/http.service';
import {BsModalRef, BsModalService} from 'ngx-bootstrap';
import {Profile} from './profile';


@Component({
  selector: 'users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {
  @ViewChild('addUserTemplate') addUserTemplate;
  @ViewChild('editNameTemplate') editNameTemplate;
  @ViewChild('editTokensTemplate') editTokensTemplate;

  isVisibleUsers = false;
  public users: Profile[];

  public addUserName: string;

  public currentEditUser: any;

  constructor(private http: HttpService, private modalService: BsModalService) {
  }
  onBlur() {
    this.isVisibleUsers = false;
  }
  onFocus() {
    this.http.getBillingAccounts().subscribe(accounts => {
      // Parse json response into local array
      this.users = accounts as Profile[];
      this.isVisibleUsers = true;
    });
  }
  /*deleteUser(userIndex: number) {
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

    this.modalRef = this.modalService.show(this.editNameTemplate);
  }

  showModal() {
    this.modalRef = this.modalService.show(this.addUserTemplate);
  }
  editUserTokens(userIndex: number) {
    this.currentEditUser = this.users[userIndex];

    this.modalRef = this.modalService.show(this.editTokensTemplate);
  }
  searchUserByLogin() {
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
